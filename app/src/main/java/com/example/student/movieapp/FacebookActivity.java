package com.example.student.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;



import org.json.JSONException;
import org.json.JSONObject;


public class FacebookActivity  extends AppCompatActivity{

    private LoginButton mLoginButton;
    private ImageView mProfileImage;
    private TextView mProfileName;

    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        callbackManager = CallbackManager.Factory.create();

        mLoginButton = findViewById(R.id.login_button);
        mProfileImage = findViewById(R.id.mProfileImage);
        mProfileName = findViewById(R.id.mProfileName);

        mLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                //Load User Data
                loadUserData(loginResult);

                Log.d("success here" , loginResult.toString());

                //Open Movie Activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {
                //Handle Cancel Here
            }

            @Override
            public void onError(FacebookException e) {
                //Handle Error Here
                Log.d("Error here" , e.toString());
            }
        });
    }

    private void loadUserData(LoginResult loginResult) {
        GraphRequest request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject object,
                            GraphResponse response) {

                        Log.i("Response ", response.toString());

                        // Application code
                        try {
                            String name = response.getJSONObject().getString("name");

                            mProfileName.setText("Welcome " + name);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link");
        request.setParameters(parameters);
        request.executeAsync();

        //Load User Image
        Glide.with(getApplicationContext())
                .load("http://graph.facebook.com/" +loginResult.getAccessToken().getUserId() +"/picture?type=large")
                .into(mProfileImage);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
