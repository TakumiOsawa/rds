package com.sample.aws.rds.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;

@Configuration
@EnableRdsInstance(
        dbInstanceIdentifier = "${rds.identifier}",
        password ="${rds.password}",
        readReplicaSupport = false)
public class RdsConfig {
}