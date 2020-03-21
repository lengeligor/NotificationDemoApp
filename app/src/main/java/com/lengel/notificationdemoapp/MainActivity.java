package com.lengel.notificationdemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;

import static com.lengel.notificationdemoapp.NotificationDemoApp.CHANNEL_1_ID;
import static com.lengel.notificationdemoapp.NotificationDemoApp.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat manager;
    private EditText title;
    private EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = NotificationManagerCompat.from(this);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

    }

    public void useChannelOne(View view) {
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_announcement)
                .setContentTitle(title.getText())
                .setContentText(description.getText())
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        manager.notify(1,notification);
    }

    public void useChannelTwo(View view) {
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_add_alert)
                .setContentTitle(title.getText())
                .setContentText(description.getText())
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        manager.notify(2,notification);
    }
}
