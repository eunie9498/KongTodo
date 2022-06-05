package kong.droid.todo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kong.droid.todo.model.Todo

class MainViewModel: ViewModel() {

    private val _currentTodo = MutableLiveData<List<Todo>>()

    val currentTodo: LiveData<List<Todo>>
         get()= _currentTodo

}