package com.and.movieapp.data;

import android.provider.BaseColumns;

/**
 * Created by Anupam
 */

public class FavMovieContract {

    private FavMovieContract(){

    }

    public static final class FavMovie implements BaseColumns{
        public static final String TABLE_NAME = "tb_favmovie";
        public static final String MOVIE_NAME = "movie_name";
        public static final String MOVIE_ID = "movie_id";
        public static final String BACKDROP_PATH= "backdrop_path";
    }
}
