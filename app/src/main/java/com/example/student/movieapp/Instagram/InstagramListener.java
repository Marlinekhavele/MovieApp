package com.example.student.movieapp.Instagram;

public interface InstagramListener {

    void onInstagramSignInFail(String errorMessage);

    void onInstagramSignInSuccess(String authToken, String userId);
}
