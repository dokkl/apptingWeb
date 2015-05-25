package com.hoon.appting.service;

import com.hoon.appting.dto.Shipment;
import com.hoon.appting.repository.UserRepository;
import com.hoon.appting.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoon on 2014-09-11.
 */
@Service
public class HoonService {
    @Autowired
    private UserRepository userRepository;

    List<Shipment> findShipmentById(Long id) {
        Long userManagerId = 1L;
        int startOffset = 1;
        int numberOfCommentsForPage = 1;
        Pageable pageSpecification = new PageRequest(startOffset, numberOfCommentsForPage, new Sort(Sort.Direction.DESC, "regDttm"));
        Page<User> requestedPage = userRepository.findByUserManagerId(userManagerId, pageSpecification);
        int count = 1;
        subService(count);
        return new ArrayList<Shipment>();
    }

    void subService(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("i :  " + i);
        }
    }

}
