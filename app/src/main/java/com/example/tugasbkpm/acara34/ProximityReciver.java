package com.example.tugasbkpm.acara34;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.widget.Toast;

public class ProximityReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean entering = intent.getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING, false);
        if (entering) {
            Toast.makeText(context, "Memasuki area Boston!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Keluar dari area Boston!", Toast.LENGTH_LONG).show();
        }
    }
}
