package com.codebosses.builderpatternpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Sample Dialog in *Kotlin*
         * if you want to use this dialog, please comment on another dialog.
         */
        SampleKotlinDialog.Builder().contentText("Hi, this is test!")
                .leftBtnText("cancel")
                .rightBtnText("ok")
                .build(this)
                .show()

        /**
         * Sample Dialog in *JAVA*
         * if you want to use this dialog, please comment on another dialog.
         */

        SampleJavaDialog.Builder()
            .setContentText("Hi, this is test!")
            .setLeftBtnText("cancel")
            .setRightBtnText("ok")
            .build(this)
            .show()
    }

}
