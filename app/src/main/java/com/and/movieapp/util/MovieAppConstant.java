package com.and.movieapp.util;

import com.and.movieapp.recyclerview.BuildConfig;

/**
 * Created by ANUPAMBA
 */

public class MovieAppConstant {


    private static final String API_KEY = "api_key="+ BuildConfig.API_KEY;
    private static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/";
    private static final String API_ROOT_URI = "https://api.themoviedb.org/3/movie/";
    private static final String YOUTUBE_TRAILER = "http://www.youtube.com/watch?v=";
    private static final String API_DEFAULT = "discover/movie?";
    private static final String API_TOP = "top_rated?";
    private static final String API_POPULAR = "popular?";
    private static final String LANGUAGE_OPTION  = "&language=en-US";
    private static final String PAGING_OPT  = "&page=1";
    private static final String TRAILER  = "/videos?";
    private static final String REVIEW  = "/reviews?";
    public static String getImageBaseUrl() {
        return IMAGE_BASE_URL;
    }

    public static String getYOUTUBE_TRAILER() {
        return YOUTUBE_TRAILER;
    }

    public static String getApiKey() {
            return API_KEY;
    }

    public static String getApiRootUri() {
        return API_ROOT_URI+API_TOP+MovieAppConstant.getApiKey()+LANGUAGE_OPTION+PAGING_OPT;
    }

    public static String getApiRootUriTop() {
        return API_ROOT_URI+API_TOP+MovieAppConstant.getApiKey()+LANGUAGE_OPTION+PAGING_OPT;
    }

    public static String getApiRootUriPopular() {
        return API_ROOT_URI+API_POPULAR+MovieAppConstant.getApiKey()+LANGUAGE_OPTION+PAGING_OPT;
    }
// https://api.themoviedb.org/3/movie/
// 333339/
// videos?
// api_key=
// &language=en-US
    public static String getApiRootUriTrailer(String movie_id) {
        return API_ROOT_URI+movie_id+TRAILER+MovieAppConstant.getApiKey()+LANGUAGE_OPTION;
    }

    public static String getApiRootUriReview(String movie_id) {
        return API_ROOT_URI+movie_id+REVIEW+MovieAppConstant.getApiKey()+LANGUAGE_OPTION;
    }
}
