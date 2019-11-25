package com.example.zladnrms.climaxdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.tistory.zladnrms.BottomDoubleDialog
import com.tistory.zladnrms.BottomSingleDialog
import com.tistory.zladnrms.ClimaxDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_1_1.setOnClickListener(this)
        button_1_2.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.button_1_1 -> {
                BottomDoubleDialog(this).apply {
                    setLeftActionText("No")
                    setRightActionText("Yes")
                    setLeftActionListener(object: BottomDoubleDialog.ClimaxDialogListener {
                        override fun onClick(climaxDialog: BottomDoubleDialog) {
                            climaxDialog.dismiss()
                        }
                    })
                    setRightActionListener(object: BottomDoubleDialog.ClimaxDialogListener {
                        override fun onClick(climaxDialog: BottomDoubleDialog) {
                            climaxDialog.dismiss()
                        }
                    })
                }.show()
            }
            R.id.button_1_2 -> {
                BottomSingleDialog(this).apply {
                    setTitleBar(true)
                    setTitle("싱글 버튼")
                    setContentText("It is your fault ")
                    setActionListener(object: BottomSingleDialog.ClimaxDialogListener {
                        override fun onClick(climaxDialog: BottomSingleDialog) {
                            climaxDialog.dismiss()
                        }
                    })
                }.show()
            }
        }
    }
}
