package com.glid.justintime.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import com.glid.justintime.R;
import com.glid.justintime.data.DiaryListSingleton;
import com.glid.justintime.wrapper.DiaryItemWrapper;
import com.glid.justintime.wrapper.ModelItemWrapper;

import net.appkraft.parallax.ParallaxScrollView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by hatem .
 * c'est l'activity de saisie d'un nouveau contact .
 */

public class AddContact extends AppCompatActivity {

    public static final int CONTACT_ADD_REQUEST_CODE = 6000;
    public static final int CONTACT_ADD_ACTION_ID = 4;
    public static final int CONTACT_NoACTION_ACTION_ID = 3;
    public static final String CONTACT_ACTION_KEY = "contact action";
    public static final String TITLE = "New Contact";
    private DiaryListSingleton mDiaryListSingleton = DiaryListSingleton.getInstance();
    private DiaryItemWrapper mContact;
    private EditText mTitle;
    private EditText mNumber;
    private ParallaxScrollView mParallax;
    private ImageView mImage;
    private CircleImageView mTypePic;
    private ModelItemWrapper mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_add);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(TITLE);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xffb71c1c));
        mParallax = (ParallaxScrollView) findViewById(R.id.scrollView1);
        mImage = (ImageView) findViewById(R.id.imageView1);
        mParallax.setImageViewToParallax(mImage);
        mTitle = (EditText) findViewById(R.id.title);
        mNumber = (EditText) findViewById(R.id.number);

        mModel = new ModelItemWrapper();
        mTypePic = (CircleImageView) findViewById(R.id.type_pic);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public DiaryItemWrapper createItem() {

        DiaryItemWrapper item = new DiaryItemWrapper();
        boolean test = true;
        if (mTitle.getText().length() == 0) {
            mTitle.setHintTextColor(Color.LTGRAY);
            test = false;
        } else if (mNumber.getText().length() == 0) {
            mNumber.setHintTextColor(Color.LTGRAY);
            test = false;
        }
        if (test) {

            item.setIndice(mModel.getId());
            item.setTitle(mTitle.getText().toString());
            item.setNumber(mNumber.getText().toString());

            return item;
        }

        return null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                addPerform();
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    private void addPerform() {
        Log.v("imen", "up button clicked");
        Intent intent = new Intent();
        mContact = createItem();
        if (mContact != null) {
            mDiaryListSingleton.addContact(0, mContact);
            intent.putExtra(CONTACT_ACTION_KEY, CONTACT_ADD_ACTION_ID);
            setResult(Activity.RESULT_OK, intent);
        } else
            intent.putExtra(CONTACT_ACTION_KEY, CONTACT_NoACTION_ACTION_ID);

        finish();
        overrideTransition();

    }

    @Override
    public void onBackPressed() {
        addPerform();
        super.onBackPressed();
    }

    public void overrideTransition() {
        overridePendingTransition(R.transition.open_main, R.transition.close_next);
    }


}
