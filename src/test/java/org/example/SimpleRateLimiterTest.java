package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleRateLimiterTest {
    private final int MAX_RATE_LIMIT = 5;
    @Test
    void allowRequestTest() {

        SimpleRateLimiter simpleRateLimiter = new SimpleRateLimiter(MAX_RATE_LIMIT);
        String key = "testUser";
        for (int i = 0; i < MAX_RATE_LIMIT - 1; i++) {
            simpleRateLimiter.allowRequest(key);
        }
        assertTrue(simpleRateLimiter.allowRequest(key));
    }

    @Test
    void requestBlockedTest() {
        SimpleRateLimiter simpleRateLimiter = new SimpleRateLimiter(MAX_RATE_LIMIT);
        String key = "testUser";
        for (int i = 0; i < MAX_RATE_LIMIT + 1; i++) {
            simpleRateLimiter.allowRequest(key);
        }
        assertFalse(simpleRateLimiter.allowRequest(key));
    }
}