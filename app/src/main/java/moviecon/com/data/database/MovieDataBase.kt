package moviecon.com.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import moviecon.com.domain.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDataBase: RoomDatabase() {

    companion object {
        private var db: MovieDataBase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): MovieDataBase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(
                    context,
                    MovieDataBase::class.java,
                    DB_NAME
                ).build()
                db = instance
                return instance
            }
        }
    }
    abstract fun movieInfoDao(): MovieInfoDao
}