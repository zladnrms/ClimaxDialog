package defy.tech.testdialog.data

import androidx.annotation.Keep

@Keep
data class DialogItem(
    var dialogBackgroundColor: String? = null,
    var dialogCorner: FloatArray? = null,
    var title: String? = null,
    var titleGravity: Int? = null,
    var titleColor: String? = null,
    var titleBarColor: String? = null,
    var titleFont: String? = null,
    var titleSize: Float? = null,
    var layoutTitleBarVisibility: Boolean? = null,
    var layoutTitleBarColor: String? = null,
    var layoutContentGravity: Int? = null,
    var content: String? = null,
    var contentColor: String? = null,
    var contentGravity: Int? = null,
    var contentSize: Float? = null,
    var contentFont: String? = null,
    var contentpaddingTop: Float? = null,
    var centerActionVisibility: Boolean? = null,
    var centerActionText: String? = null,
    var centerActionSize: Float? = null,
    var centerActionBackgroundColor: String? = null,
    var centerActionColor: String? = null,
    var centerActionGravity: Int? = null,
    var centerActionFont: String? = null,
    var leftRightActionVisibility: Boolean? = null,
    var leftActionText: String? = null,
    var rightActionText: String? = null,
    var leftActionSize: Float? = null,
    var rightActionSize: Float? = null,
    var leftActionBackgroundColor: String? = null,
    var rightActionBackgroundColor: String? = null,
    var leftActionColor: String? = null,
    var rightActionColor: String? = null,
    var leftActionGravity: Int? = null,
    var rightActionGravity: Int? = null,
    var leftActionFont: String? = null,
    var rightActionFont: String? = null,
    var bottomOnlyActionVisibility: Boolean? = null,
    var bottomOnlyActionText: String? = null,
    var bottomOnlyActionSize: Float? = null,
    var bottomOnlyActionBackgroundColor: String? = null,
    var bottomOnlyActionColor: String? = null,
    var bottomOnlyActionGravity: Int? = null,
    var bottomOnlyActionFont: String? = null
)