package com.nb1190322.gmina.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nb1190322.gmina.databinding.ActivityCreateBandBinding

class CreateBandActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateBandBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBandBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}