package com.upgrad.c1.sessionfive;

import java.util.Scanner;

public class TwitterDriver {

    public static void main(String[] args) {
        TwitterApplication application = new TwitterApplication();
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! Welcome to the application!");

        int option;

        do {
            System.out.println();
            System.out.println("Please choose your option:");
            System.out.println("1. Create User");
            System.out.println("2. Accept Follower");
            System.out.println("3. Post Tweet");
            System.out.println("4. Get Home Page");
            System.out.println("5. Follow a user");
            System.out.println("6. Delete a tweet");
            System.out.println("7. Get Feed for user");
            System.out.println("8. Hide a tweet");
            System.out.println("Press anything else to quit.");
            option = input.nextInt();
            String flush = input.nextLine();
            String name;
            String follower;
            String message;
            String main;
            int tweetId;
            switch (option) {
                case 1:
                    System.out.println("Please enter the user name:");
                    name = input.nextLine();
                    application.create_new_user(name);
                    break;
                case 2:
                    System.out.println("Please enter your user name:");
                    name = input.nextLine();
                    System.out.println("Please enter the user name of who you want to aceept:");
                    follower = input.nextLine();
                    application.accept_follow_request(name, follower);
                    break;
                case 3:
                    System.out.println("Please enter the user name:");
                    name = input.nextLine();
                    System.out.println("Please enter your tweet:");
                    message = input.nextLine();
                    application.post_tweet(name, message);
                    break;
                case 4:
                    System.out.println("Please enter the user name:");
                    name = input.nextLine();
                    application.show_home_page(name);
                    break;
                case 5:
                    System.out.println("Please enter your user name:");
                    name = input.nextLine();
                    System.out.println("Please enter the user name of who you want to follow:");
                    main = input.nextLine();
                    application.submit_follow_request(name, main);
                    break;
                case 6:
                    System.out.println("Please enter the user name:");
                    name = input.nextLine();
                    System.out.println("Please enter the ID of the tweet you want to delete:");
                    tweetId = input.nextInt();
                    flush = input.nextLine();
                    application.delete_tweet(tweetId, name);
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Thank you for using! Have a good day.");
            }
        } while (option >= 1 && option <= 8);


    }
}
