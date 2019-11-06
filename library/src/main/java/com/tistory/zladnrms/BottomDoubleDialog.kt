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

class BottomDoubleDialog constructor(context: Context) : Dialog(context), View.OnClickListener {

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
    private val labelLeftAction: TextView by lazy {
        this.findViewById(R.id.label_left_action) as TextView
    }
    private val labelRightAction: TextView by lazy {
        this.findViewById(R.id.label_right_action) as TextView
    }

    private var mLeftActionListener: ClimaxDialogListener? = null
    private var mRightActionListener: ClimaxDialogListener? = null

    private val dialogItem = DialogItem()
    private var bLRI = BottomLeftRightActionItem()

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        window?.attributes!!.windowAnimations = R.style.DialogAnimation
        setCancelable(true)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_bottom_double_dialog)

        layoutLeftAction.setOnClickListener(this@BottomDoubleDialog)
        layoutRightAction.setOnClickListener(this@BottomDoubleDialog)

        setDataIntoView()
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

        bLRI.apply {
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
    }

    interface ClimaxDialogListener {
        fun onClick(climaxDialog: BottomDoubleDialog)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.layout_left_action -> {
                mLeftActionListener?.let {
                    it.onClick(this@BottomDoubleDialog)
                }
            }
            R.id.layout_right_action -> {
                mRightActionListener?.let {
                    it.onClick(this@BottomDoubleDialog)
                }
            }
        }
    }

    fun setLeftActionListener(listener: ClimaxDialogListener): BottomDoubleDialog {
        mLeftActionListener = listener
        return this
    }

    fun setRightActionListener(listener: ClimaxDialogListener): BottomDoubleDialog {
        mRightActionListener = listener
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
        bLRI.leftBackgroundColor = color
    }
    fun setLeftActionText(text: String) {
        bLRI.leftText = text
    }
    fun setLeftActionTextColor(color: String) {
        bLRI.leftTextColor = color
    }
    fun setLeftActionTextGravity(gravity: Int) {
        bLRI.leftTextGravity = gravity
    }
    fun setLeftActionSize(size: Float) {
        bLRI.leftTextSize = size
    }
    fun setLeftActionFont(font: String) {
        bLRI.leftTextFont = font
    }

    // right action text & color, layout color & gravity
    fun setRightActionBackgroundColor(color: String) {
        bLRI.rightBackgroundColor= color
    }
    fun setRightActionText(text: String) {
        bLRI.rightText = text
    }
    fun setRightActionTextColor(color: String) {
        bLRI.rightTextColor = color
    }
    fun setRightActionTextGravity(gravity: Int) {
        bLRI.rightTextGravity = gravity
    }
    fun setRightActionSize(size: Float) {
        bLRI.rightTextSize = size
    }
    fun setRightActionFont(font: String) {
        bLRI.rightTextFont = font
    }
}