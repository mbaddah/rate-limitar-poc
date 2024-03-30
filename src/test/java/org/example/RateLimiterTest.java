package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateLimiterTest {

    @Test
    void allowRequestTest() {
        RateLimiter rateLimiter = new RateLimiter(5);
        String key = "testUser";
        for (int i = 0; i < 2; i++) {
            rateLimiter.allowRequest(key);
        }
        assertTrue(rateLimiter.allowRequest(key));
    }

    @Test
    void requestBlockedTest() {
        RateLimiter rateLimiter = new RateLimiter(5);
        String key = "testUser";
        for (int i = 0; i < 6; i++) {
            rateLimiter.allowRequest(key);
        }
        assertFalse(rateLimiter.allowRequest(key));
    }
}