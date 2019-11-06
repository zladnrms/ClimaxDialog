package defy.tech.testdialog.data

import androidx.annotation.Keep

@Keep
data class BottomSingleActionItem(
    var text: String? = null,
    var textSize: Float? = null,
    var backgroundColor: String? = null,
    var textColor: String? = null,
    var textGravity: Int? = null,
    var textFont: String? = null
)