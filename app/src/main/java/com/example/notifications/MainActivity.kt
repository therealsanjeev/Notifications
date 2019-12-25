package com.example.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            nm.createNotificationChannel(NotificationChannel(
                "first","Default",NotificationManager.IMPORTANCE_DEFAULT))
        }
        button.setOnClickListener{
            val simpleNotification= NotificationCompat.Builder(this,"first")
                .setContentTitle("Simple Titel")
                .setContentText("This Simple description of the notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            nm.notify(1,simpleNotification)

        }
        button2.setOnClickListener{
            val i= Intent()
            i.action=Intent.ACTION_VIEW
            i.data= Uri.parse("https://www.therealsanjeev.in")

            val pi =PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val clickableNotification= NotificationCompat.Builder(this,"first")
                .setContentTitle("Simple Titel")
                .setContentText("This Simple description of the notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build()

            nm.notify(2,clickableNotification)
        }
        button3.setOnClickListener{
            val i= Intent()
            i.action=Intent.ACTION_VIEW
            i.data= Uri.parse("https://www.therealsanjeev.in")

            val pi =PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val clickableNotification= NotificationCompat.Builder(this,"first")
                .setContentTitle("Simple Titel")
                .setContentText("This Simple description of the notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .addAction(R.drawable.ic_launcher_background,"Click me",pi)
                .setAutoCancel(true)
                .build()

            nm.notify(3,clickableNotification)
        }
        
    }
}
