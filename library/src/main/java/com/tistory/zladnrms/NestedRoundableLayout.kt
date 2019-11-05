package com.tistory.zladnrms

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Path
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.tistory.zladnrms.library.R

class NestedRoundableLayout : ConstraintLayout {

    private var drawable: GradientDrawable? = null
    private var path: Path? = null
    private var cornerLeftTop: Float = 0F
    private var cornerRightTop: Float = 0F
    private var cornerLeftBottom: Float = 0F
    private var cornerRightBottom: Float = 0F
    private var backgroundColor: String? = null

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initDrawable()
        setBackgroundWithDrawable(attrs)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initDrawable()
        setBackgroundWithDrawable(attrs)
    }

    constructor(context: Context) : super(context) {
        initDrawable()
        setBackgroundWithDrawable(null)
    }

    private fun setBackgroundWithDrawable(attrs: AttributeSet?) {
        attrs?.let {

            //set corner radii
            context.obtainStyledAttributes(attrs, R.styleable.NestedRoundableLayout).apply {
                cornerLeftTop = this.getDimensionPixelSize(R.styleable.NestedRoundableLayout_cornerLeftTop,0).toFloat()
                cornerRightTop = this.getDimensionPixelSize(R.styleable.NestedRoundableLayout_cornerRightTop,0).toFloat()
                cornerLeftBottom = this.getDimensionPixelSize(R.styleable.NestedRoundableLayout_cornerLeftBottom,0).toFloat()
                cornerRightBottom = this.getDimensionPixelSize(R.styleable.NestedRoundableLayout_cornerRightBottom,0).toFloat()
                backgroundColor = this.getString(R.styleable.NestedRoundableLayout_backgroundColor)
            }.run {
                this.recycle()
            }

            //set background
            GradientDrawable().apply {
                this.cornerRadii = floatArrayOf(cornerLeftTop, cornerLeftTop, cornerRightTop, cornerRightTop, cornerRightBottom, cornerRightBottom, cornerLeftBottom, cornerLeftBottom)

                backgroundColor?.let { // set background color
                    this.setColor(Color.parseColor(it))
                } ?: this.setColor(Color.WHITE) // set background color default : WHITE
                background = this
            }

            clipChildren = false
        }
    }

    override fun dispatchDraw(canvas: Canvas) {
        if(path == null) {
            path = Path()
        }

        floatArrayOf(cornerLeftTop, cornerLeftTop, cornerRightTop, cornerRightTop, cornerRightBottom, cornerRightBottom, cornerLeftBottom, cornerLeftBottom).apply {
            path?.let {
                it.addRoundRect(RectF(0F,0F,canvas.width.toFloat(), canvas.height.toFloat()), this, Path.Direction.CW)
                canvas.clipPath(it)
            }
        }
        super.dispatchDraw(canvas)
    }

    /* Only In NestedRoundableLayout */
    // set Background Color Programmingly
    fun setBackgroundColor(color: String) {
        drawable?.let {
            it.setColor(Color.parseColor(color))
            background = it

            clipChildren = false
        }
    }

    private fun initDrawable() {
        drawable = GradientDrawable()
    }
    // set Corner Value Programmingly
    fun setCorner(corner: FloatArray) {
        drawable?.let {
            it.cornerRadii = corner/*floatArrayOf(
                cornerRightBottom,
                cornerRightBottom,
                cornerRightTop,
                cornerRightTop,
                cornerLeftTop,
                cornerLeftTop,
                cornerLeftBottom,
                cornerLeftBottom
            )*/
        }

        clipChildren = false
    }

    private fun setCornerRound(context: Context, attrs: AttributeSet?) {
        attrs?.let {
            context.obtainStyledAttributes(attrs, R.styleable.NestedRoundableLayout).apply {
                cornerLeftTop = this.getDimensionPixelSize(R.styleable.NestedRoundableLayout_cornerLeftTop,0).toFloat()
                cornerRightTop = this.getDimensionPixelSize(R.styleable.NestedRoundableLayout_cornerRightTop,0).toFloat()
                cornerLeftBottom = this.getDimensionPixelSize(R.styleable.NestedRoundableLayout_cornerLeftBottom,0).toFloat()
                cornerRightBottom = this.getDimensionPixelSize(R.styleable.NestedRoundableLayout_cornerRightBottom,0).toFloat()
                backgroundColor = this.getString(R.styleable.NestedRoundableLayout_backgroundColor)
            }.run {
                this.recycle()
            }
        }
    }
}