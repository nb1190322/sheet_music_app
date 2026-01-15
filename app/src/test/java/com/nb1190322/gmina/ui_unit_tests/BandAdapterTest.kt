package com.nb1190322.gmina.ui_unit_tests

import com.nb1190322.gmina.data_classes.Band
import com.nb1190322.gmina.ui.adapters.BandAdapter
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class BandAdapterTest {
    private lateinit var adapter: BandAdapter

    private val tempBands = listOf(
        Band("Wind Ensemble", "Director", "Rehearsal Active"),
        Band("Jazz Combo", "Musician - Sax", "Idle"),
        Band("Orchestra Strings", "Musician - Violin", "Idle")
    )

    @Before
    fun setup() {
        adapter = BandAdapter(tempBands)
    }

    @Test
    fun itemCount_matchesBandListSize() {
        assertEquals(3, adapter.itemCount)
    }
}