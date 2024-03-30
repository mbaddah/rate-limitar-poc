package org.example;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter {
    private final int limit;
    private final ConcurrentHashMap<String, AtomicInteger> requestCounts = new ConcurrentHashMap<>();

    public RateLimiter(int limit) {
        this.limit = limit;
    }

    public boolean allowRequest(String key) {
        AtomicInteger count = requestCounts.computeIfAbsent(key, k -> new AtomicInteger(0));
        int currentCount = count.incrementAndGet();
        if (currentCount > limit) {
            return false;
        }
        return true;
    }

}
