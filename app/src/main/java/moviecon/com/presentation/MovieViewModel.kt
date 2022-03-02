package moviecon.com.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moviecon.com.data.database.MovieDataBase
import moviecon.com.data.network.ApiFactory

class MovieViewModel(application: Application): AndroidViewModel(application) {

    private val db = MovieDataBase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()

    val movieList = db.movieInfoDao().getAllMovies()

    fun loadPopularMovies() {
        val disposable = ApiFactory.apiService.getPopularityMovies()
            .map {it.results}
            .subscribeOn(Schedulers.io())
            .subscribe({
                db.movieInfoDao().insertMovieList(it)
                //Log.d("TEST", it.toString())
            },{
                Log.d("TEST", it.message.orEmpty())
            })
        compositeDisposable.add(disposable)
    }

    fun loadTopRatedMovies() {
        val disposable = ApiFactory.apiService.getTopRatedMovies()
            .map {it.results}
            .subscribeOn(Schedulers.io())
            .subscribe({
                db.movieInfoDao().insertMovieList(it)
                Log.d("TEST", it.toString())
            },{
                Log.d("TEST", it.message.orEmpty())
            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}