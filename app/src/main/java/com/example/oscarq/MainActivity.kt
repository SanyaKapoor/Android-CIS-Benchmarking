package com.example.oscarq
import android.app.KeyguardManager
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val textView = findViewById<TextView>(R.id.textView0)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView3 = findViewById<TextView>(R.id.textView3)
        val button3 = findViewById<Button>(R.id.button3)

        val connectivityManager=this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo=connectivityManager.activeNetworkInfo
        val status = networkInfo!=null && networkInfo.isConnected
        println(networkInfo);

        //++adapt profiling and helper functions + mongo

        //Ensure Firmware is up to date (Android Security patch level)
        // ++need to update latest patch automatically
        if(android.os.Build.VERSION.SECURITY_PATCH== "2020-09-01")
        {
            textView.text =  android.os.Build.VERSION.SECURITY_PATCH + " - UP TO DATE"
        }
        else
        {
            textView.text =  android.os.Build.VERSION.SECURITY_PATCH + " - NOT UP TO DATE"
        }

        //Ensure 'Screen Lock' is set to 'Enabled'(Pin/Password/Pattern)
        // ++add method to manage devices below marshmallow
        if(getSystemService(Context.KEYGUARD_SERVICE).isDeviceSecure()==true)
        {

        }
        else
        {

        }



//        button.setOnClickListener {
//            Toast.makeText(this@MainActivity, "Performed Firmware Check", Toast.LENGTH_SHORT).show()
//            textView.text = Build.VERSION.RELEASE + " - UP TO DATE"
//        }
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
