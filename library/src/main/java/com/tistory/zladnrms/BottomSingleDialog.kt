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

class BottomSingleDialog constructor(context: Context) : Dialog(context), View.OnClickListener {

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
    private val layoutBottomSingleAction: LinearLayout by lazy {
        this.findViewById(R.id.layout_bottom_single_action) as LinearLayout
    }
    private val labelBottomSingleAction: TextView by lazy {
        this.findViewById(R.id.label_bottom_single_action) as TextView
    }

    private var mSingleActionListener: ClimaxDialogListener? = null

    private val dialogItem = DialogItem()
    private var bSAI = BottomSingleActionItem()

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        window?.attributes!!.windowAnimations = R.style.DialogAnimation
        setCancelable(true)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_bottom_single_dialog)

        layoutBottomSingleAction.setOnClickListener(this@BottomSingleDialog)

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

        bSAI.apply {
            backgroundColor?.let {

            }
            text?.let { text ->
                labelBottomSingleAction.text = text
            }
            textColor?.let{color ->
                labelBottomSingleAction.setTextColor(Color.parseColor(color))
            }
            textGravity?.let { gravity ->
                labelBottomSingleAction.gravity = gravity
            }
            textSize?.let { size ->
                labelBottomSingleAction.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
            textFont?.let { font ->
                Typeface.createFromAsset(context.assets, font).apply { labelBottomSingleAction.typeface = this }
            }
        }
    }

    interface ClimaxDialogListener {
        fun onClick(climaxDialog: BottomSingleDialog)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.layout_left_action -> {
                mSingleActionListener?.let {
                    it.onClick(this@BottomSingleDialog)
                }
            }
        }
    }

    fun setActionListener(listener: ClimaxDialogListener): BottomSingleDialog {
        mSingleActionListener = listener
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

    // center action text & color, layout color & gravity
    fun setBottomSingleActionBackgroundColor(color: String) {
        bSAI.backgroundColor = color
    }
    fun setBottomSingleActionText(text: String) {
        bSAI.text = text
    }
    fun setBottomSingleActionTextColor(color: String) {
        bSAI.textColor = color
    }
    fun setBottomSingleActionTextGravity(gravity: Int) {
        bSAI.textGravity = gravity
    }
    fun setBottomSingleActionSize(size: Float) {
        bSAI.textSize = size
    }
    fun setBottomSingleActionFont(font: String) {
        bSAI.textFont = font
    }
}