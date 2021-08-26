package com.dicoding.picodiploma.moviecatalog.ui.tv

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.moviecatalog.data.MovieEntity
import com.dicoding.picodiploma.moviecatalog.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTv(): List<MovieEntity> = DataDummy.generateDummyTvShow()
}