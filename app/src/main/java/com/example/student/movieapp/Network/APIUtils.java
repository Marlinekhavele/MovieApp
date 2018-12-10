package com.example.student.movieapp.Network;

/**
 *
 */

public class APIUtils {
    private static final String BASE_URL="https://api.themoviedb.org/3/";
    public static final String IMAGE_BASE_URL="http://image.tmdb.org/t/p/w342/";//w185
    public static final String API_KEY="c76fb0e97e8122287cfe28d173567350";

    public static APIService getApiService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}