package com.dicoding.picodiploma.moviecatalog.ui.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.moviecatalog.R
import com.dicoding.picodiploma.moviecatalog.data.MovieEntity
import com.dicoding.picodiploma.moviecatalog.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.items_tv_show.view.*

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private val listTv = ArrayList<MovieEntity>()

    fun setTv(tv: List<MovieEntity>?) {
        if (tv == null) return
        listTv.clear()
        listTv.addAll(tv)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_tv_show, parent, false)
        return TvShowViewHolder(view)
    }

    override fun getItemCount(): Int = listTv.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow =  listTv[position]
        holder.bind(tvShow)
    }

    class TvShowViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(tv: MovieEntity) {
            with(itemView) {
                tvTitle.text = tv.title
                tvDesc.text = tv.description

                setOnClickListener{
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.EXTRA_MOVIE, tv.id)
                    }
                    context.startActivity(intent)
                }

                Glide.with(context)
                    .load(tv.poster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }
}