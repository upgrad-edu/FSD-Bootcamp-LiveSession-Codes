package com.upgrad.c1.sessionfive;

public class Tweet {

    private int tweetId;

    private String message;

    private User owner;

    private boolean isDeleted;

    public Tweet(int tweetId) {
        this.tweetId = tweetId;
        this.isDeleted = false;
    }

    public Tweet(int id, String msg, User owner) {
        this(id);
        this.message = msg;
        this.owner = owner;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void deleteTweet() {
        this.isDeleted = true;
    }

    public int getTweetId() {
        return this.tweetId;
    }

    public String getMessage() {
        return this.message;
    }

    public User getOwner() {
        return this.owner;
    }

}
