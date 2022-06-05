package kong.droid.todo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kong.droid.todo.model.TodoEntity
import kong.droid.todo.model.TodoItem

@Database(entities = [TodoEntity::class, TodoItem::class], version = 1)
abstract class MainDB: RoomDatabase() {
    abstract fun dao(): MainDao

    private var INSTANCE: MainDB? = null

    companion object {

        @Volatile private var INSTANCE: MainDB? = null

        fun getInstance(context: Context): MainDB =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context,
                MainDB::class.java, "mainDB.db")
                .build()
    }

    open fun destroyInstance() {
        INSTANCE = null
    }

}