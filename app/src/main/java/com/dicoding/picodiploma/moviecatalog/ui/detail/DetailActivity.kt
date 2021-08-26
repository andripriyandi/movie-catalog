package com.dicoding.picodiploma.moviecatalog.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.moviecatalog.R
import com.dicoding.picodiploma.moviecatalog.data.MovieEntity
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val id = extras.getString(EXTRA_MOVIE)
            if (id != null) {
                viewModel.setSelectedFilm(id)
                showData(viewModel.getFilm())
            }
        }
    }

    private fun showData(data: MovieEntity) {
        tvToolbar.text = data.title
        tvTitle.text = data.title
        tvRelease.text = data.release
        tvGenre.text = data.genre
        tvDuration.text = data.duration
        tvDesc.text = data.description

        Glide.with(this)
            .load(data.bg)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(bgPoster)

        Glide.with(this)
            .load(data.poster)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(img_poster)
    }
}