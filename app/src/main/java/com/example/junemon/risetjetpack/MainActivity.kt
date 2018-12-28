package com.example.junemon.risetjetpack

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.junemon.risetjetpack.databinding.ActivityMainBinding

/*
Principle of Navigation
1. theres always a starting place
2. you can always go back
3. up goes back (Mostly)

untuk bisa menggunakan navigation pada Stable Android Studio
click File -> Settings -> Experimental -> Check Enable Navigation Editor
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val controller = this.findNavController(R.id.navHostFragment)
        NavigationUI.setupActionBarWithNavController(this, controller)
    }


    override fun onSupportNavigateUp(): Boolean {
        val controller = this.findNavController(R.id.navHostFragment)
        return controller.navigateUp()
    }
}
