package com.and.movieapp.recyclerview;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.and.movieapp.util.JsonUtils;
import com.and.movieapp.util.MovieAppConstant;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import java.util.Map;

/***
 *
 * "id": "5488c29bc3a3686f4a00004a",
 "author": "Travis Bell",
 "content": "Like most of the reviews here, I agree that Guardians of the Galaxy was an absolute hoot. Guardians never takes itself too seriously which makes this movie a whole lot of fun.\r\n\r\nThe cast was perfectly chosen and even though two of the main five were CG, knowing who voiced and acted alongside them completely filled out these characters.\r\n\r\nGuardians of the Galaxy is one of those rare complete audience pleasers. Good fun for everyone!",
 "iso_639_1": "en",
 "media_id": 118340,
 "media_title": "Guardians of the Galaxy",
 "media_type": "Movie",
 "url": "https://www.themoviedb.org/review/5488c29bc3a3686f4a00004a"
 * */

public class ViewReviews extends AppCompatActivity {

    private Map<String, String> mapReview = new HashMap<>();
    private String strMovieName = "";
    public  String strJson ;
    String strMobieId ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);


        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        strMobieId=intent.getExtras().get(DetailActivity.MOVIE_ID).toString();
        String urlParam = MovieAppConstant.getApiRootUriReview( strMobieId+"");
        new RestAPIReviewTask(strJson).execute(urlParam);


    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private class RestAPIReviewTask extends AsyncTask<String, Void, String> {

        String json;

        RestAPIReviewTask(String json) {
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
            mapReview = JsonUtils.parseApiRestReviewJson(json);// Trailer
            //call NextActivity(); Load GUI for r=first 3 Trailer
            NextActivity();
        }
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

    private void NextActivity(){

        LinearLayout linearLayout = findViewById(R.id.reviewLayout);
        TextView textView0 = new TextView(this);
        textView0.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView0.setGravity(Gravity.TOP);
        textView0.setText("Movie Review's : "+strMovieName);
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

        if (mapReview.size() > 0) {
            for (Object key : mapReview.keySet()) {



                TextView textView1 = new TextView(this);
                textView1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textView1.setGravity(Gravity.CENTER);
                textView1.setTextSize(25);
                textView1.setTextColor(-16777216);
                textView1.setText("Review : " + x++);

                TextView textView2 = new TextView(this);
                textView2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textView2.setGravity(Gravity.CENTER);
                textView2.setTextSize(12);
                textView2.setText("Author :");
                textView2.setTextColor(-16777216);

                // Create TextView programmatically.
                TextView textView3 = new TextView(this);
                textView3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textView3.setGravity(Gravity.CENTER);
                textView3.setTextSize(16);
                textView3.setText(key.toString());
                textView3.setTextColor(-65281 );

                TextView textView4 = new TextView(this);
                textView4.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textView4.setGravity(Gravity.CENTER);
                textView4.setTextSize(12);
                textView4.setText("Review :");
                textView4.setTextColor(-16777216);

                // Create TextView programmatically.
                TextView textView5 = new TextView(this);
                textView5.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textView5.setGravity(Gravity.CENTER);
                textView5.setTextSize(16);
                textView5.setText(mapReview.get(key));
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
            }
        }

    }

    }



