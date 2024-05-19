package com.example.translator

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.translator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var controller: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        controller = (
                supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment
                ).navController
        binding.run {
            bnvMain.setupWithNavController(controller)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        binding.run {
            if (bnvMain.selectedItemId != R.id.mainFragment) {
                bnvMain.selectedItemId = R.id.mainFragment
            } else {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}