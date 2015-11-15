package com.glid.justintime.services;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.glid.justintime.R;
import com.glid.justintime.fragment.HomeFragment;

/**
 * Service responsible for firing alerts
 *
 * @author Slim BENHAMMOUDA
 */
public class AlertService extends Service {
    int i = 0;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, final int flags,
                              final int startId) {
        Log.v("yyyyyyyyyyyyyyyyyyyy", "AlertServiceStart");
        // createNotification(null, "Reminder  ", "datadata");

        // //////////////////////////////////////
        // ADD HERE WHAT YOU WANT TO DO
        // //////////////////////////////////////

        //Log.v("aaaaaa*****aaaaaaaaa", "( " + ExpenseTable.DATE + " - (strftime('%s', 'now') * 1000) ) =0 AND NOT IN ( SELECT id FROM notif_exp where duree = 24 ) ");
        //Cursor data = getApplicationContext().getContentResolver().query(CarMgtContentProvider.EXPENSE_CONTENT_URI, ExpenseTable.PROJECTION_ALL, "( " + ExpenseTable.DATE + " - ( strftime('%s', 'now') * 1000) ) = 10 AND ( " + ExpenseTable.DATE + " - ( strftime('%s', 'now') * 1000) ) > 0 ", null, null);

        // Log.v("aaaaaa*****aaaaaaaaa", "( " + ExpenseTable.DATE + " - (strftime('%s', 'now') * 1000) ) =0 ");
//        Cursor data = getApplicationContext().getContentResolver().query(CarMgtContentProvider.REMINDER_CONTENT_URI, ReminderTable.PROJECTION_ALL, "( " + ReminderTable.DATE_NOT + " - ( strftime('%s', 'now') * 1000) ) = 0", null, null);
//
//
//
//        if (data.moveToFirst()) {
//            while (!data.isAfterLast()) {
//
//                    Log.v("*******service*******", "AlertService   " + data.getString(1) + "   " + data.getString(3) + " => " + Utilities.convertTimeStampToDate(data.getLong(3)));
//                    createNotification(null,"Reminder :  ", data.getString(1)+"   "+data.getString(2));
//
//
//                if (!data.isClosed()) {
//                    data.moveToNext();
//                }
//            }
//        }
//        data.close();

        return Service.START_NOT_STICKY;
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void createNotification(View view, String title, String text) {
        // Prepare intent which is triggered if the
        // notification is selected
        Intent intent = new Intent(this, HomeFragment.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // Build notification
        // Actions are just fake
        Notification noti = new Notification.Builder(this)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(R.drawable.save)
                .setContentIntent(pIntent)
                .addAction(R.drawable.save, "More", pIntent)
                .addAction(R.drawable.corbeille, "And more", pIntent).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        // noti.flags |= Notification.FLAG_AUTO_CANCEL;
        i++;
        notificationManager.notify(i, noti);

    }
}
