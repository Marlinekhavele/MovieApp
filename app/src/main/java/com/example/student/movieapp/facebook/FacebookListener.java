package com.example.student.movieapp.facebook;

public interface FacebookListener {
    void onFbSignInFail(String errorMessage);

    void onFbSignInSuccess(String authToken, String userId);

    void onFBSignOut();
}