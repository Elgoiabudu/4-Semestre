package lucas.mend0n.app_intents


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.graphics.Color
import android.view.View

class Tela2Activity : AppCompatActivity() {

    lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        textView = findViewById(R.id.textView)
        textView.setTextColor( Color.rgb(255,50,50) )
        textView.setTextSize(60.6F)

    }
}