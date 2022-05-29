package kong.droid.todo.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kong.droid.todo.model.Todo
import kong.droid.todo.model.TodoEntity
import kong.droid.todo.model.TodoItem
import retrofit2.http.DELETE

@Dao
interface MainDao {
    @Query("select :timeStamp from todoitem")
    fun selectTodo(timeStamp : String): LiveData<Todo>

    @Insert
    fun addTodo(item: TodoItem)

    @DELETE
    fun deleteAll(items: TodoEntity)

    @Query("update TodoItem set status=:status where id=:id")
    fun updateStatus(status: String, id: Int)
}