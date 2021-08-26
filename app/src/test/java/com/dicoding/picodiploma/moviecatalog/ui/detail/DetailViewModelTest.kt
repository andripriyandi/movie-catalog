package com.dicoding.picodiploma.moviecatalog.ui.detail

import com.dicoding.picodiploma.moviecatalog.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dummyMovie.id

    private val dummyTv = DataDummy.generateDummyTvShow()[0]
    private val tvId = dummyTv.id

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelectedFilm(movieId.toString())
        viewModel.setSelectedFilm(tvId.toString())
    }

    @Test
    fun getFilm() {
        viewModel.setSelectedFilm(dummyMovie.id.toString())
        val movieEntity = viewModel.getFilm()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.bg, movieEntity.bg)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.poster, movieEntity.poster)
        assertEquals(dummyMovie.release, movieEntity.release)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.description, movieEntity.description)


        viewModel.setSelectedFilm(dummyTv.id.toString())
        val tvEntity = viewModel.getFilm()
        assertNotNull(movieEntity)
        assertEquals(dummyTv.id, tvEntity.id)
        assertEquals(dummyTv.bg, tvEntity.bg)
        assertEquals(dummyTv.title, tvEntity.title)
        assertEquals(dummyTv.poster, tvEntity.poster)
        assertEquals(dummyTv.release, tvEntity.release)
        assertEquals(dummyTv.genre, tvEntity.genre)
        assertEquals(dummyTv.duration, tvEntity.duration)
        assertEquals(dummyTv.description, tvEntity.description)
    }
}