package kong.droid.todo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import kong.droid.todo.model.TodoEntity
import kong.droid.todo.model.TodoItem

@Database(entities = [TodoEntity::class, TodoItem::class], version = 1)
abstract class MainDB: RoomDatabase() {

    abstract fun dao(): MainDao

}