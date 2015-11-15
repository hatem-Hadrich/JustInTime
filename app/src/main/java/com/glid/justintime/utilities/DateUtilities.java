package com.glid.justintime.utilities;

import android.content.Context;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hatem.
 */
public class DateUtilities {


    private static final String EXPENSE_TYPE_DRAWABLE_PREFIX = "ic_expense_type_";
    private static final String CONTACT_TYPE_DRAWABLE_PREFIX = "ic_contact_type_";

    public static long convertToTimeStamp(String myDate) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(myDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    public static long convertFullDateToTimeStamp(String myDate) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = null;
        try {
            date = dateFormat.parse(myDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    public static long convertTimeToTimeStamp(String myTime) {

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = null;
        try {
            date = dateFormat.parse(myTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    public static int getMonthOfDateString(String myDate) {
        int month = 0;
        Date date = null;
        DateFormat dateFormat = SimpleDateFormat.getDateInstance();


        try {
            date = dateFormat.parse(myDate);
            month = dateFormat.getCalendar().get(Calendar.MONTH);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return month;
    }

    public static int getDayOfDateString(String myDate) {
        int day = 0;
        Date date = null;
        DateFormat dateFormat = SimpleDateFormat.getDateInstance();

        try {
            date = dateFormat.parse(myDate);

            day = dateFormat.getCalendar().get(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    public static int getYearOfDateString(String myDate) {
        int year = 0;
        Date date = null;
        DateFormat dateFormat = SimpleDateFormat.getDateInstance();

        try {
            date = dateFormat.parse(myDate);
            year = dateFormat.getCalendar().get(Calendar.YEAR);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return year;
    }


    public static String convertTimeStampToDate(long timestamp) {
        return SimpleDateFormat.getDateInstance().format(new Date(timestamp));
    }

    public static String convertTimeStampToTime(long timestamp) {

        return SimpleDateFormat.getTimeInstance().format(new Date(timestamp));
    }

    public static int getExpenseIconByType(Context context, int type) {
        String drawableName = EXPENSE_TYPE_DRAWABLE_PREFIX + type;
        return context.getResources().getIdentifier(drawableName, "drawable", context.getPackageName());

    }

    public static int getContactIconByType(Context context, int type) {
        String drawableName = CONTACT_TYPE_DRAWABLE_PREFIX + type;
        return context.getResources().getIdentifier(drawableName, "drawable", context.getPackageName());

    }
}
