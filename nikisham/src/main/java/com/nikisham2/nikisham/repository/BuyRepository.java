package com.nikisham2.nikisham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nikisham2.nikisham.entity.Buy;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BuyRepository extends JpaRepository<Buy, UUID> {
}
