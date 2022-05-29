package kong.droid.todo.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
class TodoEntity {
    @PrimaryKey
    var id: Int? = -1

    var timeStamp: String? = ""
}

@Entity(
    foreignKeys = [ForeignKey(
        entity = TodoEntity::class,
        parentColumns = arrayOf("timeStamp"), childColumns = arrayOf("time")
    )]
)

class TodoItem {
    @PrimaryKey
    var id: Int? = -1

    var time: String? = ""
    var name: String? = ""
    var status: String? = ""
    var importance: Int? = 0
}