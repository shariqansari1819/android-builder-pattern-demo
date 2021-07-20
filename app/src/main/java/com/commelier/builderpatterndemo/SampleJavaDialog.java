package com.codebosses.builderpatternpractice;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class SampleJavaDialog extends Dialog {

    private Context mContext;
    private String leftBtnText;
    private String rightBtnText;
    private String contentText;

    private TextView tv_left_btn;
    private TextView tv_right_btn;
    private TextView tv_content;

    public SampleJavaDialog(Context context, Builder builder) {
        super(context);
        mContext = context;

        this.contentText = builder.contentText;
        this.rightBtnText = builder.rightBtnText;
        this.leftBtnText = builder.leftBtnText;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_sample);
        initView();
    }

    private void initView() {
        tv_left_btn = (TextView) findViewById(R.id.tv_left_btn);
        tv_right_btn = (TextView) findViewById(R.id.tv_right_btn);
        tv_content = (TextView) findViewById(R.id.tv_content);


        if (leftBtnText != null) {
            tv_left_btn.setText(leftBtnText);
            tv_left_btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, leftBtnText, Toast.LENGTH_SHORT).show();
                    dismiss();
                }
            });
        }

        if (rightBtnText != null) {
            tv_right_btn.setText(rightBtnText);
            tv_right_btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, rightBtnText, Toast.LENGTH_SHORT).show();
                    dismiss();
                }
            });
        }

        if (contentText != null) {
            tv_content.setText(contentText);
        }
    }

    public static class Builder {
        private String leftBtnText;
        private String rightBtnText;
        private String contentText;

        public Builder setLeftBtnText(String text) {
            leftBtnText = text;
            return this;
        }

        public Builder setRightBtnText(String text) {
            rightBtnText = text;
            return this;
        }

        public Builder setContentText(String text) {
            contentText = text;
            return this;
        }

        public SampleJavaDialog build(Context context) {
            return new SampleJavaDialog(context, this);
        }
    }
}


