package com.irrigation.system.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sensors")
public class Sensor implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2090768264463173267L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String modelNo;
	
	@Column(name = "is_active", columnDefinition = "BOOLEAN")
	private boolean active;
	
	private String deviceUniqueIdentifier;
	
}
