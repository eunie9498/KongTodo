package kong.droid.todo.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kong.droid.todo.model.Todo
import kong.droid.todo.model.TodoEntity
import kong.droid.todo.model.TodoItem

@Dao
interface MainDao {
    @Query("select * from TodoItem")
    fun getTodoItems(): List<TodoItem>

    @Insert
    fun addTodo(item: TodoItem)

    @Delete
    fun deleteAll(items: TodoEntity)

}