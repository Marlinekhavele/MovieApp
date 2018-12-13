package com.example.student.movieapp.Google;

public interface GoogleListener {
    void onGoogleAuthSignIn(String authToken, String userId);

    void onGoogleAuthSignInFailed(String errorMessage);

    void onGoogleAuthSignOut();
}