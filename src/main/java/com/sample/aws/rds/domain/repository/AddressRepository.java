package com.sample.aws.rds.domain.repository;

import com.sample.aws.rds.domain.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}