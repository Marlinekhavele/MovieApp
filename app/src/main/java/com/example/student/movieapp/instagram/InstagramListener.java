package com.example.student.movieapp.instagram;

public interface InstagramListener {

    void onInstagramSignInFail(String errorMessage);

    void onInstagramSignInSuccess(String authToken, String userId);
}