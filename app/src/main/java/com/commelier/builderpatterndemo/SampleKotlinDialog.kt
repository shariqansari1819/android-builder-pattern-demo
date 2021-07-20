package com.codebosses.builderpatternpractice

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import kotlinx.android.synthetic.main.dialog_sample.*

class SampleKotlinDialog(context: Context, private val builder : Builder) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_sample)
        initView()
    }

    private fun initView() {
        builder.leftBtnText?.let {
            tv_left_btn.text = builder.leftBtnText
            tv_left_btn.setOnClickListener {
                Toast.makeText(context, builder.leftBtnText, Toast.LENGTH_SHORT).show()
                dismiss()
            }
        }

        builder.rightBtnText?.let {
            tv_right_btn.text = builder.rightBtnText
            tv_right_btn.setOnClickListener {
                Toast.makeText(context, builder.rightBtnText, Toast.LENGTH_SHORT).show()
                dismiss()
            }
        }

        builder.contentText?.let {
            tv_content.text = builder.contentText
            tv_content.setOnClickListener {
                Toast.makeText(context, builder.contentText, Toast.LENGTH_SHORT).show()
            }
        }
    }

    class Builder {
        var leftBtnText : String? = null
        var rightBtnText : String? = null
        var contentText : String? = null

        fun leftBtnText(text : String) = apply { this.leftBtnText = text }
        fun rightBtnText(text : String) = apply { this.rightBtnText = text}
        fun contentText(text : String) = apply { this.contentText = text}

        fun build(context : Context) = SampleKotlinDialog(context, this)
    }
}