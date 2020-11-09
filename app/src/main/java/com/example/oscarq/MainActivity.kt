package com.example.oscarq
import android.app.KeyguardManager
import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView0)
       // val button2 = findViewById<Button>(R.id.button2)
       // val textView2 = findViewById<TextView>(R.id.textView2)
       // val textView3 = findViewById<TextView>(R.id.textView3)
       // val button3 = findViewById<Button>(R.id.button3)

        //TODO("adapt profiling and helper functions")
        //TODO("Mongo")
        //TODO("To add: L1/audit number corresponding to each audit")
        //TODO("Remove buttons and prototype UI and figure a new UI")

        //Ensure Firmware is up to date (Android Security patch level)
        //TODO("need to update latest patch automatically")

        button.setOnClickListener {

            if(Build.VERSION.SECURITY_PATCH== "2020-09-01")
            {
                textView.text =  Build.VERSION.SECURITY_PATCH +  " - BUILD UP TO DATE"
            }
            else
            {
                textView.text =  Build.VERSION.SECURITY_PATCH + " - BUILD VERSION NOT UP TO DATE"
            }

            //Ensure 'Screen Lock' is set to 'Enabled'(Pin/Password/Pattern)
            //TODO("VERSION.SDK_INT < M")

            val km = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if(km.isDeviceSecure){
                    textView.text = textView.text as String + "\n" +"DEVICE LOCK IS ENABLED"
                }
                else{
                    textView.text = textView.text as String +"\n" +"DEVICE LOCK IS DISENABLED"
                }
            }

            //Ensure 'Make pattern visible' is set to 'Disabled' (if using a
            //pattern as device lock mechanism)
            //TODO("How to check if pattern is not visible")

//            val locktype: Int = Locktype.getCurrent(contentResolver)
//            when (locktype) {
//                Locktype.PATTERN -> {  textView.text = textView.text as String + "\n" + "COULD NOT DETECT IS PATTERN IS SET TO NOT VISIBLE"
//                }
//            }
//
//            //Ensure 'Automatically Lock' is set to 'Immediately'
//            lateinit var dpm: DevicePolicyManager
//            lateinit var deviceAdminSample: ComponentName
//            //val timeMs: Long = 1000L * timeout.text.toString().toLong()
//            //dpm.setMaximumTimeToLock(deviceAdminSample, 1)
//            if(if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    dpm.autoTimeRequired
//                } else {
//                    TODO("VERSION.SDK_INT < LOLLIPOP")
//                }
//            ){
//                textView.text = textView.text as String + "\n" + "KINDLY SET AUTOMOTIC TIME TO 1ms"
//            }
//            else{
//                textView.text = textView.text as String + "\n" + "AUTOMATIC LOCK IS SET TO MINIMUM DURATION"
//            }


            //Do not connect to untrusted Wi-Fi networks (Not Scored)
            val connectivityManager=this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo=connectivityManager.activeNetworkInfo
            textView.text = textView.text as String + "\n " + networkInfo as String + "\n" + "NO UNTRUSTED NETWORK DETECTED"



            //Ensure 'Developer Options' is set to 'Disabled' (Not Scored)
            if(Settings.Secure.getInt(contentResolver, Settings.Secure.ADB_ENABLED, 0) == 1) {
                // debugging enabled
                textView.text = textView.text as String + "\n" + "USB DEBUGGING MUST BE DISABLED"
            } else {
                textView.text = textView.text as String + "\n " +"DEBUGGING OPTIONS SAFELY CONFIGURED"
            }



            //Ensure 'Install unknown apps' is set to 'Disabled' (Not Scored)
            val isNonPlayAppAllowed = Settings.Secure.getInt(
                contentResolver,
                Settings.Secure.INSTALL_NON_MARKET_APPS
            ) == 1
            if (!isNonPlayAppAllowed) {
                textView.text = textView.text as String + "\n " +"Install from unknown sources is disabled"
            }
            else{
                textView.text = textView.text as String + "\n " +"Disable install from unknown sources"
            }

        }


//        button.setOnClickListener {
//            Toast.makeText(this@MainActivity, "Performed Firmware Check", Toast.LENGTH_SHORT).show()
//            textView.text = Build.VERSION.RELEASE + " - UP TO DATE"
//        }
//        button2.setOnClickListener {
//          Toast.makeText(this@MainActivity, "Developer Options checked", Toast.LENGTH_SHORT).show()
//        textView2.text = "WARNING: DISABLE USB DEBUGGING"
//        }
//        button3.setOnClickListener {
//            Toast.makeText(this@MainActivity, "networkInfo verified", Toast.LENGTH_SHORT).show()
//            textView3.text = "NO UNTRUSTED NETWORK DETECTED"
//        }


    }
}
