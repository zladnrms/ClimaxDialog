package defy.tech.testdialog.data

import androidx.annotation.Keep

@Keep
data class BottomLeftRightActionItem(
    var leftText: String? = null,
    var leftTextSize: Float? = null,
    var leftBackgroundColor: String? = null,
    var leftTextColor: String? = null,
    var leftTextGravity: Int? = null,
    var leftTextFont: String? = null,
    var rightText: String? = null,
    var rightTextSize: Float? = null,
    var rightBackgroundColor: String? = null,
    var rightTextColor: String? = null,
    var rightTextGravity: Int? = null,
    var rightTextFont: String? = null
)