package com.wohlig.sava;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Mahesh on 8/11/2016.
 */
public class Nav_draw extends Fragment {
    RelativeLayout categories,header;
    LinearLayout subcategories,logout,btm_button;
    ImageView pencil,imgblur;
    Button bsignup,blogin;
    RelativeLayout notification;
    ImageView subcat;
    View view;
    LinearLayout setting,about,help,all_offer,saved_offers,cafe,restaurants,lunch,bars,gas_stations;
    ImageView iv_blur;
//    int radiusArr[] = new int[]{25, 23, 21, 19, 17};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.nav_draw, container, false);
        notification= (RelativeLayout) view.findViewById(R.id.notifications);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SavaActivity.class);
                intent.putExtra("value",3);
                startActivity(intent);
            }
        });
        subcat= (ImageView) view.findViewById(R.id.subcat);
        categories = (RelativeLayout) view.findViewById(R.id.categories1);
        subcategories = (LinearLayout) view.findViewById(R.id.sub_categories);
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (subcategories.isShown())
                {
                    subcat.setRotation(360);
                    subcategories.setVisibility(View.GONE );
                }else{
                    Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.clockwise);
                    subcat.startAnimation(animation);
                    subcategories.setVisibility(View.VISIBLE );

                }
//                subcategories.setVisibility(subcategories.isShown() ? View.GONE : View.VISIBLE);

            }
        });
        iv_blur = (ImageView) view.findViewById(R.id.iv_blur);

        BitmapDrawable drawable = (BitmapDrawable) iv_blur.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
//        Bitmap blurred = blurRenderScript(bitmap, radiusArr[0]);//second parametre is radius
        Bitmap blurred = blurRenderScript(bitmap, 25);//second parametre is radius
        iv_blur.setImageBitmap(blurred);

        setting = (LinearLayout) view.findViewById(R.id.settings);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "setting", Toast.LENGTH_SHORT).show();

            }
        });
        about = (LinearLayout) view.findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "about", Toast.LENGTH_SHORT).show();

            }
        });
        help = (LinearLayout) view.findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "help", Toast.LENGTH_SHORT).show();

            }
        });
        all_offer = (LinearLayout) view.findViewById(R.id.all_offers);
        all_offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SavaActivity.class);
                intent.putExtra("value",2);
                startActivity(intent);
                Toast.makeText(getActivity(), "all_offer", Toast.LENGTH_SHORT).show();

            }
        });
        saved_offers = (LinearLayout) view.findViewById(R.id.saved_offers);
        saved_offers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SavaActivity.class);
                intent.putExtra("value",2);
                startActivity(intent);
                Toast.makeText(getActivity(), "saved_offers", Toast.LENGTH_SHORT).show();

            }
        });
        cafe = (LinearLayout) view.findViewById(R.id.cafe);
        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "cafe", Toast.LENGTH_SHORT).show();

            }
        });
        restaurants = (LinearLayout) view.findViewById(R.id.restaurants);
        restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "restaurants", Toast.LENGTH_SHORT).show();

            }
        });
        lunch = (LinearLayout) view.findViewById(R.id.lunch);
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "lunch", Toast.LENGTH_SHORT).show();

            }
        });
        bars = (LinearLayout) view.findViewById(R.id.bars);
        bars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "bars", Toast.LENGTH_SHORT).show();

            }
        });
        gas_stations = (LinearLayout) view.findViewById(R.id.gas_stations);
        gas_stations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "gas_stations", Toast.LENGTH_SHORT).show();

            }
        });
        header= (RelativeLayout) view.findViewById(R.id.header);
        pencil = (ImageView) header.findViewById(R.id.pencil);
        pencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonalDetailActivity.class);
                startActivity(intent);
            }
        });
        imgblur= (ImageView) header.findViewById(R.id.iv_blur);
        Bitmap blurredBitmap = null;

        imgblur.setBackgroundDrawable( new BitmapDrawable( getResources(), blurredBitmap ) );

        logout= (LinearLayout) header.findViewById(R.id.logout);
        btm_button= (LinearLayout) view.findViewById(R.id.btm_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout.setVisibility(View.GONE);
                btm_button.setVisibility(View.VISIBLE);

            }
        });


        bsignup = (Button) view.findViewById(R.id.bsignup);
        bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SignUpActivity.class);
                startActivity(intent);
            }
        });
        blogin = (Button) view.findViewById(R.id.blogin);
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
    private Bitmap blurRenderScript(Bitmap smallBitmap, int radius) {

        try {
            smallBitmap = RGB565toARGB888(smallBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Bitmap bitmap = Bitmap.createBitmap(
                smallBitmap.getWidth(), smallBitmap.getHeight(),
                Bitmap.Config.ARGB_8888);

        RenderScript renderScript = RenderScript.create(getActivity());

        Allocation blurInput = Allocation.createFromBitmap(renderScript, smallBitmap);
        Allocation blurOutput = Allocation.createFromBitmap(renderScript, bitmap);

        ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(renderScript,
                Element.U8_4(renderScript));
        blur.setInput(blurInput);
        blur.setRadius(radius); // radius must be 0 < r <= 25
        blur.forEach(blurOutput);

        blurOutput.copyTo(bitmap);
        renderScript.destroy();

        return bitmap;

    }
    private Bitmap RGB565toARGB888(Bitmap img) throws Exception {
        int numPixels = img.getWidth() * img.getHeight();
        int[] pixels = new int[numPixels];

        //Get JPEG pixels.  Each int is the color values for one pixel.
        img.getPixels(pixels, 0, img.getWidth(), 0, 0, img.getWidth(), img.getHeight());

        //Create a Bitmap of the appropriate format.
        Bitmap result = Bitmap.createBitmap(img.getWidth(), img.getHeight(), Bitmap.Config.ARGB_8888);

        //Set RGB pixels.
        result.setPixels(pixels, 0, result.getWidth(), 0, 0, result.getWidth(), result.getHeight());
        return result;
    }


}
