package com.example.student.movieapp.twitter;
public interface TwitterListener {
    void onTwitterError(String errorMessage);

    void onTwitterSignIn(String authToken, String secret, long userId);
}
