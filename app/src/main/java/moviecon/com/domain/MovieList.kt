package moviecon.com.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("page")
    @Expose
    val page: Int,

    @SerializedName("results")
    @Expose
    val results: List<Movie>
)
