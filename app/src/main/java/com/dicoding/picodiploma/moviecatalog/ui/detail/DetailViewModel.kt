package com.dicoding.picodiploma.moviecatalog.ui.detail

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.moviecatalog.data.MovieEntity
import com.dicoding.picodiploma.moviecatalog.utils.DataDummy

class DetailViewModel: ViewModel() {
    private lateinit var id: String

    fun setSelectedFilm(id: String) {
        this.id = id
    }

    fun getFilm(): MovieEntity {
        lateinit var film: MovieEntity
        val movieEntities = DataDummy.generateDummyMovie()
        for (movieEntity in movieEntities) {
            if (movieEntity.id == id) {
                film = movieEntity
            }
        }

        val tvEntities = DataDummy.generateDummyTvShow()
        for (tvEntity in tvEntities) {
            if (tvEntity.id == id) {
                film = tvEntity
            }
        }

        return film
    }

}