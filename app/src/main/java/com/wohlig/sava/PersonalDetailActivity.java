package com.wohlig.sava;

import android.*;
import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by adiam on 7/28/2016.
 */
public class PersonalDetailActivity extends AppCompatActivity {
    static EditText DateEdit;
    Toolbar toolbar;
    TextView toolbartitle;
    TextView tvadd,tvemail,tvphone;
    ImageView pd_pencil,cd_pencil,add_pencil,ay_pencil;
    RelativeLayout profile_pic;
    ImageView imageView;
    private String userChoosenTask;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        toolbartitle = (TextView) findViewById(R.id.toolbar_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbartitle.setText("My Profile");



        Bundle bundle = null;
        bundle = this.getIntent().getExtras();
        tvadd= (TextView) findViewById(R.id.tvadd);
        tvemail= (TextView) findViewById(R.id.tvemail);
        tvphone= (TextView) findViewById(R.id.tvphone);

        if(bundle!=null) {
            String address = bundle.getString("Address");
            tvadd.setText(address);

        }
        if(bundle!=null) {
            String email = bundle.getString("email");
            tvemail.setText(email);

        }
        if(bundle!=null) {
            String email = bundle.getString("Phone");
            tvphone.setText(email);

        }

        imageView= (ImageView) findViewById(R.id.imageView);
        profile_pic= (RelativeLayout) findViewById(R.id.rlprofilepic);
        profile_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                boolean result=Utility.checkPermission(PersonalDetailActivity.this);
                Log.d("camera pro pic", "onClick: ");



                final CharSequence[] items = {"Take Photo", "Choose from Library",
                        "Cancel"};

                AlertDialog.Builder builder = new AlertDialog.Builder(PersonalDetailActivity.this);
                builder.setTitle("Add Photo!");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        boolean result = Utility.checkPermission(PersonalDetailActivity.this);

                        if (items[item].equals("Take Photo")) {
                            userChoosenTask = "Take Photo";
                            if (result) {
                                cameraIntent();
                            }
                        } else if (items[item].equals("Choose from Library")) {
                            userChoosenTask = "Choose from Library";
                            if (result)
                                galleryIntent();

                        } else if (items[item].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();



            }
        });

        pd_pencil= (ImageView) findViewById(R.id.pd_pencil);
        pd_pencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Personal_info.class);
                startActivity(intent);

            }
        });
        cd_pencil= (ImageView) findViewById(R.id.cd_pencil);
        cd_pencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Contacts.class);
                startActivity(intent);

            }
        });
        add_pencil= (ImageView) findViewById(R.id.add_pencil);
        add_pencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Address.class);
                startActivity(intent);

            }
        });
        ay_pencil= (ImageView) findViewById(R.id.ay_pencil);
        ay_pencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AboutYouActivity.class);
                startActivity(intent);

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
    private void cameraIntent() {
        if(checkPermissionForCamera()) {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            Log.d("camera pro pic", "onClick: 11");

    /*create instance of File with name img.jpg*/
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "img.jpg");
    /*put uri as extra in intent object*/
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
    /*start activity for result pass intent as argument and request code */
            startActivityForResult(intent, 1);
        }

    }

    private void galleryIntent() {

        //Intent imageDownload = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Intent imageDownload = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        imageDownload.putExtra("crop", "true");
        imageDownload.putExtra("aspectX", 1);
        imageDownload.putExtra("aspectY", 1);
        imageDownload.putExtra("outputX", 200);
        imageDownload.putExtra("outputY", 200);
        imageDownload.putExtra("return-data", true);
        startActivityForResult(imageDownload, 2);
    }

    public void DatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void hideKeyboard() {

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (getWindow().getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public boolean checkPermissionForCamera(){
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.CAMERA},1);
            return false;
        }}
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
            DateEdit.setText(day + "/" + (month + 1) + "/" + year);
        }
    }


  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
          Bundle extras = data.getExtras();
          Bitmap image = extras.getParcelable("data");
          imageView.setImageBitmap(image);
      }
      if (requestCode == 3 && resultCode == RESULT_OK /*&& data != null*/) {

          //create instance of File with same name we created before to get image from storage
          File file = new File(Environment.getExternalStorageDirectory() + File.separator + "img.jpg");

          //Crop the captured image using an other intent
          try {
    /*the user's device may not support cropping*/
              cropCapturedImage(Uri.fromFile(file));
          } catch (ActivityNotFoundException aNFE) {
              //display an error message if user device doesn't support
              String errorMessage = "Sorry - your device doesn't support the crop action!";
              Toast toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT);
              toast.show();
          }
          //ivProfilePicture.setImageBitmap(image);
      }
      if (requestCode == 4 && resultCode == RESULT_OK && data != null) {
          // get the returned data

          Bundle extras = data.getExtras();
          //get the cropped bitmap from extras
          Bitmap thePic = extras.getParcelable("data");
          //set image bitmap to image view

          ByteArrayOutputStream bytes = new ByteArrayOutputStream();
          thePic.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

//you can create a new file name "test.jpg" in sdcard folder.
          File f = new File(Environment.getExternalStorageDirectory()
                  + File.separator + "profilepicture.jpg");
          try {
              f.createNewFile();
              FileOutputStream fo = new FileOutputStream(f);
              fo.write(bytes.toByteArray());
              fo.close();
          } catch (IOException e) {
              e.printStackTrace();
          }

          imageView.setImageBitmap(thePic);


      }
        /*if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CAMERA)
        }*/
  }
    //create helping method cropCapturedImage(Uri picUri)
    public void cropCapturedImage(Uri picUri){
        //call the standard crop action intent
        Intent cropIntent = new Intent("com.android.camera.action.CROP");
        //indicate image type and Uri of image
        cropIntent.setDataAndType(picUri, "image/*");
        //set crop properties
        cropIntent.putExtra("crop", "true");
        //indicate aspect of desired crop
        cropIntent.putExtra("aspectX", 1);
        cropIntent.putExtra("aspectY", 1);
        //indicate output X and Y
        cropIntent.putExtra("outputX", 256);
        cropIntent.putExtra("outputY", 256);
        //retrieve data on return
        cropIntent.putExtra("return-data", true);
        //start the activity - we handle returning in onActivityResult
        startActivityForResult(cropIntent, 2);
    }
}




