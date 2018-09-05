package com.and.movieapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anupam
 */

public class FavMovieDbHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "favmovie.db";

    public static final int DATABASE_VERSION = 1;


    public FavMovieDbHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        final String SQL_CREATE_FAV_MOVIE_TABLE = "CREATE TABLE " +
                FavMovieContract.FavMovie.TABLE_NAME+ " ( "+
                FavMovieContract.FavMovie._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FavMovieContract.FavMovie.MOVIE_ID + " TEXT NOT NULL, " +
                FavMovieContract.FavMovie.MOVIE_NAME + " TEXT NOT NULL, " +
                FavMovieContract.FavMovie.BACKDROP_PATH + " TEXT NOT NULL " +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_FAV_MOVIE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+FavMovieContract.FavMovie.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
