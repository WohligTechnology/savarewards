package com.wohlig.sava;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by adiam on 6/22/2016.
 */
public interface swipeListener {

    public void onSwipe(View view, int width);

    public void onSwipeRelease(View view, MotionEvent motionEvent);

    public void launchNextActivity();
}
