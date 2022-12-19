package com.irrigation.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irrigation.system.entity.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {

	Optional<Sensor> findByDeviceUniqueIdentifier(String deviceUniqueIdentifier);
}
