package defy.tech.testdialog.data

import androidx.annotation.Keep

@Keep
data class DialogItem(
    var backgroundColor: String? = null,
    var cornerRadius: FloatArray? = null,
    var titleBarVisibility: Boolean? = null,
    var titleBarColor: String? = null,
    var title: String? = null,
    var titleGravity: Int? = null,
    var titleColor: String? = null,
    var titleFont: String? = null,
    var titleSize: Float? = null,
    var content: String? = null,
    var contentColor: String? = null,
    var contentGravity: Int? = null,
    var contentSize: Float? = null,
    var contentFont: String? = null,
    var contentPaddingTop: Float? = null,
    var contentPaddingLeft: Float? = null,
    var contentPaddingRight: Float? = null,
    var contentPaddingBottom: Float? = null
)