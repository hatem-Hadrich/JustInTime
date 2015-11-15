package com.glid.justintime.fragment;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import com.gc.materialdesign.views.ButtonFlat;

import java.util.Calendar;

public class TimePickerFragment extends android.app.DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    private ButtonFlat changeTime;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        String min = (minute < 10 ? "0" : "") + minute;
        String hour = (hourOfDay < 10 ? "0" : "") + hourOfDay;

        if (changeTime != null) {
            changeTime.setText(hour + ":" + min);
        }
    }
}