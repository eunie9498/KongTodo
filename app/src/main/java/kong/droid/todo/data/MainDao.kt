package kong.droid.todo.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import kong.droid.todo.model.Todo

@Dao
interface MainDao {
    @Query("select * from todos")
    fun selectTodo(): LiveData<Todo>
}