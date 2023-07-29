package com.example.ahmarecipe

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

 class MainActivity : BaseActivity() {
    lateinit var context: Context
    lateinit var alarmManager: AlarmManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
//Create timer
        btn_create.setOnClickListener {
            val second = edt_timer.text.toString().toInt() * 1000
            val intent = Intent(context, Receiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            Log.d("MainActivity", " Create : " + Date().toString())
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + second, pendingIntent)
        }
//Update timer
        btn_update.setOnClickListener {
            val second = edt_timer.text.toString().toInt() * 1000
            val intent = Intent(context, Receiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            Log.d("MainActivity", " Update : " + Date().toString())
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + second, pendingIntent)
        }
//Cancel timer
        btn_cancel.setOnClickListener {
            val intent = Intent(context, Receiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            Log.d("MainActivity", " Cancel : " + Date().toString())
            alarmManager.cancel(pendingIntent)

        }



    }
//Receive entered timer (second) when timer reach
    class Receiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d("MainActivity", " Receiver : " + Date().toString())
//Play alarm
            var mp = MediaPlayer.create(context,R.raw.alarm_tone)
            mp.start()
        }

    }

}
