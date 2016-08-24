package com.wohlig.sava;

import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by adiam on 6/22/2016.
 */
public class OnRightSwipeListener implements View.OnTouchListener {

    private swipeListener swipeListener;

    public OnRightSwipeListener(swipeListener swipeListener) {
        this.swipeListener = swipeListener;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                int width = (int) event.getX();
                if (width >= 100) {
                    layoutParams.width = width;
                } else {
                    layoutParams.width = qr2.MIN_WIDTH;
                }
                if(layoutParams.width > qr2.ninetyPercentScreenWidth){
                    layoutParams.width = qr2.screenWidth;
                }
                view.setLayoutParams(layoutParams);
                if(layoutParams.width == qr2.screenWidth){
                    swipeListener.launchNextActivity();
                }
                swipeListener.onSwipe(view, layoutParams.width);
                break;
            case MotionEvent.ACTION_UP:
                swipeListener.onSwipeRelease(view,event);
                break;

        }
        return true;
    }
}
