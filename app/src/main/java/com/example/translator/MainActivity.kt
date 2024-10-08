package com.example.translator

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
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

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.bnvMain.selectedItemId != R.id.mainFragment) {
                    binding.bnvMain.selectedItemId = R.id.mainFragment
                } else {
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })
    }
}