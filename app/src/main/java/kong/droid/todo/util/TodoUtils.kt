package kong.droid.todo.util


import android.content.Context
import android.util.TypedValue
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

fun getCurrentTime(): String {
    val now = DateTime.now()
    var format = DateTimeFormat.forPattern("yyyy-MM-dd")
    return now.toString(format)
}

fun Float.dpToPx(context: Context): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this, context.resources.displayMetrics
    )
}
