package com.example.student.movieapp.movies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.student.movieapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Student on 9/21/2017.
 */

public class MovieDetailActivity extends AppCompatActivity{

    private static final String ARG_TITLE = "title";
    private static final String ARG_RATING ="rating";
    private static final String ARG_POSTER ="poster";
    private static final String ARG_OVERVIEW ="overview";
    private static final String ARG_RELEASE_DATE ="releaseDate";

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.rating)
    TextView mRating;
    @BindView(R.id.overView)
    TextView mOverview;
    @BindView(R.id.releaseDate)
    TextView mReleaseDate;
    @BindView(R.id.image)
    ImageView mImage;

    private Context mContext;
    private String title;
    private double rating;
    private String posterUrl;
    private String overview;
    private String releaseDate;


    public static Intent newIntent(Context mContext, String posterUrl, String title, double rating, String overview, String releaseDate){
        Intent intent=new Intent(mContext,MovieDetailActivity.class);
        intent.putExtra(ARG_TITLE,title);
        intent.putExtra(ARG_RATING,rating);
        intent.putExtra(ARG_POSTER,posterUrl);
        intent.putExtra(ARG_OVERVIEW,overview);
        intent.putExtra(ARG_RELEASE_DATE,releaseDate);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
        mContext=MovieDetailActivity.this;
        init();
    }


    private void init(){
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            title=bundle.getString(ARG_TITLE);
            rating=bundle.getDouble(ARG_RATING);
            posterUrl=bundle.getString(ARG_POSTER);
            overview=bundle.getString(ARG_OVERVIEW);
            releaseDate=bundle.getString(ARG_RELEASE_DATE);

            mTitle.setText(title);
            mRating.setText(String.valueOf(rating));
            mOverview.setText(overview);
            mReleaseDate.setText(releaseDate);

            Glide.with(mContext)
                    .load(posterUrl)
                    .into(mImage);

            setTitle(title);
        }
    }
}
