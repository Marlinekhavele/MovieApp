package com.example.student.movieapp.Twitter;

public interface TwitterListener {
    void onTwitterError(String errorMessage);

    void onTwitterSignIn(String authToken, String secret, long userId);
}