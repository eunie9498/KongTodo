package kong.droid.todo

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kong.droid.todo.data.MainDB
import kotlin.system.exitProcess


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

    fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


    open fun exitApp() {
        finishAndRemoveTask()
        exitProcess(0)
    }
}