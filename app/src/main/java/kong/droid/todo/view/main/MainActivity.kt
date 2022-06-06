package kong.droid.todo.view.main

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kong.droid.todo.BaseActivity
import kong.droid.todo.R
import kong.droid.todo.data.TodoConstants
import kong.droid.todo.databinding.ActivityMainBinding
import kong.droid.todo.ui.TabItem
import kong.droid.todo.viewModel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    var isBackPressed = false
    lateinit var viewModel: MainViewModel
    var PAGE_SIZE = 3
    lateinit var tabItems: Array<TabItem>

    override fun initView() = with(binding) {
        viewModel = ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)
        viewModel = viewModel
        lifecycleOwner = this@MainActivity

        pagerAdapter = adapter
        tabItems = arrayOf(binding.home, binding.list, binding.setting)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                setSelectedPage(position)
            }
        })
    }

    fun setSelectedPage(position: Int) {
        when (position % PAGE_SIZE) {
            0 -> {
                setSelectBg(binding.home)
            }
            1 -> {
                //todo list
                setSelectBg(binding.home)
            }
            2 -> {
                //todo setting
                setSelectBg(binding.list)
            }
            else -> {
                setSelectBg(binding.setting)
            }
        }
    }


    val adapter = object : FragmentStateAdapter(supportFragmentManager, this.lifecycle) {
        override fun createFragment(position: Int): Fragment {

            return when (position % PAGE_SIZE) {
                0 -> {
                    MainFragment()
                }
                1 -> {
                    //todo list
                    MainFragment()
                }
                2 -> {
                    //todo setting
                    AddFragment()
                }
                else -> {
                    AddFragment()
                }
            }
        }

        override fun getItemCount() = PAGE_SIZE
    }


    fun setSelectBg(v: TabItem) {
        tabItems.find { it == v }!!.isSelected = true
        tabItems.find { it != v }!!.isSelected = false
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