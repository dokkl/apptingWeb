package com.hoon.appting.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by hoon on 2015-04-06.
 */
public interface DeliveryRepository extends JpaRepository<Delivery, Long>, QueryDslPredicateExecutor<Delivery> {
}
