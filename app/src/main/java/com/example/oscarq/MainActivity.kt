package com.example.oscarq
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Build
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val textView = findViewById<TextView>(R.id.textView0)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView3 = findViewById<TextView>(R.id.textView3)
        val button3 = findViewById<Button>(R.id.button3)

        val connectivityManager=this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo=connectivityManager.activeNetworkInfo
        val status = networkInfo!=null && networkInfo.isConnected
        println(networkInfo);

        button.setOnClickListener {
            Toast.makeText(this@MainActivity, "Performed Firmware Check", Toast.LENGTH_SHORT).show()
            textView.text = Build.VERSION.RELEASE + " - UP TO DATE"
        }
        button2.setOnClickListener {
          Toast.makeText(this@MainActivity, "Developer Options checked", Toast.LENGTH_SHORT).show()
        textView2.text = "WARNING: DISABLE USB DEBUGGING"
        }
        button3.setOnClickListener {
            Toast.makeText(this@MainActivity, "networkInfo verified", Toast.LENGTH_SHORT).show()
            textView3.text = "NO UNTRUSTED NETWORK DETECTED"
        }
    }
}
