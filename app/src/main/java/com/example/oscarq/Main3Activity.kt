package com.example.oscarq

import android.os.Bundle
import android.view.Menu
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import android.graphics.Color
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel

class Main3Activity : AppCompatActivity() {

    lateinit var tvR: TextView
    lateinit var tvPython:TextView
    lateinit var tvCPP:TextView
    lateinit var tvJava:TextView
    lateinit var pieChart: PieChart

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Welcome to OSCARQ! We are all about meaningful metrics. Visit our website for more.", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        // Link those objects with their
        // respective id's that
        // we have given in .XML file
        tvR = findViewById(R.id.tvR);
        tvPython = findViewById(R.id.tvPython);
        tvCPP = findViewById(R.id.tvCPP);
        tvJava = findViewById(R.id.tvJava);
        pieChart = findViewById(R.id.piechart);

        // Creating a method setData()
        // to set the text in text view and pie chart
        setData();
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main3, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun setData() {

        // Set the percentage of language used
        tvR.text = Integer.toString(40)
        tvPython.text = Integer.toString(30)
        tvCPP.text = Integer.toString(5)
        tvJava.text = Integer.toString(25)

        // Set the data and color to the pie chart
        pieChart.addPieSlice(
            PieModel(
                "R", tvR.text.toString().toInt().toFloat(),
                Color.parseColor("#6200EE")
            )
        )
        pieChart.addPieSlice(
            PieModel(
                "Python", tvPython.text.toString().toInt().toFloat(),
                Color.parseColor("#3700B3")
            )
        )
        pieChart.addPieSlice(
            PieModel(
                "C++", tvCPP.text.toString().toInt().toFloat(),
                Color.parseColor("#29B6F6")
            )
        )
        pieChart.addPieSlice(
            PieModel(
                "Java", tvJava.text.toString().toInt().toFloat(),
                Color.parseColor("#03DAC5")
            )
        )

        // To animate the pie chart
        pieChart.startAnimation()
    }



}
