package com.hoon.appting.controller;

import com.hoon.appting.service.TrackingService;
import com.hoon.appting.service.TrackingServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoon on 2015-04-23.
 */
@Controller
public class FactoryController {

    @Autowired
    TrackingServiceFactory trackingServiceFactory;

    TrackingService trackingService = null;

    @RequestMapping(value = "/executeTracking")
    public String executeTracking() {

        for (String type : getTypes()) {
            trackingService = trackingServiceFactory.getTrackingService(type);
            trackingService.trace();
        }

        String[] types = {"D", "R", "E"};
        for (String type : types) {
            trackingService = trackingServiceFactory.getTrackingService(type);
            trackingService.countLog();
        }

        return "executeTracking";
    }

    List<String> getTypes() {
        List<String> types = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            if (i % 3 == 0) {
                types.add("D");
            } else if (i % 3 == 1) {
                types.add("R");
            } else {
                types.add("E");
            }
        }

        return types;
    }
}
