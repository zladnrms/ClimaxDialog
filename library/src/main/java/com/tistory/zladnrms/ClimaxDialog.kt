package com.tistory.zladnrms

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import com.tistory.zladnrms.library.R
import defy.tech.testdialog.data.BottomLeftRightActionItem
import defy.tech.testdialog.data.BottomSingleActionItem
import defy.tech.testdialog.data.CenterSingleActionItem
import defy.tech.testdialog.data.DialogItem

class ClimaxDialog constructor(context: Context) : Dialog(context), View.OnClickListener {

    private val layoutDialog: NestedRoundableLayout by lazy {
        this.findViewById(R.id.layout_dialog) as NestedRoundableLayout
    }

    private val layoutTitleBar: LinearLayout by lazy {
        this.findViewById(R.id.layout_title_bar) as LinearLayout
    }
    private val labelTitle: TextView by lazy {
        this.findViewById(R.id.title) as TextView
    }
    private val layoutContent: LinearLayout by lazy {
        this.findViewById(R.id.layout_content) as LinearLayout
    }
    private val labelContent: TextView by lazy {
        this.findViewById(R.id.content) as TextView
    }
    private val layoutLeftAction: LinearLayout by lazy {
        this.findViewById(R.id.layout_left_action) as LinearLayout
    }
    private val layoutRightAction: LinearLayout by lazy {
        this.findViewById(R.id.layout_right_action) as LinearLayout
    }
    private val labelCenterAction: TextView by lazy {
        this.findViewById(R.id.label_center_action) as TextView
    }
    private val labelLeftAction: TextView by lazy {
        this.findViewById(R.id.label_left_action) as TextView
    }
    private val labelRightAction: TextView by lazy {
        this.findViewById(R.id.label_right_action) as TextView
    }
    private val layoutBottomOnlyAction: LinearLayout by lazy {
        this.findViewById(R.id.layout_bottom_only_action) as LinearLayout
    }
    private val labelBottomOnlyAction: TextView by lazy {
        this.findViewById(R.id.label_bottom_only_action) as TextView
    }

    private var mLeftActionListener: CoolDialogClickListener? = null
    private var mRightActionListener: CoolDialogClickListener? = null
    private var mBottomOnlyActionListener: CoolDialogClickListener? = null
    private var mCenterActionListener: CoolDialogClickListener? = null

    private val dialogItem: DialogItem = DialogItem()
    private var bLRI: BottomLeftRightActionItem? = null
    private var bSAI: BottomSingleActionItem? = null
    private var cSAI: CenterSingleActionItem? = null

    var hasBottomSingleAction = false
    var hasBottomAction = false
    var hasCenterSingleAction = false

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        window?.attributes!!.windowAnimations = R.style.DialogAnimation
        setCancelable(true)
        super.onCreate(savedInstanceState)
        Log.d("온크", "생성됨1")
        setContentView(R.layout.layout_climax_dialog)

        controlVisibility()
        Log.d("온크", "생성됨2")
        setDataIntoView()

        layoutLeftAction.setOnClickListener(this@ClimaxDialog)
        layoutRightAction.setOnClickListener(this@ClimaxDialog)
        labelCenterAction.setOnClickListener(this@ClimaxDialog)
        layoutBottomOnlyAction.setOnClickListener(this@ClimaxDialog)
    }

    private fun controlVisibility() {
        if(hasBottomAction)
            bLRI = BottomLeftRightActionItem()
        if(hasBottomSingleAction)
            bSAI = BottomSingleActionItem()
        if(hasCenterSingleAction)
            cSAI = CenterSingleActionItem()
    }

    private fun setDataIntoView() {
        with(dialogItem) {
            backgroundColor?.let { color ->
                layoutDialog.setBackgroundColor(color)
            }
            cornerRadius?.let { radii ->
                layoutDialog.setCorner(radii)
            }
            titleBarVisibility?.let { boolean ->
                if (boolean) {
                    layoutTitleBar.visibility = View.VISIBLE
                } else {
                    layoutTitleBar.visibility = View.GONE
                }
            }
            titleBarColor?.let { 
                
            }
            title?.let { text ->
                labelTitle.text = text
            }
            titleGravity?.let { gravity ->
                labelTitle.gravity = gravity
            }
            titleColor?.let { color ->
                labelTitle.setTextColor(Color.parseColor(color))
            }
            titleSize?.let { size ->
                labelTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
            titleFont?.let { font ->
                Typeface.createFromAsset(context.assets, font).apply { labelTitle.typeface = this }
            }
            content?.let {  text ->
                labelContent.text = text
            }
            contentGravity?.let { gravity ->
                labelContent.gravity = gravity
            }
            contentColor?.let { color ->
                labelContent.setTextColor(Color.parseColor(color))
            }
            contentSize?.let { size ->
                labelContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
            contentFont?.let { font ->
                Typeface.createFromAsset(context.assets, font).apply { labelContent.typeface = this }
            }
        }

        bLRI?.run {
            layoutLeftAction.visibility = View.VISIBLE
            layoutRightAction.visibility = View.VISIBLE

            leftBackgroundColor?.let { color ->
                layoutLeftAction.setBackgroundColor(Color.parseColor(color))
            }
            leftText?.let { text ->
                labelLeftAction.text = text
            }
            leftTextColor?.let{ color ->
                labelLeftAction.setTextColor(Color.parseColor(color))
            }
            leftTextGravity?.let { gravity ->
                labelLeftAction.gravity = gravity
            }
            leftTextSize?.let { size ->
                labelLeftAction.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
            leftTextFont?.let { font ->
                Typeface.createFromAsset(context.assets, font).apply { labelLeftAction.typeface = this }
            }
            rightBackgroundColor?.let { color ->
                layoutRightAction.setBackgroundColor(Color.parseColor(color))
            }
            rightText?.let { text ->
                labelRightAction.text = text
            }
            rightTextColor?.let{color ->
                labelRightAction.setTextColor(Color.parseColor(color))
            }
            rightTextGravity?.let { gravity ->
                labelRightAction.gravity = gravity
            }
            rightTextSize?.let { size ->
                labelRightAction.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
            rightTextFont?.let { font ->
                Typeface.createFromAsset(context.assets, font).apply { labelRightAction.typeface = this }
            }

        }

        bSAI?.run {
            backgroundColor?.let {

            }
            text?.let { text ->
                labelRightAction.text = text
            }
            textColor?.let{color ->
                labelRightAction.setTextColor(Color.parseColor(color))
            }
            textGravity?.let { gravity ->
                labelRightAction.gravity = gravity
            }
            textSize?.let { size ->
                labelRightAction.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
            textFont?.let { font ->
                Typeface.createFromAsset(context.assets, font).apply { labelRightAction.typeface = this }
            }
        }

        cSAI?.run {
            backgroundColor?.let {

            }
            text?.let { text ->
                labelRightAction.text = text
            }
            textColor?.let{color ->
                labelRightAction.setTextColor(Color.parseColor(color))
            }
            textGravity?.let { gravity ->
                labelRightAction.gravity = gravity
            }
            textSize?.let { size ->
                labelRightAction.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
            textFont?.let { font ->
                Typeface.createFromAsset(context.assets, font).apply { labelRightAction.typeface = this }
            }
        }
    }

    interface CoolDialogClickListener {
        fun onClick(climaxDialog: ClimaxDialog)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.layout_left_action -> {
                mLeftActionListener?.let {
                    it.onClick(this@ClimaxDialog)
                }
            }
            R.id.layout_right_action -> {
                mRightActionListener?.let {
                    it.onClick(this@ClimaxDialog)
                }
            }
            R.id.label_center_action -> {
                mCenterActionListener?.let {
                    it.onClick(this@ClimaxDialog)
                }
            }
            R.id.layout_bottom_only_action -> {
                mBottomOnlyActionListener?.let {
                    it.onClick(this@ClimaxDialog)
                }
            }
        }
    }

    fun setLeftActionListener(listener: CoolDialogClickListener): ClimaxDialog {
        mLeftActionListener = listener
        return this
    }

    fun setRightActionListener(listener: CoolDialogClickListener): ClimaxDialog {
        mRightActionListener = listener
        return this
    }

    fun setCenterActionListener(listener: CoolDialogClickListener): ClimaxDialog {
        mCenterActionListener = listener
        return this
    }

    fun setBottomOnlyActionListener(listener: CoolDialogClickListener): ClimaxDialog {
        mBottomOnlyActionListener = listener
        return this
    }

    /* Dialog Customize Function */
    fun setTitleBar(boolean: Boolean) {
        dialogItem.titleBarVisibility = boolean
    }
    fun setDialogBackgroundColor(color: String) {
        dialogItem.backgroundColor = color
    }
    fun setDialogCorner(value: FloatArray) {
        dialogItem.cornerRadius = value
    }
    fun setTitleBarColor(color: String) {
        dialogItem.titleBarColor = color
    }
    fun setTitle(title: String) {
        dialogItem.title = title
    }
    fun setTitleColor(color: String) {
        dialogItem.titleColor = color
    }
    fun setTitleGravity(gravity: Int) {
        dialogItem.titleGravity = gravity
    }
    fun setTitleSize(size: Float) {
        dialogItem.titleSize = size
    }
    fun setTitleFont(font: String) {
        dialogItem.titleFont = font
    }

    fun setContentText(content: String) {
        dialogItem.content = content
    }
    fun setContentTextGravity(gravity: Int) {
        dialogItem.contentGravity = gravity
    }
    fun setContentSize(size: Float) {
        dialogItem.contentSize = size
    }
    fun setContentColor(color: String) {
        dialogItem.contentColor = color
    }
    fun setContentFont(font: String) {
        dialogItem.contentFont = font
    }

    // left action text & color, layout color & gravity
    fun setLeftActionBackgroundColor(color: String) {
        bLRI?.leftBackgroundColor = color
    }
    fun setLeftActionText(text: String) {
        bLRI?.leftText = text
    }
    fun setLeftActionTextColor(color: String) {
        bLRI?.leftTextColor = color
    }
    fun setLeftActionTextGravity(gravity: Int) {
        bLRI?.leftTextGravity = gravity
    }
    fun setLeftActionSize(size: Float) {
        bLRI?.leftTextSize = size
    }
    fun setLeftActionFont(font: String) {
        bLRI?.leftTextFont = font
    }

    // right action text & color, layout color & gravity
    fun setRightActionBackgroundColor(color: String) {
        bLRI?.rightBackgroundColor= color
    }
    fun setRightActionText(text: String) {
        bLRI?.rightText = text
    }
    fun setRightActionTextColor(color: String) {
        bLRI?.rightTextColor = color
    }
    fun setRightActionTextGravity(gravity: Int) {
        bLRI?.rightTextGravity = gravity
    }
    fun setRightActionSize(size: Float) {
        bLRI?.rightTextSize = size
    }
    fun setRightActionFont(font: String) {
        bLRI?.rightTextFont = font
    }

    // center action text & color, layout color & gravity
    fun setBottomSingleActionBackgroundColor(color: String) {
        bSAI?.backgroundColor = color
    }
    fun setBottomSingleActionText(text: String) {
        bSAI?.text = text
    }
    fun setBottomSingleActionTextColor(color: String) {
        bSAI?.textColor = color
    }
    fun setBottomSingleActionTextGravity(gravity: Int) {
        bSAI?.textGravity = gravity
    }
    fun setBottomSingleActionSize(size: Float) {
        bSAI?.textSize = size
    }
    fun setBottomSingleActionFont(font: String) {
        bSAI?.textFont = font
    }

    private fun Int.dp(px: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (px*scale + 0.5f).toInt()
    }
}