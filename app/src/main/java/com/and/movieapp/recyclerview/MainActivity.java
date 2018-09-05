package com.and.movieapp.recyclerview;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.and.movieapp.model.MovieDto;
import com.and.movieapp.util.JsonUtils;

import com.and.movieapp.util.MovieAppConstant;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements MovieAdapter.ListItemClickListener {

    private static final int NUM_LIST_ITEMS = 100;
    private String strJson ;
    /*
     * References to RecyclerView and Adapter to reset the list to its
     * "pretty" state when the reset menu item is clicked.
     */
    private MovieAdapter mAdapter;
    private RecyclerView mMovie;
    private List<MovieDto> lstMovieDto = new ArrayList<MovieDto>();


    /*
     * If we hold a reference to our Toast, we can cancel it (if it's showing)
     * to display a new Toast. If we didn't do this, Toasts would be delayed
     * in showing up if you clicked many list items in quick succession.
     */
    private Toast mToast;
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Call API to fetch Movie details -- Default call.
        MovieAPIUtil objMovieAPIUtil = new MovieAPIUtil();

        try {
            lstMovieDto = objMovieAPIUtil.callMovieSearch("TOP");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onResume () {
        super.onResume();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        MovieAPIUtil objMovieAPIUtil = new MovieAPIUtil();

        switch (itemId) {
            /*
             * When you click the reset menu item, we want to start all over
             * and display the pretty gradient again. There are a few similar
             * ways of doing this, with this one being the simplest of those
             * ways. (in our humble opinion)
             */
            case R.id.action_refresh:

                try {
                    lstMovieDto = objMovieAPIUtil.callMovieSearch("TOP");              
                }     catch (Exception e){
                    e.printStackTrace();
                }
                mAdapter = new MovieAdapter(NUM_LIST_ITEMS, this, lstMovieDto);
                mMovie.setAdapter(mAdapter);
                return true;


            case R.id.action_popular:
                try {
                    lstMovieDto = objMovieAPIUtil.callMovieSearch("POPULAR");
                }     catch (Exception e){
                    e.printStackTrace();
                }
                mAdapter = new MovieAdapter(NUM_LIST_ITEMS, this, lstMovieDto);
                mMovie.setAdapter(mAdapter);
                return true;


            case R.id.action_topRated:
                try {
                    lstMovieDto = objMovieAPIUtil.callMovieSearch("TOP");
                }     catch (Exception e){
                    e.printStackTrace();
                }

            case R.id.action_favMovie:
                try {
                    launchFavActivity();
                }     catch (Exception e){
                    e.printStackTrace();
                }


        }

        return super.onOptionsItemSelected(item);
    }

    // COMPLETED (10) Override ListItemClickListener's onListItemClick method

    /**
     * This is where we receive our callback from
     * {@link com.and.movieapp.recyclerview.MovieAdapter.ListItemClickListener}
     * <p>
     * This callback is invoked when you click on an item in the list.
     *
     * @param clickedItemIndex Index in the list of the item that was clicked.
     */
    @Override
    public void onListItemClick(int clickedItemIndex) {
        // COMPLETED (11) In the beginning of the method, cancel the Toast if it isn't null
        /*
         * Even if a Toast isn't showing, it's okay to cancel it. Doing so
         * ensures that our new Toast will show immediately, rather than
         * being delayed while other pending Toasts are shown.
         *
         * Comment out these three lines, run the app, and click on a bunch of
         * different items if you're not sure what I'm talking about.
         */
        if (mToast != null) {
            mToast.cancel();
        }


        String toastMessage = "Item #" + clickedItemIndex + " clicked." + lstMovieDto.get(clickedItemIndex).getTitle();
        mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);

        mToast.show();
        launchDetailActivity(clickedItemIndex);
    }

    private void launchDetailActivity(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.JSON_BLOCK, lstMovieDto.get(position));
        startActivity(intent);
    }

    private void launchFavActivity() {
        Intent intent = new Intent(this, FavActivity.class);
        startActivity(intent);
    }
    public class MovieAPIUtil {

        public List<MovieDto> callMovieSearch( String flag) throws Exception {

            String urlParam = "";
            if(flag == "TOP"){
                urlParam = MovieAppConstant.getApiRootUriTop();
            }else if( flag == "POPULAR"){
                urlParam = MovieAppConstant.getApiRootUriPopular();
            }

            new RestAPITask(strJson).execute(urlParam);


            return JsonUtils.parseApiResponseJson(strJson);
        }


        private BufferedReader externalAPICall(String urlParam) throws Exception {

            URL url = new URL( urlParam);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");

            return new BufferedReader(new InputStreamReader((con.getInputStream())));
        }


        private class RestAPITask extends AsyncTask<String, Void, String> {

            String json;

            RestAPITask(String json) {
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
                return null;
            }

            protected void onPostExecute(String json) {
                strJson = json;
                lstMovieDto = JsonUtils.parseApiResponseJson(json);
                callNextAxtivity();
            }
        }

    }

    private void callNextAxtivity() {
        mMovie = findViewById(R.id.rv_movie);
        mMovie.setPadding(8,8,8,8);

        mMovie.setLayoutManager(gridLayoutManager);
        mMovie.setHasFixedSize(true);

        mAdapter = new MovieAdapter(NUM_LIST_ITEMS, this,lstMovieDto);
        mMovie.setAdapter(mAdapter);
    }



}
