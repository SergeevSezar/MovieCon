package moviecon.com.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import moviecon.com.domain.Movie

object MovieDiffCallback: DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
      return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}