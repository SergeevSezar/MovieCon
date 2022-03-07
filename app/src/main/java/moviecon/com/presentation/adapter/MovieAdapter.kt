package moviecon.com.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import moviecon.com.data.network.ApiFactory
import moviecon.com.databinding.MovieItemBinding
import moviecon.com.domain.Movie

class MovieAdapter(private val context: Context): ListAdapter<Movie, MovieViewHolder>(MovieDiffCallback) {

    var onClickListener: OnMovieClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        with(holder.binding) {
            with(movie) {
                Picasso.get().load(ApiFactory.getFullBigImageUrl(movie.posterPath)).into(ivMoviePoster)
            }
        }
    }

    interface OnMovieClickListener {
        fun onClick(movie: Movie)
    }
}