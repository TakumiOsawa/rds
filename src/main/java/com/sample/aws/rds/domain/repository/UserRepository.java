package com.sample.aws.rds.domain.repository;

import com.sample.aws.rds.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}