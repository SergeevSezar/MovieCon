package moviecon.com.data.network

import io.reactivex.rxjava3.core.Single
import moviecon.com.domain.MovieList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getPopularityMovies(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "485fbc212ab76526edb2699c29b0657d",
        @Query(QUERY_PARAM_LANGUAGE) language: String = "ru-RU",
        @Query(QUERY_PARAM_PAGE) page: Int = 1,
    ): Single<MovieList>

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "485fbc212ab76526edb2699c29b0657d",
        @Query(QUERY_PARAM_LANGUAGE) language: String = "ru-RU",
        @Query(QUERY_PARAM_PAGE) page: Int = 1,
    ): Single<MovieList>

    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LANGUAGE = "language"
        private const val QUERY_PARAM_PAGE = "page"
    }
}