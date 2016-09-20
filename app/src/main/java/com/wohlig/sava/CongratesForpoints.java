package com.wohlig.sava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by adiam on 6/20/2016.
 */
public class CongratesForpoints extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.congratesforpoints);
        ImageView share_icon= (ImageView) findViewById(R.id.share_icon);
        share_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                  /*  Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/html");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml("<p>This is the text that will be shared.</p>"));
                    startActivity(Intent.createChooser(sharingIntent,"Share using"));*/

                    Intent sharingIntent1 = new Intent(Intent.ACTION_SEND);
                    Uri screenshotUri = Uri.parse("http://sudarmuthu.com/wp/wp-content/uploads/2011/01/sharing-content-android.png");
                    sharingIntent1.setType("image/png");
                    sharingIntent1.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                    startActivity(Intent.createChooser(sharingIntent1, "Share image using"));

                }
                catch(Exception e)
                { //e.toString();
                }
            }
        });

    }
    public void qr4Page(View view){
        Intent intent = new Intent(this,ConfirmRedemption.class);
        startActivity(intent);
    }

}
