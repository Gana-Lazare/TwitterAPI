package tweet;

import common.RestApi;
import io.restassured.response.ValidatableResponse;

import java.util.List;

import static io.restassured.RestAssured.*;

public class TweetClient extends RestApi {


    //Create a new tweet
    private final String CREAT_TWEET_ENDPOINT="/statuses/update.json";
   // private final String UPDATE_TWEET_ENDPOINT="";

    //to delete a tweet already exist
    private final String DELETE_TWEET_ENDPOINT="/statuses/destroy.json";

    // get the time that the user post his tweet
    private final String GET_USER_TWEET_ENDPOINT = "/statuses/user_timeline.json";
    //show a tweet information using the id
    private final String GET_TWEET_INFO_ENDPOINT="/statuses/show.json";
//return a single tweet
    private final String GET_TWEET_ENDPOINT="/oembed";
//search for a tweet giving id
    private final String LOOKUP_TWEETs_ENDPOINT="/statuses/lookup.json";
    //Retweets a tweet. Returns the original Tweet with Retweet details embedded
    private final String POST_RETWEET_ENDPOINT="/retweet/:id.json";
    //get list of followers
    private final String GET_LIST_OF_FOLLOWERS_ENDPOINT="/followers/list.json";
    //get follower IDS
    private final String GET_FOLLOWER_IDS_ENDPOINT="/followers/ids.json";
//get freinds
    private final String GET_FREINDS_ENDPOINT="/friends/ids.json";
    //method to creat a NEW TWEET
    public ValidatableResponse createNewTweet(String tweet){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when().post(this.baseUrl+this.CREAT_TWEET_ENDPOINT)
                .then();
    }

    //DELETE A TWEET ALREADY EXISTING
    public ValidatableResponse deleteTweet(long id){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .param("id",id)
                .when().post(this.baseUrl+this.DELETE_TWEET_ENDPOINT)
                .then();
    }
//GEt Tweet info
    public  ValidatableResponse getTweetInfo(long id){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .param("id",id)
                .when().get(this.baseUrl+this.GET_TWEET_INFO_ENDPOINT)
                .then();
    }
    public ValidatableResponse getTweet(long id){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .param("id",id)
                .when().post(this.baseUrl+this.GET_TWEET_ENDPOINT)
                .then();

    }
    public ValidatableResponse postRetweet(long id){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .param("id",id)
                .when().post(this.baseUrl+this.POST_RETWEET_ENDPOINT)
                .then();
    }
    public ValidatableResponse getfollowerIds(long id){
        return  given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .param("id",id)
                .when().get(this.baseUrl+this.GET_FOLLOWER_IDS_ENDPOINT)
                .then();
    }
public ValidatableResponse getFreinds(long id){
    return  given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
            .param("id",id)
            .when().get(this.baseUrl+this.GET_FREINDS_ENDPOINT)
            .then();
}



}
