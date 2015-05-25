package com.hoon.appting.service;

import org.springframework.stereotype.Service;

/**
 * Created by hoon on 2015-04-23.
 */
@Service
public class TrackingServiceExchange implements TrackingService {
    private long executeCount;

    @Override
    public void trace() {
        System.out.println("교환 트래이스" + this.hashCode());
        executeCount++;
    }

    @Override
    public void countLog() {
        System.out.println(executeCount + " 건이 수행되었습니다. 교환");
        executeCount = 0;
    }
}
