package com.glid.justintime.activity;

import android.content.ContentValues;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.glid.justintime.R;
import com.glid.justintime.data.Utilities;

import net.appkraft.parallax.ParallaxScrollView;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by hatem.
 */

public class CarDetails extends AppCompatActivity {

    private ParallaxScrollView parallax;
    private ImageView image;
    private EditText carName;
    private EditText carSerialNumber;
    private EditText carBrand;
    private DatePicker carDateBuying;
    private String carID;
    private String name;
    private String brand;
    private String serial;
    private String datebuying;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_car);

        getSupportActionBar().setTitle("Car Edit");

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xffb71c1c));

        parallax = (ParallaxScrollView) findViewById(R.id.scrollView1);
        image = (ImageView) findViewById(R.id.imageView1);
        parallax.setImageViewToParallax(image);


        carName = (EditText) findViewById(R.id.carName);
        carSerialNumber = (EditText) findViewById(R.id.serialNumber);
        carBrand = (EditText) findViewById(R.id.brand);
        carDateBuying = (DatePicker) findViewById(R.id.dialog_date_datePicker);


        //Bundle extras = getIntent().getExtras();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        final MaterialDialog mMaterialDialog = new MaterialDialog(this);
        mMaterialDialog.setTitle("Info");

        int id = item.getItemId();
        if (id == R.id.action_save) {


            mMaterialDialog
                    .setMessage("Would you like to save these changes ? ");


        } else if (id == R.id.action_remove) {
            mMaterialDialog
                    .setMessage("Would you like to remove this car ?");

        }
        mMaterialDialog.setNegativeButton("CANCEL", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.dismiss();
            }
        });

        mMaterialDialog.show();
        return super.onOptionsItemSelected(item);
    }

    private ContentValues getFieldValues() {

        long timeStamp = Utilities.convertToTimeStamp(carDateBuying.getDayOfMonth() + "/" + carDateBuying.getMonth() + "/" + carDateBuying.getYear());
        ContentValues cv = new ContentValues();
        name = carName.getText().toString().trim();
        brand = carBrand.getText().toString().trim();
        serial = carSerialNumber.getText().toString().trim();

        if (name.length() == 0) {
            Toast.makeText(getApplicationContext(), "Car name should not be empty", Toast.LENGTH_LONG).show();
            return null;
        }

        if (brand.length() == 0) {
            Toast.makeText(getApplicationContext(), "Car brand should not be empty", Toast.LENGTH_LONG).show();
            return null;
        }

        if (serial.length() == 0) {
            Toast.makeText(getApplicationContext(), "Car serial should not be empty", Toast.LENGTH_LONG).show();
            return null;
        }


        return cv;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail_car, menu);
        return true;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overrideTransition();
        finish();
    }

    public void overrideTransition() {
        overridePendingTransition(R.transition.open_main, R.transition.close_next);
    }


}
