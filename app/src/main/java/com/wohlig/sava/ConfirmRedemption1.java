package com.wohlig.sava;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by adiam on 6/17/2016.
 */
public class ConfirmRedemption1 extends AppCompatActivity implements swipeListener{

    public static int MIN_WIDTH = 100;

    private ImageView ivswiperight;
    private ImageView ivswipeleft;
    private ImageView imageView3;
    private ImageView imageView4;
    private TextView textView;

    public static int screenHalfWidth;
    public static int ninetyPercentScreenWidth;
    public static int screenWidth;
    int j=0;

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmredemption);
        ivswiperight = (ImageView) findViewById(R.id.ivswiperight);
        ivswipeleft = (ImageView) findViewById(R.id.ivswipeleft);
        imageView3 = (ImageView) findViewById(R.id.img_greenarrow);
        imageView4 = (ImageView) findViewById(R.id.img_redarrow);
        textView = (TextView) findViewById(R.id.slide);

        OnLeftSwipeListener onLeftSwipeListener = new OnLeftSwipeListener(this, this);
        OnRightSwipeListener onRightSwipeListener = new OnRightSwipeListener(this);

        ivswiperight.setOnTouchListener(onRightSwipeListener);
        ivswipeleft.setOnTouchListener(onLeftSwipeListener);

        MIN_WIDTH = (int) getResources().getDimension(R.dimen._100dp);

        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        ninetyPercentScreenWidth = (int) (display.getWidth() * 0.9);
        screenHalfWidth = display.getWidth() / 2;
        screenWidth = display.getWidth();

    }

    public void qr2Page(View view){
        finish();
    }

    @Override
    public void onSwipe(View view, int width) {
        View oppositeView = getOppositeView(view);
        imageView3.setVisibility(View.GONE);
        imageView4.setVisibility(View.GONE);
        textView.setVisibility(View.GONE);
        oppositeView.setVisibility(View.GONE);
    }

    @Override
    public void onSwipeRelease(View view, MotionEvent motionEvent) {
        View oppositeView = getOppositeView(view);
        oppositeView.setVisibility(View.VISIBLE);
        view.setVisibility(View.VISIBLE);
        imageView3.setVisibility(View.VISIBLE);
        imageView4.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        RelativeLayout.LayoutParams oppositeLayoutParams = (RelativeLayout.LayoutParams) oppositeView.getLayoutParams();
        RelativeLayout.LayoutParams viewLayoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        oppositeLayoutParams.width = MIN_WIDTH;
        viewLayoutParams.width = MIN_WIDTH;
        oppositeView.setLayoutParams(oppositeLayoutParams);
        view.setLayoutParams(viewLayoutParams);
    }

    @Override
    public void launchNextActivity() {

        if (!flag) {

                Intent intent = new Intent(this, ScanningCodeActivity.class);
                startActivity(intent);
                flag = true;


        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        flag = false;
    }


    private View getOppositeView(View view){
        View oppositeView;
        if (view.getId() == ivswiperight.getId()) {
            oppositeView = ivswipeleft;
        } else {
            oppositeView = ivswiperight;
        }
        return oppositeView;
    }

}




