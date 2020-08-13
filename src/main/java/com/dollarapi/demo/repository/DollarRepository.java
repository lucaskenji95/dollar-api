package com.dollarapi.demo.repository;

import com.dollarapi.demo.model.Dollar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface DollarRepository extends JpaRepository<Dollar, String> {

    Optional<Dollar> findByDollarDate(Date date);

}
