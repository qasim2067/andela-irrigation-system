package com.irrigation.system.dto.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.irrigation.system.dto.serializers.CustomDateSerializer;
import com.irrigation.system.dto.serializers.CustomTimeSerializer;
import com.irrigation.system.entity.Plot;

import lombok.Data;

@Data
public class SlotsResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4435853783611849480L;

	private Integer slotId;

	private Plot plot;

	@JsonSerialize(using = CustomTimeSerializer.class)
	private LocalTime startTime;

	@JsonSerialize(using = CustomTimeSerializer.class)
	private LocalTime endTime;

	@JsonSerialize(using = CustomDateSerializer.class)
	private LocalDate date;

	private boolean recurring;
	private boolean active;
	private String sensorDeviceId;

}
