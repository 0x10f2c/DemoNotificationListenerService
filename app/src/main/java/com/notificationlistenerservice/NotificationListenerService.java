package com.notificationlistenerservice;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.Nullable;

import org.json.JSONArray;

import java.util.ArrayList;

public class NotificationListenerService extends android.service.notification.NotificationListenerService {
    //This method will perform an action when the service detects a notification posted
    //as per the https://developer.android.com/reference/android/service/notification/NotificationListenerService#public-constructors

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        final String TAG = "TAG";
        // Shout out to https://stackoverflow.com/questions/28047767/notificationlistenerservice-not-reading-text-of-stacked-notifications
        // Note: This will repeat notifications when dealing with more then one notification/parcel source (until old notification are cleared); cant be bothered to code this as its just a quick demo
        Parcelable parcel[] = (Parcelable[]) sbn.getNotification().extras.get(Notification.EXTRA_MESSAGES);
        if (parcel != null){
            String content = "";
            int pos = 0;
            for (Parcelable tmp : parcel){
                pos = pos + 1;
                Bundle msgBundle = (Bundle) tmp;
                content= content +"Text: " + pos + " - " + (msgBundle.getString("text") + "\n");
                Log.d(TAG, String.valueOf(content));
            }
            MainActivity.AddtoArray(String.valueOf(sbn.getId()), sbn.getPackageName(),sbn.getNotification().extras.getString(Notification.EXTRA_TITLE), content);
        }
    }
}

