package fernando.bonde.myapplication

import android.app.Notification
import com.google.firebase.messaging.FirebaseMessagingService

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        var uri = remoteMessage.data["uri"]
        if (uri != null) {
            showNotification(uri)
        }
    }

    private fun showNotification(uri: String) {

        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(uri)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK


        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(this, "default_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Nova Notificação")
            .setContentText("Clique aqui para abrir.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        NotificationManagerCompat.from(this)
            .notify(1, builder.build())
        startActivity(intent)

    }
}
