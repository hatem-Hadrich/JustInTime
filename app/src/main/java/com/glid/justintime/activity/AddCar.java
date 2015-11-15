package com.glid.justintime.activity;

import android.content.ContentValues;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.glid.justintime.R;
import com.glid.justintime.data.Utilities;

/**
 * Created by omar on 4/12/15.
 */

public class AddCar extends AppCompatActivity {

    private EditText carName;
    private EditText serialNumber;
    private EditText brand;
    private DatePicker dateBuying;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_car);

        getSupportActionBar().setTitle(R.string.add_car);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xffb71c1c));

        carName = (EditText) findViewById(R.id.carName);
        serialNumber = (EditText) findViewById(R.id.serialNumber);
        brand = (EditText) findViewById(R.id.brand);
        dateBuying = (DatePicker) findViewById(R.id.dialog_date_datePicker);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overrideTransition();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                saveCar();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }


    public void overrideTransition() {
        overridePendingTransition(R.transition.open_main, R.transition.close_next);
    }


    public void saveCar() {

        final ContentValues values = new ContentValues();

        long timeStamp = Utilities.convertToTimeStamp(dateBuying.getDayOfMonth() + "/" + dateBuying.getMonth() + "/" + dateBuying.getYear());

        String name = carName.getText().toString().trim();
        String carBrand = brand.getText().toString().trim();
        String serial = serialNumber.getText().toString().trim();

        if (name.length() == 0) {
            Toast.makeText(getApplicationContext(), "Car name should not be empty", Toast.LENGTH_LONG).show();
            return;
        }

        if (brand.length() == 0) {
            Toast.makeText(getApplicationContext(), "Car brand should not be empty", Toast.LENGTH_LONG).show();
            return;
        }

        if (serial.length() == 0) {
            Toast.makeText(getApplicationContext(), "Car serial should not be empty", Toast.LENGTH_LONG).show();
            return;
        }

        finish();
        overrideTransition();

    }


}
