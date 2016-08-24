package com.wohlig.sava;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.plus.model.people.Person;

import java.util.Calendar;

/**
 * Created by Mahesh on 8/12/2016.
 */
public class Personal_info extends AppCompatActivity {
    Toolbar toolbar;
    TextView toolbartitle;
    public static EditText date;
    private int mYear, mMonth, mDay;
    LinearLayout lldate;
    Spinner titlespinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_detail);
        toolbartitle = (TextView) findViewById(R.id.toolbar_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
       toolbartitle.setText("Personal Info");
       /*  toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.arrow_left5));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                finish();
            }
        });*/
       /* RadioGroup group= (RadioGroup) this.findViewById(R.id.gender);
        if (group != null) {
            group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    View radioButton = radioGroup.findViewById(i);
                    int index = radioGroup.indexOfChild(radioButton);
                    Toast.makeText(Personal_info.this, index, Toast.LENGTH_SHORT).show();
                }
            });
        }*/


      /*  titlespinner= (Spinner) findViewById(R.id.titlespinner);
        titlespinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titlespinner.getSelectedItem();
            }
        });*/
        lldate= (LinearLayout) findViewById(R.id.lldate);
        date= (EditText) findViewById(R.id.date);
        lldate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog(v);

            }
        });




      /*  DateEdit = (EditText) findViewById(R.id.date);
        DateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog(v);
            }
        });*/
    }
    public void DatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    public static class DatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            date.setText(day + "/" + (month + 1) + "/" + year);
        }
    }
}
