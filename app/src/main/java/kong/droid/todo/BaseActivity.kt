package kong.droid.todo

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T: ViewDataBinding> (
    @LayoutRes val resID: Int): AppCompatActivity() {

    lateinit var binding : T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, resID)
        binding.lifecycleOwner = this

        initView()
    }

    open fun initView() {
       // TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}