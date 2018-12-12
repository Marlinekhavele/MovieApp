package com.example.student.movieapp;

import android.app.Application;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

public class MovieApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        TwitterAuthConfig authConfig =
                new TwitterAuthConfig("consumerKey",
                        "consumerSecret");

        Fabric.with(this, new Twitter(authConfig));

    }
}
