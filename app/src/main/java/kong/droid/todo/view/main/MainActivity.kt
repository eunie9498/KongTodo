package kong.droid.todo.view.main

import android.os.Handler
import android.os.Looper
import android.os.Message
import kong.droid.todo.BaseActivity
import kong.droid.todo.R
import kong.droid.todo.data.TodoConstants
import kong.droid.todo.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    var isBackPressed = false

    override fun initView() {
        val fragment = MainFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragContainer, fragment).commit()
    }


    inner class BackHandler : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            when (msg.what) {
                TodoConstants.BACK_PRESSED -> {
                    isBackPressed = false
                    return
                }
            }
        }
    }


    override fun onBackPressed() {
        if (!isBackPressed) {
            isBackPressed = true
            showToast(getString(R.string.one_more_back))
            BackHandler().sendEmptyMessageDelayed(
                TodoConstants.BACK_PRESSED,
                TodoConstants.BACK_PRESSED_TIME
            )
        } else {
            BackHandler().removeMessages(TodoConstants.BACK_PRESSED)
            exitApp()
            super.onBackPressed()
        }
    }
}