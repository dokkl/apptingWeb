package com.hoon.appting.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hoon on 2015-04-26.
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMail(String mail);
}
