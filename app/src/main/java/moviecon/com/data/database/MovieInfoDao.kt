package moviecon.com.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import moviecon.com.domain.Movie

@Dao
interface MovieInfoDao {
    @Query("SELECT * FROM movies")
    fun getAllMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM movies WHERE id == :id")
    fun getMovieById(id: Int): LiveData<Movie>

    @Query("DELETE FROM movies")
    fun deleteAllMovies()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieList(movieList: List<Movie>)
}