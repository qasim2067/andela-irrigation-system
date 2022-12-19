package com.irrigation.system.dto.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SensorRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2010075076488263354L;

	@NotNull(message = "model no is required")
	@Size(min = 1, max = 99)
	private String modelNo;

	private boolean active;

	@NotNull(message = "Device Identifier is required")
	@Size(min = 1, max = 99)
	private String deviceUniqueIdentifier;

}
