package androidx.test.novelreader.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.test.novelreader.MainActivity
import androidx.test.novelreader.R

class TtsService : Service() {

    companion object {
        private const val CHANNEL_ID = "tts_playback"
        private const val NOTIFICATION_ID = 1
        const val ACTION_STOP = "androidx.test.novelreader.STOP_TTS"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action == ACTION_STOP) {
            stopForeground(STOP_FOREGROUND_REMOVE)
            stopSelf()
            return START_NOT_STICKY
        }

        val bookTitle = intent?.getStringExtra("bookTitle") ?: "Reading"
        startForeground(NOTIFICATION_ID, createNotification(bookTitle))
        return START_STICKY
    }

    private fun createNotification(bookTitle: String): Notification {
        val returnIntent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        }
        val returnPendingIntent = PendingIntent.getActivity(
            this, 0, returnIntent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val stopIntent = Intent(this, TtsService::class.java).apply {
            action = ACTION_STOP
        }
        val stopPendingIntent = PendingIntent.getService(
            this, 1, stopIntent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Reading aloud")
            .setContentText(bookTitle)
            .setSmallIcon(R.drawable.ic_book)
            .setContentIntent(returnPendingIntent)
            .addAction(R.drawable.ic_stop, "Stop", stopPendingIntent)
            .setOngoing(true)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "TTS Playback",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "Voice reading notification"
            }
            getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
