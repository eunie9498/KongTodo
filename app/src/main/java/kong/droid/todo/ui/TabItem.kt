package kong.droid.todo.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kong.droid.todo.R
import kong.droid.todo.databinding.TabItemBinding

class TabItem (
    context: Context,
    attrs: AttributeSet
) : ConstraintLayout(context, attrs), View.OnClickListener {

    var tabBinding = TabItemBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.TabItem)
        if (a.hasValue(R.styleable.TabItem_addTitle)) {
            tabBinding.tabTxt.text = a.getText(R.styleable.TabItem_addTitle)
        }
        if (a.hasValue(R.styleable.TabItem_addIcon)) {
            tabBinding.tabIcon.background = a.getDrawable(R.styleable.TabItem_addIcon)
        }
        tabBinding.wholeBtn.setOnClickListener(this)
        a.recycle()
    }

    override fun onClick(v: View) {
        when (v) {
            tabBinding.wholeBtn -> {
                tabBinding.wholeBtn.isSelected = !tabBinding.wholeBtn.isSelected
            }
        }
    }
}