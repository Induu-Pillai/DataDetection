package com.example.datadetection

import android.app.ActivityManager
import android.app.ActivityManager.RunningAppProcessInfo
import android.net.TrafficStats
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val manager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val runningApps = manager.runningAppProcesses

        for (runningApp in runningApps) {
            // Get UID of the selected process
//            val uid = (getListAdapter().getItem(position) as RunningAppProcessInfo).uid
//            val received = TrafficStats.getUidRxBytes(uid) //received amount of each app
//            val send = TrafficStats.getUidTxBytes(uid) //sent amount of each app
            val receivedData = android.net.TrafficStats.getTotalRxBytes()
            val textview = findViewById<TextView>(R.id.textview1)
            textview.text = receivedData.toString()
        }
//        val networkStatsManager = getSystemService(Context.NETWORK_STATS_SERVICE) as NetworkStatsManager
//        val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
//
//        val manager = DataU(networkStatsManager, telephonyManager.subscriberId)
//
//        // Monitor single interval
//        manager.getUsage(Interval.today, NetworkType.MOBILE)
//
//        // Monitor multiple interval
//        manager.getMultiUsage(listOf(Interval.month, Interval.last30days), NetworkType.WIFI)
//
//        // Observe realtime usage
//        manager.getRealtimeUsage(NetworkType.WIFI).subscribe()
    }
}