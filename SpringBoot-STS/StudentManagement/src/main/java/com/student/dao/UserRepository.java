package com.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
