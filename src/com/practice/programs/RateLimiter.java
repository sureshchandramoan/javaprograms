package com.practice.programs;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class RateLimiter {
    private final int maxRequests;
    private final long windowSize;
    private final ConcurrentMap<String, RequestInfo> userRequests = new ConcurrentHashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

    public RateLimiter(int maxRequests, long windowSize) {
        this.maxRequests = maxRequests;
        this.windowSize = windowSize;
    }

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        lock.lock();
        try {
            RequestInfo info = userRequests.computeIfAbsent(userId, k -> new RequestInfo(currentTime));
            if (currentTime - info.startTime > windowSize) {
                info.startTime = currentTime;
                info.requestCount.set(0);
            }
            if (info.requestCount.incrementAndGet() <= maxRequests) {
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    private static class RequestInfo {
        long startTime;
        AtomicInteger requestCount;

        RequestInfo(long startTime) {
            this.startTime = startTime;
            this.requestCount = new AtomicInteger(0);
        }
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(5, 1000); // 5 requests per 10 seconds

        for (int i = 0; i < 18; i++) {
            boolean allowed = rateLimiter.allowRequest("user1");
            System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Denied"));
            try {
                Thread.sleep(100); // Simulate time between requests
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(rateLimiter.userRequests.size());
    }
}
