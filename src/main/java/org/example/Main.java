package org.example;

public class Main {
    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(5);
        for (int i = 0; i < 10; i++) {
            String key = "user1";
            if(rateLimiter.allowRequest(key)) {
                System.out.println("Request allowed");
            } else {
                System.out.println("Requested blocked");
            }
        }

    }
}