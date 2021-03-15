package com.wsoh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wsoh.blog.model.User;

// DAO
// bean에 자동으로 등록
// @Repository // 생략가능하다
public interface UserRepository extends JpaRepository<User,Integer>{

}
