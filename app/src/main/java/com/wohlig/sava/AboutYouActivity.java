package com.wohlig.sava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ex.chips.BaseRecipientAdapter;
import com.android.ex.chips.RecipientEditTextView;
import com.android.ex.chips.recipientchip.DrawableRecipientChip;
import com.doodle.android.chips.views.ChipsEditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**\
 * Created by adiam on 7/29/2016.
 */
public class AboutYouActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView toolbartitle;
    ImageView mButton;
    Button display;
    RecipientEditTextView chip;
    EditText etchip;
    static Map<String,List<String>> yourMap = new HashMap<String,List<String>>();
    static  List<String> info = new ArrayList<String>();
    ImageView back;
    TextView save;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutyou);
        toolbartitle = (TextView) findViewById(R.id.toolbar_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbartitle.setText("About You");

        back = (ImageView) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mButton = (ImageView) findViewById(R.id.add);
        add(this,mButton);
        chip = (RecipientEditTextView) findViewById(R.id.edt_dietary);

        chip.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        chip.setAdapter(new BaseRecipientAdapter(BaseRecipientAdapter.QUERY_TYPE_PHONE, this));
        DrawableRecipientChip[] chips = chip.getSortedRecipients();


        display= (Button) findViewById(R.id.display);
        save(this,display);
        save = (TextView) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String title = String.valueOf(titlespinner.getSelectedItem());
//                String name = String.valueOf(etname.getText());
//                String dob = String.valueOf(date.getText());
//                String gender = String.valueOf(date.getText());

                Intent i = new Intent();

                Bundle bundle = new Bundle();
//                bundle.putString("title", title); //This is for a String
//                bundle.putString("name", name); //This is for a String
//                bundle.putString("dob", dob); //This is for a String
//                bundle.putString("gender", gender); //This is for a String
                i.setClass(getApplicationContext(), PersonalDetailActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }


    public static void save(final Activity activity, Button btn)
    {
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LinearLayout scrollViewlinerLayout = (LinearLayout) activity.findViewById(R.id.ll_household);
                HashMap<String,String> msg1=new HashMap<String, String>();
                java.util.ArrayList<String> msg = new ArrayList<String>();
                for (int i = 0; i < scrollViewlinerLayout.getChildCount(); i++)
                {
                    LinearLayout innerLayout = (LinearLayout) scrollViewlinerLayout.getChildAt(i);
                    Spinner person = (Spinner) innerLayout.findViewById(R.id.spperson);
                    Spinner person_age = (Spinner) innerLayout.findViewById(R.id.spperson_age);
                    msg.add((String) person.getSelectedItem());
                    msg1.put((String) person.getSelectedItem(),(String) person_age.getSelectedItem());
                  /*  info.add((String) person.getSelectedItem());
                    info.add((String) person_age.getSelectedItem());
                    yourMap.put("key", info);
*/
                }
                Toast t = Toast.makeText(activity.getApplicationContext(), msg1.toString(), Toast.LENGTH_SHORT);
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


}
