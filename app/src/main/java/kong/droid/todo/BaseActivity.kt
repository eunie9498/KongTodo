package kong.droid.todo

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.room.Room
import kong.droid.todo.data.MainDB

abstract class BaseActivity<T: ViewDataBinding> (
    @LayoutRes val resID: Int): AppCompatActivity() {

    lateinit var binding : T
    lateinit var db: MainDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, resID)
        binding.lifecycleOwner = this
        db = MainDB.getInstance(this)

        initView()
    }

    open fun initView() {
       // TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}