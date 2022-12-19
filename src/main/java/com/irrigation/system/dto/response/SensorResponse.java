package com.irrigation.system.dto.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class SensorResponse implements Serializable  {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4671411052346156903L;
	private Integer sensorId;
	private String modelNo;
	private boolean active;
	private String deviceUniqueIdentifier;
	
}
