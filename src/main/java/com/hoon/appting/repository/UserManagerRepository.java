package com.hoon.appting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoon.appting.repository.entity.UserManager;

public interface UserManagerRepository extends JpaRepository<UserManager, Long>{

}
