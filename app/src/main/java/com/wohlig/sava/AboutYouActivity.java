package com.wohlig.sava;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by adiam on 7/29/2016.
 */
public class AboutYouActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView toolbartitle;
    ImageView mButton;
    Spinner person ,perosn_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutyou);
        toolbartitle = (TextView) findViewById(R.id.toolbar_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbartitle.setText("About You");

        mButton = (ImageView) findViewById(R.id.add);
        add(this,mButton);

      /*  mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAdd(view);

            }
        });*/

       /* mLayout = (LinearLayout) findViewById(R.id.lladd);
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (ImageView) findViewById(R.id.add);
        mButton.setOnClickListener(onClick());
        TextView textView = new TextView(this);
        textView.setText("New text");*/

    }

    public void onClickAdd(View view) {
        LayoutInflater ltInflater = getLayoutInflater();
        final LinearLayout subLayoutFields = (LinearLayout) findViewById(R.id.ll_household);
        final View view1 = ltInflater.inflate(R.layout.lladdview, subLayoutFields, true);
        ImageView buttonRemove = (ImageView) view1.findViewById(R.id.remove);


        buttonRemove.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                subLayoutFields.removeView((LinearLayout) (v.getParent().getParent()));
            }
        });

    }
    public static void display(final Activity activity, Button btn)
    {
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LinearLayout scrollViewlinerLayout = (LinearLayout) activity.findViewById(R.id.ll_household);
                java.util.ArrayList<String> msg = new ArrayList<String>();
                for (int i = 0; i < scrollViewlinerLayout.getChildCount(); i++)
                {
                    LinearLayout innerLayout = (LinearLayout) scrollViewlinerLayout.getChildAt(i);
                    Spinner person = (Spinner) innerLayout.findViewById(R.id.spperson);
                    Spinner person_age = (Spinner) innerLayout.findViewById(R.id.spperson_age);
                    msg.add((String) person.getSelectedItem());


                   /* EditText edit = (EditText) innerLayout.findViewById(R.id.editDescricao);
                    msg.add(edit.getText().toString());*/
                }
                Toast t = Toast.makeText(activity.getApplicationContext(), msg.toString(), Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }

    public static void add(final Activity activity, ImageView btn)
    {
        final LinearLayout linearLayoutForm = (LinearLayout) activity.findViewById(R.id.ll_household);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final LinearLayout newView = (LinearLayout)activity.getLayoutInflater().inflate(R.layout.lladdview, null);
                newView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                ImageView btnRemove = (ImageView) newView.findViewById(R.id.remove);
                btnRemove.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        linearLayoutForm.removeView(newView);
                    }
                });
                linearLayoutForm.addView(newView);
            }
        });
    }
/*    private View.OnClickListener onClick() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mLayout.addView(createNewTextView(mEditText.getText().toString()));
            }
        };
    }

    private TextView createNewTextView(String text) {
        final RelativeLayout.LayoutParams lparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setText("New text: " + text);
        return textView;
    }*/
}
