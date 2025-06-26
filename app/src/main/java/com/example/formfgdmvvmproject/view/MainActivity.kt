package com.example.formfgdmvvmproject.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.formfgdmvvmproject.R
import com.example.formfgdmvvmproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

//Senin 26 juni 2025, 10120095, Adrian Naufal Wijaya dan AKB UL1

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, InputFragment())
            .commit()
    }
}