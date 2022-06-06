package kong.droid.todo.customui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import kong.droid.todo.R
import kong.droid.todo.databinding.EditItemBinding

class EditItem(
    context: Context,
    attrs: AttributeSet
) : ConstraintLayout(context, attrs) {
    var editBinding = EditItemBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        val a = context.obtainStyledAttributes(R.styleable.EditItem)
        if (a.hasValue(R.styleable.EditItem_addHint)) {
            editBinding.etContainer.hint = a.getText(R.styleable.EditItem_addHint)
        }
        a.recycle()
    }
}