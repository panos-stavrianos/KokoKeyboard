package com.rowland.kokokeyboard.keys;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.rowland.kokokeyboard.R;

import androidx.appcompat.widget.AppCompatButton;


public class SquareKeyView extends AppCompatButton {

    private float screenWidthPercentage = 0.20f;
    private float widthHeightRatio = 1.0f;

    public SquareKeyView(Context context) {
        super(context);
    }

    public SquareKeyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareKeyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.KeyPadView);
        try {
            this.screenWidthPercentage = a.getFloat(R.styleable.KeyPadView_screen_width_percent, 0.20f);
            this.widthHeightRatio = a.getFloat(R.styleable.KeyPadView_width_height_ratio, 1.0f);
        } finally {
            a.recycle();
        }
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        /*int minW = getPaddingLeft() + getPaddingRight() + getSuggestedMinimumWidth();
        int measuredWidth = getDefaultSize(minW, widthMeasureSpec);

        int minH = getPaddingBottom() + getPaddingTop() + getSuggestedMinimumHeight();
        int measuredHeight = getDefaultSize(minH, heightMeasureSpec);

        int finalWidth = measuredWidth;
        int finalHeight = (int) (measuredWidth / widthHeightRatio);

        setMeasuredDimension(finalWidth, finalHeight);*/
    }


    public float getScreenWidthPercentage() {
        return this.screenWidthPercentage;
    }
}
