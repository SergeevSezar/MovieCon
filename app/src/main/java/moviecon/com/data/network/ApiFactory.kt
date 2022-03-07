package moviecon.com.data.network

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/"
    private const val BIG_POSTER_SIZE = "w780"
    private const val SMALL_POSTER_SIZE = "w180"

    fun getFullBigImageUrl(posterPath: String):String {
        return POSTER_BASE_URL + BIG_POSTER_SIZE + posterPath;
    }

    fun getFullSmallImageUrl(posterPath: String):String {
        return POSTER_BASE_URL + SMALL_POSTER_SIZE + posterPath;
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService = retrofit.create(ApiService::class.java)
}