package com.wohlig.sava;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.matthewtamlin.sliding_intro_screen_library.indicators.DotIndicator;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Mahesh on 8/tag2/2016.
 */
public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    ViewPager viewPager;
    welcomepagerAdapter adapter;
    DotIndicator indicator;
    RelativeLayout im_new;
    TextView skip;
    RelativeLayout fb, gplus, email;
    private CallbackManager mCallbackManager;
    String deviceId,userSessionId;
    public String fb_id, fb_email, fb_Name, fb_first_name, fb_last_name, fb_gender, fb_picture, fb_birthday, fb_friends, fb_location;
    public String gP_id, gP_email, gP_Name, gP_first_name, gP_last_name, gP_gender, gP_picture, gP_birthday, gP_friends, gP_location;
    GoogleApiClient mGoogleApiClient;
    GoogleSignInOptions gso;
    private static final int RC_SIGN_IN = 102;
    AccessTokenTracker accessTokenTracker;
    ProfileTracker profileTracker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.fragment_welcome);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        indicator = (DotIndicator) findViewById(R.id.indicator);
        facebookLogin();

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int i = viewPager.getCurrentItem();
                indicator.setSelectedItem(i, true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        im_new = (RelativeLayout) findViewById(R.id.im_new);
        im_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(i);

            }
        });
        skip = (TextView) findViewById(R.id.txt_skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SavaActivity.class);
                i.putExtra("login", 1);
                startActivity(i);
            }
        });
        fb = (RelativeLayout) findViewById(R.id.rel_fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(MainActivity.this, Arrays.asList("public_profile", "email", "user_location", "user_birthday"));

            }
        });
        gplus = (RelativeLayout) findViewById(R.id.rel_gplus);
        gplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleLogin();
                signIn();
            }
        });
        email = (RelativeLayout) findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Mobile_numberActivity.class);
                startActivity(i);
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new welcomepagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new One(), "1");
        adapter.addFragment(new One(), "2");
        adapter.addFragment(new One(), "3");
        adapter.addFragment(new One(), "4");
        viewPager.setAdapter(adapter);
    }


    private void facebookLogin() {
        // AppEventsLogger.activateApp(this);
        mCallbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {

                    @Override
                    public void onSuccess(final LoginResult loginResult) {

                        Log.d("Success", "Login");
                        GraphRequest request1 = GraphRequest.newMeRequest(
                                loginResult.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject object, GraphResponse response) {
                                        // Application code
                                        FacebookSdk.setIsDebugEnabled(true);
                                        FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
                                        Log.d("object", String.valueOf(response));
                                        Log.d("loginResult", loginResult.getAccessToken().toString());
                                        try {
                                            Log.d("Fields : ", "insidetry");
                                            Log.d("object", String.valueOf(object));
                                            fb_id = object.getString("id");
                                            fb_email = object.getString("email");
                                            fb_Name = object.getString("name");
                                            fb_gender = object.getString("gender");
                                            fb_first_name = object.getString("first_name");
                                            fb_last_name = object.getString("last_name");
                                            JSONObject Json_fb_picture = object.getJSONObject("picture");
                                            JSONObject Json_fb_picture_data = Json_fb_picture.getJSONObject("data");
                                            fb_picture = Json_fb_picture_data.getString("url");
                                            Log.d("akshay", fb_id + fb_email);
//                                            fb_sign_in();
                                        } catch (Exception ignored) {

                                        }
                                    }
                                });
                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "id,name,email,location,gender,first_name,middle_name,last_name,birthday,picture");
                        // parameters.putString("access_token", "EAACEdEose0cBAOXH8Egbq8XMLRQWCzBPwVnm9WIB45ZAnsxJuqJLkmGtoVdI5RqkDJRZCqraIV8ohkTLWqbu5pLYLmlTphFdEF2PqAeEsFpXg2YR9cdI3HrfEUxkYAtnNJpVN2rW1ca37ZADm8GvjfAxgEx0YBwz8bZCzdGo3gZDZD");
                        request1.setParameters(parameters);
                        request1.executeAsync();

                        LoginManager.getInstance().logOut();
                        Log.d("details of fb", fb_Name + fb_email + fb_first_name + fb_picture);
                        startActivity(new Intent(getApplicationContext(), Mobile_numberActivity.class).putExtra("Login_source", "Facebook").putExtra("userSessionId", userSessionId));
                        finish();


                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "Login Cancel", Toast.LENGTH_LONG).show();
                        LoginManager.getInstance().logOut();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        //  facebookTracker();
    }
    private void facebookTracker() {
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                Log.d("AccessTokenTracker", " old = " + oldAccessToken + " new = " + currentAccessToken);
            }
        };

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                Log.d("ProfileTracker", " old = " + oldProfile + " new = " + currentProfile);
            }
        };
        accessTokenTracker.startTracking();
        profileTracker.startTracking();

    }

    private void googleLogin() {
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleApiClient with access to the Google Sign-In API and the
// options specified by gso.
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }
    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.d("handleSignInResult", "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            if (acct != null) {
                gP_id = acct.getId();
                gP_Name = acct.getDisplayName();
                gP_first_name = acct.getGivenName();
                gP_last_name = acct.getFamilyName();
                gP_email = acct.getEmail();
                gP_picture = String.valueOf(acct.getPhotoUrl());
                Log.d("acct", gP_id + "\n" + gP_Name + "\n" + gP_email + "\n" + gP_picture);
               // g_sign_in();
            }
            Auth.GoogleSignInApi.signOut(mGoogleApiClient);
            startActivity(new Intent(MainActivity.this, Mobile_numberActivity.class).putExtra("Login_source", "Google").putExtra("userSessionId",userSessionId));
            finish();


            //  mStatusTextView.setText(getString(R.string.signed_in_fmt, acct.getDisplayName()));
            // updateUI(true);
        } else {
            // Signed out, show unauthenticated UI.
            //updateUI(false);  mGoogleApiClient.stopAutoManage(this);
            mGoogleApiClient.stopAutoManage(this);
            mGoogleApiClient.disconnect();

        }
    }
    public Boolean isLogin() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mCallbackManager != null) {
            if (mCallbackManager.onActivityResult(requestCode, resultCode, data)) {
                return;
            }
        }
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }

    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    Timer timer;
    int page = 1;

    public void pageSwitcher(int seconds) {
        timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay
        // in
        // milliseconds
    }

    // this is an inner class...
    class RemindTask extends TimerTask {

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {

                    if (page > 4) { // In my case the number of pages are 5
                        timer.cancel();
                        // Showing a toast for just testing purpose
                        Toast.makeText(getApplicationContext(), "Timer stoped",
                                Toast.LENGTH_LONG).show();
                    } else {
                        viewPager.setCurrentItem(page++);
                    }
                }
            });

        }
    }

}
