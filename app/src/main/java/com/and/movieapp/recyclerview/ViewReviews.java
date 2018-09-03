package com.and.movieapp.recyclerview;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.and.movieapp.data.FavMovieContract;
import com.and.movieapp.data.FavMovieDbHelper;
import com.and.movieapp.model.MovieDto;

import java.util.ArrayList;
import java.util.List;


public class FavActivity extends AppCompatActivity {

    private List<MovieDto> lstFavMovie = new ArrayList<MovieDto>();
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        LinearLayout linearLayout = findViewById(R.id.rootLayout);

        FavMovieDbHelper dbHelper = new FavMovieDbHelper(this);
        mDb = dbHelper.getReadableDatabase();
        Cursor favMovieLstCursor = getFavMovieLst();


        TextView textView0 = new TextView(this);
        textView0.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView0.setGravity(Gravity.TOP);
        textView0.setText("My Favorite Movie");
        textView0.setTextSize(36);

        textView0.setTextColor(-16776961);

        TextView textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(16);
        textView.setText("");

        // Add TextView to LinearLayout
        if (linearLayout != null) {
            linearLayout.addView(textView0);
            linearLayout.addView(textView);
        }

        int x = 1;

        if (favMovieLstCursor.getCount() > 0) {
                if (favMovieLstCursor.moveToFirst()) {
                    do {
                        //MovieDto obj =  new MovieDto();
                        //obj.setId(favMovieLstCursor.getInt(favMovieLstCursor.getColumnIndex(FavMovieContract.FavMovie.MOVIE_ID)));
                        //obj.setBackdrop_path(favMovieLstCursor.getString(favMovieLstCursor.getColumnIndex(FavMovieContract.FavMovie.BACKDROP_PATH)));

                        TextView textView1 = new TextView(this);
                        textView1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        textView1.setGravity(Gravity.CENTER);
                        textView1.setTextSize(25);
                        textView1.setTextColor(-16777216);
                        textView1.setText("FAVORITE MOVIE : " + x++);

                        TextView textView2 = new TextView(this);
                        textView2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        textView2.setGravity(Gravity.CENTER);
                        textView2.setTextSize(16);
                        textView2.setText("MOVIE_NAME :");
                        textView2.setTextColor(-16777216);

                        // Create TextView programmatically.
                        TextView textView3 = new TextView(this);
                        textView3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        textView3.setGravity(Gravity.CENTER);
                        textView3.setTextSize(16);
                        textView3.setText(favMovieLstCursor.getString(favMovieLstCursor.getColumnIndex(FavMovieContract.FavMovie.MOVIE_NAME)));
                        textView3.setTextColor(-65281 );

                        TextView textView4 = new TextView(this);
                        textView4.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        textView4.setGravity(Gravity.CENTER);
                        textView4.setTextSize(16);
                        textView4.setText("MOVIE_ID :");
                        textView4.setTextColor(-16777216);

                        // Create TextView programmatically.
                        TextView textView5 = new TextView(this);
                        textView5.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        textView5.setGravity(Gravity.CENTER);
                        textView5.setTextSize(16);
                        textView5.setText(""+favMovieLstCursor.getInt(favMovieLstCursor.getColumnIndex(FavMovieContract.FavMovie.MOVIE_ID)));
                        textView5.setTextColor(-65281 );

                        TextView textView6 = new TextView(this);
                        textView6.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        textView6.setGravity(Gravity.CENTER);
                        textView6.setTextSize(16);
                        textView6.setText("");
                        textView6.setTextColor(-16777216);

                        // Add TextView to LinearLayout
                        if (linearLayout != null) {
                            linearLayout.addView(textView1);
                            linearLayout.addView(textView2);
                            linearLayout.addView(textView3);
                            linearLayout.addView(textView4);
                            linearLayout.addView(textView5);
                            linearLayout.addView(textView6);

                        }
                    } while (favMovieLstCursor.moveToNext());
                }

        }



    }


    private Cursor getFavMovieLst(){
        return mDb.query(FavMovieContract.FavMovie.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);
    }
}
