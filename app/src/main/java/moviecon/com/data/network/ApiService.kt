package moviecon.com.data.network

import io.reactivex.rxjava3.core.Single
import moviecon.com.domain.MovieList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    fun getMovieList(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "485fbc212ab76526edb2699c29b0657d",
        @Query(QUERY_PARAM_LANGUAGE) language: String = "ru-RU",
        @Query(QUERY_PARAM_SORT_BY) sortBy: String = "popularity.desc",
        @Query(QUERY_PARAM_INCLUDE_ADULT) includeAdult: Boolean = false,
        @Query(QUERY_PARAM_INCLUDE_VIDEO) includeVideo: Boolean = false,
        @Query(QUERY_PARAM_PAGE) page: Int = 1,
        @Query(QUERY_PARAM_MONETIZATION_TYPES) monetization: String = MONETIZATION_TYPES
    ): Single<MovieList>

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
        private const val QUERY_PARAM_SORT_BY = "sort_by"
        private const val QUERY_PARAM_INCLUDE_ADULT = "include_adult"
        private const val QUERY_PARAM_INCLUDE_VIDEO = "include_video"
        private const val QUERY_PARAM_PAGE = "page"
        private const val QUERY_PARAM_MONETIZATION_TYPES = "with_watch_monetization_types"

        private const val MONETIZATION_TYPES = "flatrate"
    }
}