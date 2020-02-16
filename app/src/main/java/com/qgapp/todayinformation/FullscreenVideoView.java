package com.qgapp.todayinformation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by ACER on 2020/2/15.
 */

public class FullscreenVideoView extends VideoView{
    public FullscreenVideoView(Context context) {
        super(context);
    }

    public FullscreenVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullscreenVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0,widthMeasureSpec);
        int height = getDefaultSize(0,heightMeasureSpec);
        setMeasuredDimension(width,height);

    }
}
