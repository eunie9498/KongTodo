package kong.droid.todo


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.room.Room
import kong.droid.todo.data.MainDB
import kong.droid.todo.data.MainDao

abstract class BaseFragment<T : ViewDataBinding>(
    @LayoutRes val layoutId: Int
) : Fragment() {
    lateinit var binding: T
    lateinit var db: MainDB
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this

        db = MainDB.getInstance(requireContext())

        init()
    }

    abstract fun init()

}