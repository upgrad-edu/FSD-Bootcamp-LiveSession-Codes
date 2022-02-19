package com.upgrad.c1.sessionfive;

public class User {

   // Attributes
   private int userId;
   private String userName;

   private User[] following;
   private User[] followers;

   private Tweet[] myTweets;

   private Tweet[] hiddenTweets;

   private User[] followRequests;

   public User(int uId, String uName) {
       this.userId = uId;
       this.userName = uName;

       this.followers = new User[100];
       this.following = new User[100];
       this.followRequests = new User[100];

       this.myTweets = new Tweet[500];
       this.hiddenTweets = new Tweet[500];
   }

   public String getUserName() {
       return this.userName;
   }

   public int getUserId() {
       return this.userId;
   }

   public Tweet[] getMyTweets() {
       return this.myTweets;
   }

   public void accept_request(User follower) {
        boolean isValidRequest = false;

        for(int i = 0; i <= 99; i++) {
            if (followRequests[i] == null) {
                break;
            }

            if (followRequests[i].getUserId() == follower.getUserId()) {
                isValidRequest = true;
                followRequests[i] = null;
                break;
            }
        }

        if (!isValidRequest) {
            System.out.println("This is not a valid follow request...");
        } else {
            for(int i = 0; i <= 99; i++) {
                if (this.followers[i] == null) {
                    this.followers[i] = follower;
                    break;
                }
            }

        }
   }

   public void start_following_user(User main) {
        for(int i = 0; i <= 99; i++) {
            if (this.following[i] == null) {
                this.following[i] = main;
                break;
            }
       }
   }

    public boolean add_tweet(Tweet tweet) {
       boolean isTweetAdded = false;
       for(int i = 0; i <= 499; i++) {
            if (this.myTweets[i] == null) {
                isTweetAdded = true;
                this.myTweets[i] = tweet;
                break;
            }
        }

       return isTweetAdded;
    }

    public void list_follow_request(User follower) {

       boolean isAlreadyFollowing = false;
        for(int i = 0; i <= 99; i++) {
            if (this.following[i] == null) {
                break;
            }

            if (this.following[i].getUserId() == follower.getUserId()) {
                isAlreadyFollowing = true;
                break;
            }
        }

        if (isAlreadyFollowing) {
            System.out.println("You are already following this user...");
        } else {

            boolean successfullyAdded = false;
            for(int i = 0; i <= 99; i++) {
                if (this.followRequests[i] == null) {
                    this.followRequests[i] = follower;
                    successfullyAdded = true;
                }
            }

            if (successfullyAdded) {
                System.out.println("Follow request submitted!");
            } else {
                System.out.println("Could not submit request at this moment...");
            }
        }

    }



}
