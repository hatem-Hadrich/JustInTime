package com.glid.justintime.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.glid.justintime.R;


/**
 * Created by hatem.
 */
public class LogOut extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View mRootView = inflater.inflate(R.layout.profils_list, container, false);

        setHasOptionsMenu(true);
        return mRootView;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        //outState.putSerializable(LIST_CONTENT_KEY, mObjectList);
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onResume() {
        super.onResume();
    }


}