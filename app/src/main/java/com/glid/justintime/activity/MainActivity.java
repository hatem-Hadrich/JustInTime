package com.glid.justintime.activity;

import android.content.Intent;
import android.os.Bundle;

import com.glid.justintime.R;
import com.glid.justintime.fragment.HomeFragment;
import com.glid.justintime.fragment.LogOut;
import com.glid.justintime.fragment.MapFragment;
import com.glid.justintime.fragment.ProfilsList;
import com.glid.justintime.services.AlertService;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.listeners.MaterialAccountListener;

/*
*activity principale qui contient les autres fargments
*/
public class MainActivity extends MaterialNavigationDrawer implements MaterialAccountListener {

    @Override
    public void init(Bundle savedInstanceState) {

        // add accounts
        MaterialAccount account = new MaterialAccount(this.getResources(), "", "   Just In Time ", R.drawable.fiat_logo, R.drawable.car_cover);
        this.addAccount(account);

        // create sections
        this.addSection(newSection("Home", R.drawable.home, new HomeFragment()).setSectionColor(this.getResources().getColor(R.color.main_color)));

        this.addSection(newSection("MapFragment", R.drawable.statistic, new MapFragment()).setSectionColor(this.getResources().getColor(R.color.main_color)));

        this.addSection(newSection("Profils", R.drawable.consumption, new ProfilsList()).setSectionColor(this.getResources().getColor(R.color.main_color)));

        this.addSection(newSection("Log-Out", R.drawable.diary, new LogOut()).setSectionColor(this.getResources().getColor(R.color.main_color)));


        // create bottom section
        this.addBottomSection(newSection("configuration", R.drawable.configuration, new Intent(getApplication(), Config.class)));

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // force initializing the reminders alerts service
        Intent intent = new Intent();
        intent.setAction("com.glid.justintime.action.INIT");
        sendBroadcast(intent);
        startService(new Intent(this, AlertService.class));

    }


    @Override
    public void onAccountOpening(MaterialAccount account) {


    }

    @Override
    public void onChangeAccount(MaterialAccount newAccount) {

    }


}
