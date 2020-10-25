package com.gricob.marsroverphotos.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.work.Constraints
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.gricob.marsroverphotos.R
import com.gricob.marsroverphotos.work.MarsRoverWorker
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        initializeWorker()

        supportFragmentManager.beginTransaction()
            .replace(R.id.content, MainFragment.newInstance())
            .commitNow()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initializeWorker() {
        val constraints = Constraints.Builder().build()

        val marsRoverWorker = PeriodicWorkRequest.Builder(MarsRoverWorker::class.java, 1, TimeUnit.DAYS)
            .addTag("MarsRoverWork")
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(applicationContext).enqueue(marsRoverWorker)
    }
}