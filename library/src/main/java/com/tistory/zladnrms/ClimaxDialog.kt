package com.tistory.zladnrms

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import com.tistory.zladnrms.library.R
import defy.tech.testdialog.data.DialogItem

class ClimaxDialog constructor(context: Context) : Dialog(context), View.OnClickListener {

    private val layoutDialog: NestedRoundableLayout by lazy {
        this.findViewById(R.id.layout_dialog) as NestedRoundableLayout
    }

    private val layoutTitleBar: LinearLayout by lazy {
        this.findViewById(R.id.layout_title_bar) as LinearLayout
    }
    private val tvTitle: TextView by lazy {
        this.findViewById(R.id.tv_title_bar) as TextView
    }
    private val layoutContent: LinearLayout by lazy {
        this.findViewById(R.id.layout_content) as LinearLayout
    }
    private val tvContent: TextView by lazy {
        this.findViewById(R.id.tv_content) as TextView
    }
    private val layoutLeftAction: LinearLayout by lazy {
        this.findViewById(R.id.layout_left_action) as LinearLayout
    }
    private val layoutRightAction: LinearLayout by lazy {
        this.findViewById(R.id.layout_right_action) as LinearLayout
    }
    private val tvCenterAction: TextView by lazy {
        this.findViewById(R.id.tv_center_action) as TextView
    }
    private val tvLeftAction: TextView by lazy {
        this.findViewById(R.id.tv_left_action) as TextView
    }
    private val tvRightAction: TextView by lazy {
        this.findViewById(R.id.tv_right_action) as TextView
    }
    private val layoutBottomOnlyAction: LinearLayout by lazy {
        this.findViewById(R.id.layout_bottom_only_action) as LinearLayout
    }
    private val tvBottomOnlyAction: TextView by lazy {
        this.findViewById(R.id.tv_bottom_only_action) as TextView
    }

    private var mLeftActionListener: CoolDialogClickListener? = null
    private var mRightActionListener: CoolDialogClickListener? = null
    private var mBottomOnlyActionListener: CoolDialogClickListener? = null
    private var mCenterActionListener: CoolDialogClickListener? = null

    private val dialogItem: DialogItem = DialogItem()

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        window?.attributes!!.windowAnimations = R.style.DialogAnimation
        setCancelable(true)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_climax_dialog)

        layoutLeftAction.setOnClickListener(this@ClimaxDialog)
        layoutRightAction.setOnClickListener(this@ClimaxDialog)
        tvCenterAction.setOnClickListener(this@ClimaxDialog)
        layoutBottomOnlyAction.setOnClickListener(this@ClimaxDialog)

        setDataIntoView()
    }

    private fun setDataIntoView() {
        with(dialogItem) {
            dialogBackgroundColor?.let { layoutDialog.setBackgroundColor(it) }
            dialogCorner?.let { layoutDialog.setCorner(it) }

            layoutTitleBarVisibility?.let {
                if(it) {
                    layoutTitleBar.visibility = View.VISIBLE
                }
                else {
                    layoutTitleBar.visibility = View.GONE
                }
            }

            title?.let { tvTitle.text = it }
            titleGravity?.let { tvTitle.gravity = it }
            titleColor?.let { tvTitle.setTextColor(Color.parseColor(it)) }
            titleSize?.let { tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, it) }
            titleFont?.let { Typeface.createFromAsset(context.assets, it).apply { tvTitle.setTypeface(this) } }

            layoutContentGravity?.let { layoutContent.gravity = it }
            content?.let { tvContent.text = it }
            contentGravity?.let{ tvContent.gravity = it }
            contentColor?.let{ tvContent.setTextColor(Color.parseColor(it)) }
            contentSize?.let { tvContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, it) }
            contentFont?.let { Typeface.createFromAsset(context.assets, it).apply { tvContent.setTypeface(this) } }

            centerActionColor?.let { tvCenterAction.text = it }
            centerActionBackgroundColor?.let {  }
            centerActionGravity?.let { tvCenterAction.gravity = it }
            centerActionText?.let { tvCenterAction.text = it }
            centerActionFont?.let { Typeface.createFromAsset(context.assets, it).apply { tvContent.setTypeface(this) } }

            leftActionBackgroundColor?.let { layoutLeftAction.setBackgroundColor(Color.parseColor(it)) }
            leftActionText?.let { tvLeftAction.text = it }
            rightActionText?.let { tvRightAction.text = it }
            leftActionColor?.let{ tvLeftAction.setTextColor(Color.parseColor(it)) }
            leftActionGravity?.let { tvLeftAction.gravity = it }
            leftActionFont?.let { Typeface.createFromAsset(context.assets, it).apply { tvContent.setTypeface(this) } }

            rightActionText?.let { tvRightAction.text = it }
            rightActionBackgroundColor?.let { layoutRightAction.setBackgroundColor(Color.parseColor(it)) }
            rightActionColor?.let{ tvRightAction.setTextColor(Color.parseColor(it)) }
            rightActionGravity?.let { tvRightAction.gravity = it }
            rightActionFont?.let { Typeface.createFromAsset(context.assets, it).apply { tvContent.setTypeface(this) } }

            bottomOnlyActionText?.let { tvBottomOnlyAction.text = it }
            bottomOnlyActionBackgroundColor?.let { layoutBottomOnlyAction.setBackgroundColor(Color.parseColor(it)) }
            bottomOnlyActionColor?.let{ tvBottomOnlyAction.setTextColor(Color.parseColor(it)) }
            bottomOnlyActionGravity?.let { tvBottomOnlyAction.gravity = it }
            bottomOnlyActionFont?.let { Typeface.createFromAsset(context.assets, it).apply { tvContent.setTypeface(this) } }

            centerActionVisibility?.let {
                if(it) {
                    tvCenterAction.visibility = View.VISIBLE
                }
                else {
                    tvCenterAction.visibility = View.GONE
                }
            }
            leftRightActionVisibility?.let {
                if(it) {
                    layoutLeftAction.visibility = View.VISIBLE
                    layoutRightAction.visibility = View.VISIBLE
                }
                else {
                    layoutLeftAction.visibility = View.GONE
                    layoutRightAction.visibility = View.GONE
                }
            }
            bottomOnlyActionVisibility?.let {
                if(it) {
                    layoutBottomOnlyAction.visibility = View.VISIBLE
                }
                else {
                    layoutBottomOnlyAction.visibility = View.GONE
                }
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
            R.id.tv_center_action -> {
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
    // visibility
    fun setTitleBar(boolean: Boolean) {
        dialogItem.layoutTitleBarVisibility = boolean
    }
    fun setLeftRightAction(boolean: Boolean) {
        dialogItem.leftRightActionVisibility = boolean
    }
    fun setCenterAction(boolean: Boolean) {
        dialogItem.centerActionVisibility = boolean
    }
    fun setBottomOnlyAction(boolean: Boolean) {
        dialogItem.bottomOnlyActionVisibility = boolean
    }

    // dialog background color
    fun setDialogBackgroundColor(color: String) {
        dialogItem.dialogBackgroundColor = color
    }
    fun setDialogCorner(value: FloatArray) {
        dialogItem.dialogCorner = value
    }

    // title bar text & color
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

    // content text & gravity
    fun setLayoutContentGravity(gravity: Int) {
        dialogItem.layoutContentGravity = gravity
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
        dialogItem.leftActionBackgroundColor = color
    }
    fun setLeftActionText(text: String) {
        dialogItem.leftActionText = text
    }
    fun setLeftActionTextColor(color: String) {
        dialogItem.leftActionColor = color
    }
    fun setLeftActionTextGravity(gravity: Int) {
        dialogItem.leftActionGravity = gravity
    }
    fun setLeftActionSize(size: Float) {
        dialogItem.leftActionSize = size
    }
    fun setLeftActionFont(font: String) {
        dialogItem.leftActionFont = font
    }

    // right action text & color, layout color & gravity
    fun setRightActionBackgroundColor(color: String) {
        dialogItem.rightActionBackgroundColor = color
    }
    fun setRightActionText(text: String) {
        dialogItem.rightActionText = text
    }
    fun setRightActionTextColor(color: String) {
        dialogItem.rightActionColor = color
    }
    fun setRightActionTextGravity(gravity: Int) {
        dialogItem.rightActionGravity = gravity
    }
    fun setRightActionSize(size: Float) {
        dialogItem.rightActionSize = size
    }
    fun setRightActionFont(font: String) {
        dialogItem.rightActionFont = font
    }

    // center action text & color, layout color & gravity
    fun setBottomOnlyActionBackgroundColor(color: String) {
        dialogItem.bottomOnlyActionBackgroundColor = color
    }
    fun setBottomOnlyActionText(text: String) {
        dialogItem.bottomOnlyActionText = text
    }
    fun setBottomOnlyActionTextColor(color: String) {
        dialogItem.bottomOnlyActionColor = color
    }
    fun setBottomOnlyActionTextGravity(gravity: Int) {
        dialogItem.bottomOnlyActionGravity = gravity
    }
    fun setBottomOnlyActionSize(size: Float) {
        dialogItem.bottomOnlyActionSize = size
    }
    fun setBottomOnlyActionFont(font: String) {
        dialogItem.bottomOnlyActionFont = font
    }

    private fun Int.dp(px: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (px*scale + 0.5f).toInt()
    }
}