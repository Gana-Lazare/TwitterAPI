package tweettest;

import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;
import org.junit.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tweet.TweetClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class TweetClientTest {
    private TweetClient tweetClient;

    @BeforeClass
    public void setupTweetClient() {
        this.tweetClient = new TweetClient();
    }

    @Test
    public void testTweetSuccesful() {
        //dont need to generate random
        String tweet = "Hello Evryone I automate my twitter account";

        ValidatableResponse response = this.tweetClient.createNewTweet(tweet);
        response.statusCode(200);
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(tweet, actualTweet);

    }

    @Test
    public void testUserCanNotTweetTheSameTweetTwiceInARow() {
        // 1. user send a tweet
        // String tweet="We are learning RestAPI Automation and Tweet check"+ UUID.randomUUID().toString();
        String tweet = "We are learning RestAPI Automation and Tweet check";
        ValidatableResponse response = this.tweetClient.createNewTweet(tweet);
        // 2. Verify that the tweet was successful
        response.statusCode(200);

        System.out.println(response.extract().body().asString());
        String actualTweet = response.extract().body().path("text");
        org.junit.Assert.assertEquals(tweet, actualTweet);
        // User send the same tweet again
        response = this.tweetClient.createNewTweet(tweet);
        // Verify that the tweet was unsuccessful
        response.statusCode(403);
        //System.out.println(response.extract().body().asString());
        String expectedMessage = "Status is a duplicate.";
        String actualMessage = response.extract().body().path("errors[0].message");
        org.junit.Assert.assertEquals(actualMessage, expectedMessage);
        org.junit.Assert.assertNotSame("200", 403);
    }

    @Test()
    public void testTweetDeleted() {
        String tweet = "Hello Evryone I automate my twitter account";
        ValidatableResponse response = this.tweetClient.deleteTweet(1309710741684072454L);
        // Verify that the tweet was successfully deleted
        response.statusCode(200);
        String actualTweet = response.extract().body().path("text");
        org.junit.Assert.assertEquals(tweet, actualTweet);
    }

    @Test
    public void testInfoTweet() {
        String tweet = "Hello Evryone I automate my twitter account";
        ValidatableResponse response = this.tweetClient.getTweetInfo(1309713909776109568L);
        response.statusCode(200);
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(tweet, actualTweet);
        System.out.println(actualTweet);

    }

    @Test
    public void testgetTweet() {
        ValidatableResponse response = this.tweetClient.getTweet(1309713909776109568L);
    }

    @Test
    public void testRetweet() {
        ValidatableResponse response = this.tweetClient.postRetweet(1309713909776109568L);
    }

    @Test
    public void testgetfollowersId() {
        ValidatableResponse response = this.tweetClient.getfollowerIds(2806295158L);
        ResponseBodyExtractionOptions body=response.extract().body().path("text");
                String actualTweet=response.extract().body().path("text");
        System.out.println(body);
    }
    @Test
    public void testGetFREINDS(){
        ValidatableResponse response = this.tweetClient.getFreinds(2806295158L);
        ResponseBodyExtractionOptions body=response.extract().body();
        String actualTweet=response.extract().body().path("text");
        System.out.println(actualTweet);
        //can't figure it out how to get list of followers
    }


    @Test
    public void setMutipletweetsTweets() {
        ArrayList<String> tweets= new ArrayList<String>();
        tweets.add("HELLO EVRYONE");
        tweets.add("SECOND TWEET");
        tweets.add("THIRD TWEET");
        for (Iterator j =tweets.iterator() ; j.hasNext();){
            System.out.println(j.next());
           String tweet= j.toString();
            ValidatableResponse response = this.tweetClient.createNewTweet(tweet); }

        }
    @Test
    public void testTweet2Succesful() {
        //dont need to generate random
        String tweet = "TRYING";

        ValidatableResponse response = this.tweetClient.createNewTweet(tweet);
        response.statusCode(200);
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(tweet, actualTweet);

    }
    @Test
    public void testTweet3Succesful() {
        //dont need to generate random
        String tweet = "9/26/2020";

        ValidatableResponse response = this.tweetClient.createNewTweet(tweet);
        response.statusCode(200);
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(tweet, actualTweet);

    }



}

