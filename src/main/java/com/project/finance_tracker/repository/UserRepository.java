package com.project.finance_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.finance_tracker.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}