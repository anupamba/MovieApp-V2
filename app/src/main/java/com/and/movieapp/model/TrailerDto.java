package com.and.movieapp.model;

import java.io.Serializable;


/**
 * Created by Anupam on 8/27/2018.
 *
 * "id": 333339,
 "results": [
 {
 "id": "5973c4f79251415836004bc3",
 "iso_639_1": "en",
 "iso_3166_1": "US",
 "key": "dtwpjnuaVTE",
 "name": "Ready Player One - SDCC Teaser [HD]",
 "site": "YouTube",
 "size": 1080,
 "type": "Teaser"
 },
 *
 */

public class TrailerDto implements Serializable {

    private String movieId;
    private String trailerId;
    private String key;
    private String name;
    private String site;
    private String size;
    private String teaser;

    public TrailerDto(){

    }

    public TrailerDto( String movieId, String trailerId, String key, String name,
                    String site, String size, String teaser){

        this.movieId = movieId;
        this.trailerId = trailerId;
        this.key =key;
        this.name =name;
        this.site =site;
        this.size =size;
        this.teaser =teaser;

    }


    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(String trailerId) {
        this.trailerId = trailerId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        teaser = teaser;
    }



}
