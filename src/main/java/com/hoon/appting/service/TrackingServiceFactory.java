package com.hoon.appting.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hoon on 2015-04-23.
 */
@Service
public class TrackingServiceFactory {
    @Resource
    TrackingService trackingServiceDelivery;

    @Resource
    TrackingService trackingServiceReturnDelivery;

    @Resource
    TrackingService trackingServiceExchange;

    public TrackingService getTrackingService(String type) {
        if (type.equals("D")) {
            return trackingServiceDelivery;
        } else if (type.equals("R")) {
            return trackingServiceReturnDelivery;
        } else if (type.equals("E")) {
            return trackingServiceExchange;
        }
        return null;
    }
}
