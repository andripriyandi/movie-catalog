package com.dicoding.picodiploma.moviecatalog.ui.movie

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.moviecatalog.data.MovieEntity
import com.dicoding.picodiploma.moviecatalog.utils.DataDummy

class MovieViewModel : ViewModel()  {
    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovie()
}