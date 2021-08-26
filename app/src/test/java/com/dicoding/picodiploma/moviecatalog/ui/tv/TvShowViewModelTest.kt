package com.dicoding.picodiploma.moviecatalog.ui.tv

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTv() {
        val tvEntities = viewModel.getTv()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities.size)
    }
}