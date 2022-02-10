package moviecon.com.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import moviecon.com.databinding.ActivityMovieListBinding
import moviecon.com.presentation.adapter.MovieAdapter

class MovieListActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieViewModel

    private val binding by lazy {
        ActivityMovieListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = MovieAdapter(this)
        binding.rvMoviePoster.adapter = adapter

        viewModel = ViewModelProvider.AndroidViewModelFactory(application).create(MovieViewModel::class.java)
        viewModel.movieList.observe(this, Observer {
            adapter.movieList = it
        })
    }
}