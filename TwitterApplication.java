package com.upgrad.c1.sessionfive;

public class TwitterApplication {

    // Attributes
    private User[] allUsers;
    private Tweet[] allTweets;

    private int maxTweetId;
    private int maxUserId;

    public TwitterApplication() {
        this.allTweets = new Tweet[1000];
        this.allUsers = new User[500];

        this.maxTweetId = -1;
        this.maxUserId = -1;
    }

    public void create_new_user(String userName) {
        if (maxUserId == 499) {
            System.out.println("Sorry, we can't accept more users now...");
        } else if (userName.equals("")) {
            System.out.println("User name cannot be empty...");
        } else if (getUserObjectIfValid(userName) != null) {
            System.out.println("This user already exists...");
        } else {
            maxUserId++;
            User user = new User(maxUserId, userName);
            allUsers[maxUserId] = user;
            System.out.println("User created successfully!");
        }
    }

    public void accept_follow_request(String mainUser, String follower) {
        User main = getUserObjectIfValid(mainUser);
        User follow = getUserObjectIfValid(follower);

        if (main == null || follow == null) {
            System.out.println("Invalid user names entered!");
        } else {
            main.accept_request(follow);
            follow.start_following_user(main);
        }
    }



    public User getUserObjectIfValid(String userName) {
        for(int i = 0; i <= 499; i++) {
            if (allUsers[i] == null) {
                break;
            }
            if (allUsers[i].getUserName().equals(userName)) {
                return allUsers[i];
            }
        }

        return null;
    }

    public Tweet getTweetObjectIfValid(int tweetId) {
        for(int i = 0; i <= 999; i++) {
            if (allTweets[i] == null) {
                break;
            }

            if (allTweets[i].getTweetId() == tweetId) {
                return allTweets[i];
            }
        }

        return null;
    }


    public void post_tweet(String name, String message) {
        if (maxTweetId == 999) {
            System.out.println("Sorry, we can't accept more tweets now...");
        } else if (message.equals("")) {
            System.out.println("Tweet cannot be empty...");
        } else {
            User user = getUserObjectIfValid(name);
            if (user == null) {
                System.out.println("The user does not exist...");
            } else {
                maxTweetId++;
                Tweet tweet = new Tweet(maxTweetId, message, user);
                boolean isTweetAdded = user.add_tweet(tweet);
                if (isTweetAdded) {
                    allTweets[maxTweetId] = tweet;
                    System.out.println("Tweet posted successfully!");
                } else {
                    System.out.println("Sorry, we can't accept more tweets now...");
                    maxTweetId--;
                }
            }
        }
    }

    public void show_home_page(String name) {
        User user = getUserObjectIfValid(name);
        if (user == null) {
            System.out.println("The user does not exist...");
        } else {
            boolean isEmptyHomePage = true;
            Tweet[] userTweets = user.getMyTweets();
            for(int i = 0; i <= 499; i++) {
                if (userTweets[i] == null) {
                    break;
                }

                if (!userTweets[i].isDeleted()) {
                    isEmptyHomePage = false;
                    System.out.println("Tweet ID: " + userTweets[i].getTweetId()
                            + ", Tweet: " + userTweets[i].getMessage());
                    System.out.println();
                }

            }

            if (isEmptyHomePage) {
                System.out.println("Your home page seems to be empty...");
            }
        }
    }

    public void submit_follow_request(String name, String main) {
        User follower = getUserObjectIfValid(name);
        User userToBeFollowed = getUserObjectIfValid(main);

        if (follower == null || userToBeFollowed == null) {
            System.out.println("User name(s) are invalid...");
        } else {
            userToBeFollowed.list_follow_request(follower);
        }

    }

    public void delete_tweet(int tweetId, String userName) {
        User user = getUserObjectIfValid(userName);
        Tweet t = getTweetObjectIfValid(tweetId);

        if (user == null) {
            System.out.println("The user is not valid...");
        } else if (t == null) {
            System.out.println("Tweet id is not valid...");
        } else if (t.getOwner().getUserId() != user.getUserId()) {
            System.out.println("You do not own this tweet...");
        } else if (t.isDeleted()) {
            System.out.println("The tweet is already deleted...");
        } else {
            // Actually delete...
            t.deleteTweet();
            System.out.println("Tweet deleted successfully!");
        }
    }
}
