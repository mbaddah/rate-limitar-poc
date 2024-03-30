package org.example;

public class Main {
    public static void main(String[] args) {
        SimpleRateLimiter rateLimiter = new SimpleRateLimiter(5);
        for (int i = 0; i < 10; i++) {
            String key = "user1";
            if(rateLimiter.allowRequest(key)) {
                System.out.println("Request allowed");
            } else {
                System.out.println("Requested blocked");
            }
        }

        RedisRateLimiter redisRateLimiter = new RedisRateLimiter();
        // Simulate some requests
        for (int i = 0; i < 10; i++) {
            if (redisRateLimiter.acquire()) {
                System.out.println("Request " + i + " allowed");
            } else {
                System.out.println("Request " + i + " blocked");
            }
        }
        redisRateLimiter.shutdown();


    }
}