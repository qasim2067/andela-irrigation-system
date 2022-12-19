package com.irrigation.system.dto.response;


import java.io.Serializable;

import lombok.Data;

@Data
public class PlotResponse implements Serializable  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7376070603238784857L;
	
	private Integer plotId;
	private String name;
	private String latitude;
	private String longitude;
	private String totalSize;
	private String cropType;
	private String cultivatedArea;
		
	
}
