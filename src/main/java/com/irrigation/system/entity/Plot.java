package com.irrigation.system.entity;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="plot")
public class Plot implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6986704768826363677L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String latitude;
	private String longitude;
	private String totalSize;
	private String cropType;
	private String cultivatedArea;
		
	
}
