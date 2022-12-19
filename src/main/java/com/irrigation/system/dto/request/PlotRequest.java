package com.irrigation.system.dto.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PlotRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8233989549112405624L;

	@NotNull(message = "plot.name is required")
	@Size(min = 1, max = 99)
	private String name;

	@NotNull(message = "plot.latitude is required")
	@Size(min = 1, max = 99)
	private String latitude;

	@NotNull(message = "plot.longitude is required")
	@Size(min = 1, max = 99)
	private String longitude;

	@NotNull(message = "plot.totalSize is required")
	@Size(min = 1, max = 99)
	private String totalSize;

	@NotNull(message = "plot.cropType is required")
	@Size(min = 1, max = 99)
	private String cropType;

	@NotNull(message = "plot.cultivatedArea is required")
	@Size(min = 1, max = 99)
	private String cultivatedArea;

}
