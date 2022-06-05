package kong.droid.todo.view

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kong.droid.todo.BaseActivity
import kong.droid.todo.R
import kong.droid.todo.data.TodoConstants
import kong.droid.todo.databinding.ActivityMainBinding
import kong.droid.todo.viewModel.MainViewModel


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun initView() {
        val fragment = MainFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragContainer, fragment).commit()
    }

}