package com.and.movieapp.recyclerview;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.and.movieapp.data.FavMovieContract;
import com.and.movieapp.data.FavMovieDbHelper;
import com.and.movieapp.model.MovieDto;
import com.and.movieapp.model.TrailerDto;
import com.and.movieapp.util.JsonUtils;
import com.and.movieapp.util.MovieAppConstant;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class DetailActivity extends AppCompatActivity {

    public static final String JSON_BLOCK = "json";
    public static final String MOVIE_ID = "movie_id";
    public  String strJson ;
    private List<TrailerDto> lstTrailerDto = new ArrayList<>();
    private ImageView btnTrailer1, btnTrailer2, btnTrailer3, btnAdd2Fav;
    private Button btnReview;
    private SQLiteDatabase mDb;
    private MovieDto objMovieDto = new MovieDto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        objMovieDto= (MovieDto)intent.getSerializableExtra(JSON_BLOCK);
        if (objMovieDto == null) {
            closeOnError();
            return;
        }

       new DownloadImageTask((ImageView) findViewById(R.id.poster_path_img)).execute(MovieAppConstant.getImageBaseUrl()+objMovieDto.getBackdrop_path());

        populateUI(objMovieDto);

        setTitle(objMovieDto.getTitle());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(MovieDto objMovieDto) {

        TextView title_tv = findViewById(R.id.title_tv);
        title_tv.setText(null != objMovieDto.getTitle()  ? objMovieDto.getTitle() : "Not Available");

        TextView original_title_tv = findViewById(R.id.original_title_tv);
        original_title_tv.setText(null != objMovieDto.getOriginal_title()  ? objMovieDto.getOriginal_title() : "Not Available");

        TextView overview_tv = findViewById(R.id.overview_tv);
        overview_tv.setText(null != objMovieDto.getOverview()  ? objMovieDto.getOverview() : "Not Available");

        TextView original_language_tv = findViewById(R.id.original_language_tv);
        original_language_tv.setText(null != objMovieDto.getOriginal_language()  ? objMovieDto.getOriginal_language() : "Not Available");

        TextView popularity_tv = findViewById(R.id.popularity_tv);
        popularity_tv.setText(Float.toString(objMovieDto.getPopularity()));

        TextView adult_tv = findViewById(R.id.adult_tv);
        adult_tv.setText( objMovieDto.isAdult() ? "True" : "False");

        TextView video_tv = findViewById(R.id.video_tv);
        video_tv.setText( objMovieDto.isVideo() ? "True" : "False");

        TextView vote_count_tv = findViewById(R.id.vote_count_tv);
        vote_count_tv.setText(Integer.toString(objMovieDto.getVote_count()));

        TextView release_date_tv = findViewById(R.id.release_date_tv);
        release_date_tv.setText(null != objMovieDto.getRelease_date()  ? objMovieDto.getRelease_date() : "Not Available");

        TextView geners_tv = findViewById(R.id.genre_ids_tv);
        //geners_tv.setText(null != objMovieDto.getGenre_ids()  ? objMovieDto.getGenre_ids().toString() : "Not Available");

        String urlParam = MovieAppConstant.getApiRootUriTrailer( objMovieDto.getId()+"");
        new RestAPITrailerTask(strJson).execute(urlParam);


    }


    private class RestAPITrailerTask extends AsyncTask<String, Void, String> {

        String json;

        RestAPITrailerTask(String json) {
            this.json = json;
        }

        protected String doInBackground(String... urls) {
            try {
                strJson = externalAPICall(urls[0]).readLine().toString();
                json =  strJson;
                return strJson;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return strJson;
        }

        protected void onPostExecute(String json) {
            strJson = json;
            lstTrailerDto = JsonUtils.parseApiResTrailerJson(json);// Trailer
            //call NextActivity(); Load GUI for r=first 3 Trailer
            NextActivity();
        }
    }


   private void NextActivity(){
       btnTrailer1 = findViewById(R.id.btnTrailer1);
       btnTrailer1.setTag("1");
       btnTrailer2 = findViewById(R.id.btnTrailer2);
       btnTrailer2.setTag("2");
       btnTrailer3 = findViewById(R.id.btnTrailer3);
       btnTrailer3.setTag("3");
       setListner(btnTrailer1);
       setListner(btnTrailer2);
       setListner(btnTrailer3);

       btnAdd2Fav = findViewById(R.id.btnAdd2Fav);
       setListnerFav(btnAdd2Fav);
       btnReview = findViewById(R.id.btnReview);
       setListnerReview(btnReview);


       }

private void setListner(final ImageView btnTrailer){
    btnTrailer.setOnClickListener(new View.OnClickListener()   {
        public void onClick(View v)  {
            try {
                //if(btnTrailer.getTag().toString().equalsIgnoreCase("1")) PASS Intent
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse( MovieAppConstant.getYOUTUBE_TRAILER() + lstTrailerDto.get(Integer.parseInt(btnTrailer.getTag().toString())).getKey())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

    private void setListnerReview(final Button btnReview){
        btnReview.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                try {
                    launchDetailActivity();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void launchDetailActivity() {
        Intent intent = new Intent(this, ViewReviews.class);
        intent.putExtra(DetailActivity.MOVIE_ID,objMovieDto.getId() );
        startActivity(intent);
    }

    private void setListnerFav(final ImageView btnTrailer){
        btnTrailer.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                try {

                    FavMovieDbHelper dbHelper = new FavMovieDbHelper(DetailActivity.this);
                    mDb = dbHelper.getWritableDatabase();
                    ContentValues cv =  new ContentValues();
                    cv.put(FavMovieContract.FavMovie.MOVIE_ID,objMovieDto.getId());
                    cv.put(FavMovieContract.FavMovie.MOVIE_NAME,objMovieDto.getTitle());
                    cv.put(FavMovieContract.FavMovie.BACKDROP_PATH,objMovieDto.getBackdrop_path());
                    mDb.insert(FavMovieContract.FavMovie.TABLE_NAME,null, cv);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private BufferedReader externalAPICall(String urlParam) throws Exception {

        URL url = new URL( urlParam);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

         return new BufferedReader(new InputStreamReader(con.getInputStream()));
         //con.getErrorStream();
        //return null;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
    // https://api.themoviedb.org/3/movie/
    // 299536
    // /videos?
    // api_key=7b574b6131e3f2e40fd6da81fc62d1ee
    // &language=en-US
}
