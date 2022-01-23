package com.socialfeed.back.social.twitter.service;

import io.github.redouane59.twitter.TwitterClient;
import io.github.redouane59.twitter.dto.user.User;
import io.github.redouane59.twitter.signature.TwitterCredentials;

public class TwitterService {

    public static void main(String[] args) {
        TwitterClient twitterClient = new TwitterClient(TwitterCredentials.builder()
                .accessToken("<access_token>")
                .accessTokenSecret("<secret_token>")
                .apiKey("<api_key>")
                .apiSecretKey("<secret_key>")
                .build());


        User user   = twitterClient.getUserFromUserName("RedouaneBali");
        System.out.println(user.getName());
        System.out.println(user.getDisplayedName());
        System.out.println(user.getDateOfCreation());
        System.out.println(user.getDescription());
        System.out.println(user.getTweetCount());
        System.out.println(user.getFollowersCount());
        System.out.println(user.getFollowingCount());
        System.out.println(user.getPinnedTweet());
        System.out.println(user.getPinnedTweet());
        System.out.println(user.getLocation());
        System.out.println(user.getId());
        System.out.println(user.getUrl());
    }


}
