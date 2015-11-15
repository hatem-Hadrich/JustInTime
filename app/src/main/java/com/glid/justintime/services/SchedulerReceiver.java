package com.glid.justintime.services;

/**
 * Created hatem.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class SchedulerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context ctx, final Intent intent) {

        Intent alertServiceIntent = new Intent(ctx, AlertService.class);
        // start the alert service
        ctx.startService(alertServiceIntent);

    }

}