package com.glid.justintime.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import com.gc.materialdesign.views.ButtonFlat;

import java.util.Calendar;
import java.util.Date;

public class DatePicker extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private ButtonFlat changeDate;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        DatePickerDialog datePicker = new DatePickerDialog(getActivity(), this, year, month, day);
        datePicker.getDatePicker().setMinDate(new Date().getDate());
        return datePicker;
    }

    public void onDateSet(android.widget.DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        String mDay = (day < 10 ? "0" : "") + day;
        String mMonth = (month < 10 ? "0" : "") + month;
        String mYear = (year < 10 ? "0" : "") + year;

        if (changeDate != null) {
            changeDate.setText(mDay + "/" + mMonth + "/" + mYear);
        }
    }
}


