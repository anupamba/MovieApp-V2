package com.and.movieapp.util;

import com.and.movieapp.model.MovieDto;
import com.and.movieapp.model.TrailerDto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    private static String RESULT = "results";
    private static String OVERVIEW = "overview";
    private static String ORIGINAL_LANGUAGE = "original_language";
    private static String ORIGINAL_TITLE = "original_title";
    private static String VIDEO = "video";
    private static String TITLE = "title";
    private static String GENRE_IDS = "genre_ids";
    private static String POSTER_PATH = "poster_path";
    private static String BACKDROP_PATH = "backdrop_path";
    private static String RELEASE_DATE = "release_date";
    private static String VOTE_AVERAGE = "vote_average";
    private static String POPULARITY = "popularity";
    private static String ID = "id";
    private static String ADULT = "adult";
    private static String VOTE_COUNT = "vote_count";
    private static String KEY = "key";
    private static String NAME = "name";
    private static String SITE = "site";
    private static String SIZE = "size";
    private static String TYPE = "type";
    private static String AUTHOR = "author";
    private static String REVIEW = "content";


    public static List<MovieDto> parseApiResponseJson(String json) {

        // Convert JSON string to JSONObject
        JSONObject jsonObject;
        List<MovieDto> lstMovieDto = new ArrayList<>();

        if(null == json){
            json = "{\"page\":1,\"total_results\":371784,\"total_pages\":18590,\"results\":[{\"vote_count\":179,\"id\":353081,\"video\":false,\"vote_average\":7.5,\"title\":\"Mission: Impossible - Fallout\",\"popularity\":383.613,\"poster_path\":\"\\/AkJQpZp9WoNdj7pLYSj1L0RcMMN.jpg\",\"original_language\":\"en\",\"original_title\":\"Mission: Impossible - Fallout\",\"genre_ids\":[12,28,53],\"backdrop_path\":\"\\/5qxePyMYDisLe8rJiBYX8HKEyv2.jpg\",\"adult\":false,\"overview\":\"When an IMF mission ends badly, the world is faced with dire consequences. As Ethan Hunt takes it upon himself to fulfil his original briefing, the CIA begin to question his loyalty and his motives. The IMF team find themselves in a race against time, hunted by assassins while trying to prevent a global catastrophe.\",\"release_date\":\"2018-07-25\"},{\"vote_count\":2207,\"id\":351286,\"video\":false,\"vote_average\":6.6,\"title\":\"Jurassic World: Fallen Kingdom\",\"popularity\":245.686,\"poster_path\":\"\\/c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg\",\"original_language\":\"en\",\"original_title\":\"Jurassic World: Fallen Kingdom\",\"genre_ids\":[28,12,878],\"backdrop_path\":\"\\/3s9O5af2xWKWR5JzP2iJZpZeQQg.jpg\",\"adult\":false,\"overview\":\"Several years after the demise of Jurassic World, a volcanic eruption threatens the remaining dinosaurs on the island of Isla Nublar. Claire Dearing, the former park manager and founder of the Dinosaur Protection Group, recruits Owen Grady to help prevent the extinction of the dinosaurs once again.\",\"release_date\":\"2018-06-06\"},{\"vote_count\":5924,\"id\":299536,\"video\":false,\"vote_average\":8.4,\"title\":\"Avengers: Infinity War\",\"popularity\":184.991,\"poster_path\":\"\\/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg\",\"original_language\":\"en\",\"original_title\":\"Avengers: Infinity War\",\"genre_ids\":[12,878,14,28],\"backdrop_path\":\"\\/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg\",\"adult\":false,\"overview\":\"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.\",\"release_date\":\"2018-04-25\"},{\"vote_count\":4190,\"id\":177677,\"video\":false,\"vote_average\":7.1,\"title\":\"Mission: Impossible - Rogue Nation\",\"popularity\":180.712,\"poster_path\":\"\\/z2sJd1OvAGZLxgjBdSnQoLCfn3M.jpg\",\"original_language\":\"en\",\"original_title\":\"Mission: Impossible - Rogue Nation\",\"genre_ids\":[28,12,53],\"backdrop_path\":\"\\/8XeLfNQrDmFQmPTqxapfWUnKiLf.jpg\",\"adult\":false,\"overview\":\"Ethan and team take on their most impossible mission yet, eradicating the Syndicate - an International rogue organization as highly skilled as they are, committed to destroying the IMF.\",\"release_date\":\"2015-07-23\"},{\"vote_count\":3638,\"id\":954,\"video\":false,\"vote_average\":6.8,\"title\":\"Mission: Impossible\",\"popularity\":179.62,\"poster_path\":\"\\/vmj2PzTLC6xJvshpq8SlaYE3gbd.jpg\",\"original_language\":\"en\",\"original_title\":\"Mission: Impossible\",\"genre_ids\":[12,28,53],\"backdrop_path\":\"\\/tjQHn6xW5BiB1RJ3OZIPDzIOSkF.jpg\",\"adult\":false,\"overview\":\"When Ethan Hunt, the leader of a crack espionage team whose perilous operation has gone awry with no explanation, discovers that a mole has penetrated the CIA, he's surprised to learn that he's the No. 1 suspect. To clear his name, Hunt now must ferret out the real double agent and, in the process, even the score.\",\"release_date\":\"1996-05-22\"},{\"vote_count\":4975,\"id\":56292,\"video\":false,\"vote_average\":6.9,\"title\":\"Mission: Impossible - Ghost Protocol\",\"popularity\":132.465,\"poster_path\":\"\\/s58mMsgIVOFfoXPtwPWJ3hDYpXf.jpg\",\"original_language\":\"en\",\"original_title\":\"Mission: Impossible - Ghost Protocol\",\"genre_ids\":[28,53,12],\"backdrop_path\":\"\\/pc7a2qrIkIxzqWGqcexd3mHzIxy.jpg\",\"adult\":false,\"overview\":\"Ethan Hunt and his team are racing against time to track down a dangerous terrorist named Hendricks, who has gained access to Russian nuclear launch codes and is planning a strike on the United States. An attempt to stop him ends in an explosion causing severe destruction to the Kremlin and the IMF to be implicated in the bombing, forcing the President to disavow them. No longer being aided by the government, Ethan and his team chase Hendricks around the globe, although they might still be too late to stop a disaster.\",\"release_date\":\"2011-12-07\"},{\"vote_count\":871,\"id\":363088,\"video\":false,\"vote_average\":7,\"title\":\"Ant-Man and the Wasp\",\"popularity\":121.528,\"poster_path\":\"\\/rv1AWImgx386ULjcf62VYaW8zSt.jpg\",\"original_language\":\"en\",\"original_title\":\"Ant-Man and the Wasp\",\"genre_ids\":[28,12,14,35,878],\"backdrop_path\":\"\\/6P3c80EOm7BodndGBUAJHHsHKrp.jpg\",\"adult\":false,\"overview\":\"As Scott Lang awaits expiration of his term of house detention, Hope van Dyne and Dr. Hank Pym involve him in a scheme to rescue Mrs. van Dyne from the micro-universe into which she has fallen, while two groups of schemers converge on them with intentions of stealing Dr. Pym's inventions.\",\"release_date\":\"2018-07-04\"},{\"vote_count\":7489,\"id\":284053,\"video\":false,\"vote_average\":7.5,\"title\":\"Thor: Ragnarok\",\"popularity\":113.762,\"poster_path\":\"\\/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg\",\"original_language\":\"en\",\"original_title\":\"Thor: Ragnarok\",\"genre_ids\":[28,12],\"backdrop_path\":\"\\/kaIfm5ryEOwYg8mLbq8HkPuM1Fo.jpg\",\"adult\":false,\"overview\":\"Thor is on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the prophecy of destruction to his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela.\",\"release_date\":\"2017-10-25\"},{\"vote_count\":3187,\"id\":383498,\"video\":false,\"vote_average\":7.6,\"title\":\"Deadpool 2\",\"popularity\":106.413,\"poster_path\":\"\\/to0spRl1CMDvyUbOnbb4fTk3VAd.jpg\",\"original_language\":\"en\",\"original_title\":\"Deadpool 2\",\"genre_ids\":[28,35,878],\"backdrop_path\":\"\\/3P52oz9HPQWxcwHOwxtyrVV1LKi.jpg\",\"adult\":false,\"overview\":\"Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy's life.\",\"release_date\":\"2018-05-15\"},{\"vote_count\":3180,\"id\":333339,\"video\":false,\"vote_average\":7.7,\"title\":\"Ready Player One\",\"popularity\":99.656,\"poster_path\":\"\\/pU1ULUq8D3iRxl1fdX2lZIzdHuI.jpg\",\"original_language\":\"en\",\"original_title\":\"Ready Player One\",\"genre_ids\":[12,878,14],\"backdrop_path\":\"\\/q7fXcrDPJcf6t3rzutaNwTzuKP1.jpg\",\"adult\":false,\"overview\":\"When the creator of a popular video game system dies, a virtual contest is created to compete for his fortune.\",\"release_date\":\"2018-03-28\"},{\"vote_count\":2688,\"id\":955,\"video\":false,\"vote_average\":6,\"title\":\"Mission: Impossible II\",\"popularity\":96.335,\"poster_path\":\"\\/eRaEC0vf5q5TSvaoJPwGTt2wa9T.jpg\",\"original_language\":\"en\",\"original_title\":\"Mission: Impossible II\",\"genre_ids\":[12,28,53],\"backdrop_path\":\"\\/bDdVZNvxb670EMlZqeIy6RdyJ4V.jpg\",\"adult\":false,\"overview\":\"With computer genius Luther Stickell at his side and a beautiful thief on his mind, agent Ethan Hunt races across Australia and Spain to stop a former IMF agent from unleashing a genetically engineered biological weapon called Chimera. This mission, should Hunt choose to accept it, plunges him into the center of an international crisis of terrifying magnitude.\",\"release_date\":\"2000-05-24\"},{\"vote_count\":2750,\"id\":956,\"video\":false,\"vote_average\":6.5,\"title\":\"Mission: Impossible III\",\"popularity\":95.019,\"poster_path\":\"\\/qjy8ABAbWooV4jLG6UjzDHlv4RB.jpg\",\"original_language\":\"en\",\"original_title\":\"Mission: Impossible III\",\"genre_ids\":[12,28,53],\"backdrop_path\":\"\\/kOELgNnVt6EGCjtDXx85YUw6p8X.jpg\",\"adult\":false,\"overview\":\"Retired from active duty to train new IMF agents, Ethan Hunt is called back into action to confront sadistic arms dealer, Owen Davian. Hunt must try to protect his girlfriend while working with his new team to complete the mission.\",\"release_date\":\"2006-05-03\"},{\"vote_count\":3574,\"id\":158015,\"video\":false,\"vote_average\":6.1,\"title\":\"The Purge\",\"popularity\":89.639,\"poster_path\":\"\\/tGGJOuLHX7UDlTz57sjfhW1qreP.jpg\",\"original_language\":\"en\",\"original_title\":\"The Purge\",\"genre_ids\":[878,27,53],\"backdrop_path\":\"\\/1sZ9Nnic1ldHhHttAMDmNxaNM04.jpg\",\"adult\":false,\"overview\":\"Given the country's overcrowded prisons, the U.S. government begins to allow 12-hour periods of time in which all illegal activity is legal. During one of these free-for-alls, a family must protect themselves from a home invasion.\",\"release_date\":\"2013-05-31\"},{\"vote_count\":5381,\"id\":262500,\"video\":false,\"vote_average\":6.3,\"title\":\"Insurgent\",\"popularity\":85.241,\"poster_path\":\"\\/6w1VjTPTjTaA5oNvsAg0y4H6bou.jpg\",\"original_language\":\"en\",\"original_title\":\"Insurgent\",\"genre_ids\":[28,12,878,53],\"backdrop_path\":\"\\/xOKGkKwfK79xjmBd1EiIbPpc71k.jpg\",\"adult\":false,\"overview\":\"Beatrice Prior must confront her inner demons and continue her fight against a powerful alliance which threatens to tear her society apart.\",\"release_date\":\"2015-03-18\"},{\"vote_count\":2873,\"id\":238636,\"video\":false,\"vote_average\":6.6,\"title\":\"The Purge: Anarchy\",\"popularity\":84.999,\"poster_path\":\"\\/l1DRl40x2OWUoPP42v8fjKdS1Z3.jpg\",\"original_language\":\"en\",\"original_title\":\"The Purge: Anarchy\",\"genre_ids\":[27,53],\"backdrop_path\":\"\\/zWGAnbxjjwY3xFGuOeR26LGbBlG.jpg\",\"adult\":false,\"overview\":\"One night per year, the government sanctions a 12-hour period in which citizens can commit any crime they wish -- including murder -- without fear of punishment or imprisonment. Leo, a sergeant who lost his son, plans a vigilante mission of revenge during the mayhem. However, instead of a death-dealing avenger, he becomes the unexpected protector of four innocent strangers who desperately need his help if they are to survive the night.\",\"release_date\":\"2014-07-17\"},{\"vote_count\":367,\"id\":442249,\"video\":false,\"vote_average\":6.1,\"title\":\"The First Purge\",\"popularity\":80.775,\"poster_path\":\"\\/2slvblTroiT1lY9bYLK7Amigo1k.jpg\",\"original_language\":\"en\",\"original_title\":\"The First Purge\",\"genre_ids\":[28,27,878,53],\"backdrop_path\":\"\\/dnaitaoCh8MftfYEVnprcuYExZp.jpg\",\"adult\":false,\"overview\":\"To push the crime rate below one percent for the rest of the year, the New Founding Fathers of America test a sociological theory that vents aggression for one night in one isolated community. But when the violence of oppressors meets the rage of the others, the contagion will explode from the trial-city borders and spread across the nation.\",\"release_date\":\"2018-07-04\"},{\"vote_count\":2398,\"id\":447332,\"video\":false,\"vote_average\":7.2,\"title\":\"A Quiet Place\",\"popularity\":80.34,\"poster_path\":\"\\/nAU74GmpUk7t5iklEp3bufwDq4n.jpg\",\"original_language\":\"en\",\"original_title\":\"A Quiet Place\",\"genre_ids\":[18,27,53,878],\"backdrop_path\":\"\\/tZmr0ozxSc2GasRuddtlRkf7f68.jpg\",\"adult\":false,\"overview\":\"A family is forced to live in silence while hiding from creatures that hunt by sound.\",\"release_date\":\"2018-04-03\"},{\"vote_count\":1412,\"id\":260513,\"video\":false,\"vote_average\":7.7,\"title\":\"Incredibles 2\",\"popularity\":78.88,\"poster_path\":\"\\/x1txcDXkcM65gl7w20PwYSxAYah.jpg\",\"original_language\":\"en\",\"original_title\":\"Incredibles 2\",\"genre_ids\":[28,12,16,10751],\"backdrop_path\":\"\\/mabuNsGJgRuCTuGqjFkWe1xdu19.jpg\",\"adult\":false,\"overview\":\"Elastigirl springs into action to save the day, while Mr. Incredible faces his greatest challenge yet – taking care of the problems of his three children.\",\"release_date\":\"2018-06-14\"},{\"vote_count\":26,\"id\":492719,\"video\":false,\"vote_average\":6.5,\"title\":\"Godzilla: City on the Edge of Battle\",\"popularity\":73.195,\"poster_path\":\"\\/hF85hujJ4jelKtlSZ8YdthvjdZt.jpg\",\"original_language\":\"ja\",\"original_title\":\"GODZILLA 決戦機動増殖都市\",\"genre_ids\":[28,878,12,16],\"backdrop_path\":\"\\/mu4q1jPLdW5hE7BWZEWRvuAh3ZN.jpg\",\"adult\":false,\"overview\":\"Humanity's desperate battle to reclaim the Earth from Godzilla continues. The key to defeating the King of the Monsters may be Mechagodzilla, a robotic weapon thought to have been lost nearly 20,000 years ago.\",\"release_date\":\"2018-05-18\"},{\"vote_count\":7018,\"id\":284054,\"video\":false,\"vote_average\":7.3,\"title\":\"Black Panther\",\"popularity\":71.887,\"poster_path\":\"\\/uxzzxijgPIY7slzFvMotPv8wjKA.jpg\",\"original_language\":\"en\",\"original_title\":\"Black Panther\",\"genre_ids\":[28,12,14,878],\"backdrop_path\":\"\\/b6ZJZHUdMEFECvGiDpJjlfUWela.jpg\",\"adult\":false,\"overview\":\"King T'Challa returns home from America to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new leader. However, T'Challa soon finds that he is challenged for the throne by factions within his own country as well as without. Using powers reserved to Wakandan kings, T'Challa assumes the Black Panther mantel to join with girlfriend Nakia, the queen-mother, his princess-kid sister, members of the Dora Milaje (the Wakandan 'special forces') and an American secret agent, to prevent Wakanda from being dragged into a world war.\",\"release_date\":\"2018-02-13\"}]}";
        }

        try {
            jsonObject = new JSONObject(json);
            if( jsonObject != null && jsonObject.length() > 0) {

                if (jsonObject.has(RESULT)) {

                    JSONArray jsonArray = (JSONArray) jsonObject.get(RESULT);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        lstMovieDto.add( parseMovieJson(jsonArray.getJSONObject(i)));
                    }
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return lstMovieDto;
    }

    private static MovieDto parseMovieJson(JSONObject objJSONObject){
        MovieDto objMovieDto =  new MovieDto();
        try {
            objMovieDto.setOverview(objJSONObject.getString(OVERVIEW));
            objMovieDto.setOriginal_language(objJSONObject.getString(ORIGINAL_LANGUAGE));
            objMovieDto.setOriginal_title(objJSONObject.getString(ORIGINAL_TITLE));
            objMovieDto.setVideo(objJSONObject.getBoolean(VIDEO));
            objMovieDto.setTitle(objJSONObject.getString(TITLE));

            JSONArray objJSONArray = objJSONObject.getJSONArray(GENRE_IDS);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < objJSONArray.length(); j++) {
                list.add(objJSONArray.getInt(j));
                objMovieDto.setGenre_ids(list);
            }

            objMovieDto.setPoster_path(objJSONObject.getString(POSTER_PATH));
            objMovieDto.setBackdrop_path(objJSONObject.getString(BACKDROP_PATH));
            objMovieDto.setRelease_date(objJSONObject.getString(RELEASE_DATE));
            objMovieDto.setVote_average(objJSONObject.getLong(VOTE_AVERAGE));
            objMovieDto.setPopularity(objJSONObject.getLong(POPULARITY));
            objMovieDto.setId(objJSONObject.getInt(ID));
            objMovieDto.setAdult(objJSONObject.getBoolean(ADULT));
            objMovieDto.setVote_count(objJSONObject.getInt(VOTE_COUNT));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.print(""+objMovieDto.getTitle());
        return objMovieDto;
    }

    public static List<TrailerDto> parseApiResTrailerJson(String json) {

        JSONObject jsonObject;
        List<TrailerDto> lstTrailerDto = new ArrayList<>();
        String strMovieID;
        try {
            jsonObject = new JSONObject(json);
            if( jsonObject != null && jsonObject.length() > 0) {

                strMovieID = jsonObject.getString(ID);

                if (jsonObject.has(RESULT)) {

                    JSONArray jsonArray = (JSONArray) jsonObject.get(RESULT);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        TrailerDto objTrailerDto = new TrailerDto();
                        objTrailerDto.setMovieId(strMovieID);
                        objTrailerDto.setTrailerId( jsonArray.getJSONObject(i).getString(ID));
                        objTrailerDto.setKey( jsonArray.getJSONObject(i).getString(KEY));
                        objTrailerDto.setName( jsonArray.getJSONObject(i).getString(NAME));
                        objTrailerDto.setSite( jsonArray.getJSONObject(i).getString(SITE));
                        objTrailerDto.setSize( jsonArray.getJSONObject(i).getString(SIZE));
                        objTrailerDto.setTeaser( jsonArray.getJSONObject(i).getString(TYPE));
                        lstTrailerDto.add(objTrailerDto);
                    }
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return lstTrailerDto;

    }



    public static Map<String, String> parseApiRestReviewJson(String json) {

        JSONObject jsonObject;
        Map<String, String> mapReview = new HashMap<>();

        try {
            jsonObject = new JSONObject(json);
            if( jsonObject != null && jsonObject.length() > 0) {

                if (jsonObject.has(RESULT)) {

                    JSONArray jsonArray = (JSONArray) jsonObject.get(RESULT);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        mapReview.put(jsonArray.getJSONObject(i).getString(AUTHOR), jsonArray.getJSONObject(i).getString(REVIEW));
                    }
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mapReview;

    }

}
