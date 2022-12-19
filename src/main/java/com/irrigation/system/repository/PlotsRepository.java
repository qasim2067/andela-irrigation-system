package com.irrigation.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irrigation.system.entity.Plot;

@Repository
public interface PlotsRepository extends JpaRepository<Plot, Integer> {

	
}
