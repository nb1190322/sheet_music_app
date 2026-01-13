package com.nb1190322.gmina.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nb1190322.gmina.data_classes.Band
import com.nb1190322.gmina.databinding.ActivityHomeBinding
import com.nb1190322.gmina.ui.adapters.BandAdapter

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var bandAdapter: BandAdapter

    private val tempBands = listOf(
        Band("Wind Ensemble", "Director", "Rehearsal Active"),
        Band("Jazz Combo", "Musician - Sax", "Idle"),
        Band("Orchestra Strings", "Musician - Violin", "Idle")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBandRecycler()
    }

    private fun setupBandRecycler()
    {
        bandAdapter = BandAdapter(tempBands)
        binding.recyclerBands.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            this.adapter = bandAdapter
        }
    }
}