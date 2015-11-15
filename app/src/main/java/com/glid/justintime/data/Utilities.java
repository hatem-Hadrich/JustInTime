package com.glid.justintime.data;

import android.content.Context;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hatem.
 * c'est une classe static qui contient des methodes statics partagees par plusieurs classes
 */
public class Utilities {


    private static final String EXPENSE_TYPE_DRAWABLE_PREFIX = "ic_expense_type_";
    private static final String CONTACT_TYPE_DRAWABLE_PREFIX = "ic_contact_type_";


    //m�thode de conversion d'une date de type stringsous le format "dd/MM/yyyy"  � son �quivalent en type long(TimeStamp).
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

    //m�thode de conversion d'une date de type stringsous le format "dd/MM/yyyy HH:mm"  � son �quivalent en type long(TimeStamp).
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

    //m�thode de conversion d'une date de type stringsous le format " HH:mm"  � son �quivalent en type long(TimeStamp).
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

    //m�thode qui retourne le num�ro du mois a partir d'une date de type string
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

    //m�thode qui retourne le num�ro du jour a partir d'une date de type string
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

    //m�thode qui retourne le num�ro de l'ann�e a partir d'une date de type string
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

    //m�thode qui retourne une date lisible � partir de son �quivalent sous forme long(TimeStamp).
    public static String convertTimeStampToDate(long timestamp) {
        return SimpleDateFormat.getDateInstance().format(new Date(timestamp));
    }

    //m�thode qui retourne une temps lisible � partir de son �quivalent sous forme long(TimeStamp).
    public static String convertTimeStampToTime(long timestamp) {

        return SimpleDateFormat.getTimeInstance().format(new Date(timestamp));
    }

    //m�thode retourne image de l'expense selon son type choisit � partir de la grid
    public static int getExpenseIconByType(Context context, int type) {
        String drawableName = EXPENSE_TYPE_DRAWABLE_PREFIX + type;
        return context.getResources().getIdentifier(drawableName, "drawable", context.getPackageName());

    }

    //m�thode retourne image du contact selon son type choisit � partir de la grid
    public static int getContactIconByType(Context context, int type) {
        String drawableName = CONTACT_TYPE_DRAWABLE_PREFIX + type;
        return context.getResources().getIdentifier(drawableName, "drawable", context.getPackageName());

    }
}
