package com.wohlig.sava;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by adiam on 6/22/2016.
 */
public class OnLeftSwipeListener implements View.OnTouchListener {

   private swipeListener swipeListener;

    public OnLeftSwipeListener(swipeListener swipeListener, Context context) {
        this.swipeListener = swipeListener;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        final int X = (int) event.getRawX();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams.leftMargin = X;
                int width = layoutParams.width + X;
                layoutParams.width = width;
                if (X > (ConfirmRedemption.screenWidth - ConfirmRedemption.MIN_WIDTH)) {
                    layoutParams.leftMargin = ConfirmRedemption.screenWidth - ConfirmRedemption.MIN_WIDTH;
                    layoutParams.width = ConfirmRedemption.MIN_WIDTH;
                }
                if(layoutParams.width > ConfirmRedemption.ninetyPercentScreenWidth){
                    layoutParams.width = ConfirmRedemption.screenWidth;
                }
                view.setLayoutParams(layoutParams);
                if(layoutParams.leftMargin < 50){
                    swipeListener.launchNextActivity();
                }
                swipeListener.onSwipe(view, layoutParams.width);
                break;
            case MotionEvent.ACTION_UP:
                swipeListener.onSwipeRelease(view, event);
                break;

        }
        return true;
    }
}
