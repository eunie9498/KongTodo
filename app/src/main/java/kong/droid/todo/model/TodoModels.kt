package kong.droid.todo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Todo(
    var id: Int,
    var name: String,
    var timeStamp: String,
    var status: String,
    var importance: Int
) : Parcelable