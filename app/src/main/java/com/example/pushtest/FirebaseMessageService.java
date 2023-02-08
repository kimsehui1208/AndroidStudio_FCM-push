package com.example.pushtest;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;

import androidx.core.app.NotificationCompat;

public class FirebaseMessageService extends com.google.firebase.messaging.FirebaseMessagingService{

    private static final String TAG = "FirebaseMsgService";

    private String msg, title;


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){
        Log.e(TAG, "onMessageReceived");

        title = remoteMessage.getNotification().geTitle();
        msg = remoteMessage.getNotification().getBody();

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent contentIntent = PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(msg)
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setVibrate(new long[]{1,1000});//1초동안 진동이 울려라

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context, NOTIFICATION_SERVICE);
        notificationManager.notify(0,mBuilder.build());

        mBuilder.setContentIntent(contentIntent);
    }
}
