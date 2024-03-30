package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RedisRateLimiterTest {
    private final int MAX_RATE_LIMIT = 4;

    @Test
    void allowRedisRequestTest() {
        RedisRateLimiter rateLimiter = new RedisRateLimiter();
        for (int i = 0; i < MAX_RATE_LIMIT; i++)
        {
            rateLimiter.acquire();
        }

        assertTrue(rateLimiter.acquire());
    }

    @Test
    void redisRequestBlockedTest() {
        RedisRateLimiter rateLimiter = new RedisRateLimiter();
        for (int i = 0; i < MAX_RATE_LIMIT + 1; i++)
        {
            rateLimiter.acquire();
        }

        assertFalse(rateLimiter.acquire());
    }
}
