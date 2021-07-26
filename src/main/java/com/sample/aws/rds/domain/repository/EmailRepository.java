package com.sample.aws.rds.domain.repository;

import com.sample.aws.rds.domain.model.entity.Email;
import com.sample.aws.rds.domain.model.entity.EmailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, EmailPK> {
}