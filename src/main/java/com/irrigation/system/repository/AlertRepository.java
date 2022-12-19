package com.irrigation.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irrigation.system.entity.Alerts;

@Repository
public interface AlertRepository extends JpaRepository<Alerts, Integer>{

}
