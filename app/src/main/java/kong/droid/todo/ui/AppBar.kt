package kong.droid.todo.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import kong.droid.todo.R
import kong.droid.todo.databinding.AppBarBinding

class AppBar(
    context: Context,
    attrs: AttributeSet
) : ConstraintLayout(context, attrs) {
    var appBinding = AppBarBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.AppBar)
        if(a.hasValue(R.styleable.AppBar_addTitle)) {
            appBinding.tvTitle.text = a.getText(R.styleable.AppBar_addTitle)
        }
        a.recycle()
    }
}