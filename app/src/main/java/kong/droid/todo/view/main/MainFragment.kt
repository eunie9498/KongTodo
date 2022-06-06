package kong.droid.todo.view.main

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kong.droid.todo.BaseFragment
import kong.droid.todo.R
import kong.droid.todo.data.TodoConstants
import kong.droid.todo.databinding.MainFragmentBinding
import kong.droid.todo.viewModel.MainViewModel
import kotlin.random.Random

class MainFragment : BaseFragment<MainFragmentBinding>(R.layout.main_fragment) {
    lateinit var mainViewModel: MainViewModel

    var emptyArr = arrayOf(
        TodoConstants.RECOM1,
        TodoConstants.RECOM2,
        TodoConstants.RECOM3,
        TodoConstants.RECOM4
    )

    override fun init() {


        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.currentTodo.observe(this, Observer {

        })

        getItems()
    }

    private fun getItems() {
        val runnable = Runnable {
            if (db.dao().getTodoItems().isEmpty()) {
                binding.emptyTxt = emptyArr.get(Random.nextInt(0, 3))
            } else {
            }
        }

        val thread = Thread(runnable)
        thread.start()
    }


}