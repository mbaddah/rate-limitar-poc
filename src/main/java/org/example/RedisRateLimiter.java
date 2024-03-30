package org.example;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class RedisRateLimiter {
    private final RedissonClient redissonClient;
    private final RRateLimiter rateLimiter;

    public RedisRateLimiter() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        this.redissonClient = Redisson.create(config);
        rateLimiter = redissonClient.getRateLimiter("myRateLimiter");
        // Set rate limit to 5 permits per second
        rateLimiter.trySetRate(RateType.OVERALL, 5, 1, RateIntervalUnit.SECONDS);
    }

    public boolean acquire() {
        // Try to acquire permit
        return rateLimiter.tryAcquire();
    }

    public void shutdown() {
        redissonClient.shutdown();
    }

}
