package fernando.bonde.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    private lateinit var buttonSendNotification: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSendNotification = findViewById(R.id.button_send_notification)

        buttonSendNotification.setOnClickListener {
            sendTestNotification()
        }

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val token = task.result
                Log.d("FCM Token", token)
                // Use this token to send a test notification from your server or Firebase console
            }
        }
    }

    private fun sendTestNotification() {
        // This function would normally send a request to your backend to trigger a notification
        // Here you can manually send a test notification using the Firebase console
    }
}
