package com.irrigation.system.dto.request;

import static com.irrigation.system.utils.DateUtils.GENERAL_DATE;
import static com.irrigation.system.utils.DateUtils.GENERAL_TIME;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.irrigation.system.dto.serializers.CustomDateDeserializer;
import com.irrigation.system.dto.serializers.CustomTimeDeserializer;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SlotRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4435853783611849480L;

	@NotNull
	private Integer plotId;

	@NotNull(message = "Start time is Required")
	@JsonDeserialize(using = CustomTimeDeserializer.class)
	@DateTimeFormat(pattern = GENERAL_TIME)
	private LocalTime startTime;

	@NotNull(message = "End time is Required")
	@JsonDeserialize(using = CustomTimeDeserializer.class)
	@DateTimeFormat(pattern = GENERAL_TIME)
	private LocalTime endTime;

	@Nullable
	@JsonDeserialize(using = CustomDateDeserializer.class)
	@DateTimeFormat(pattern = GENERAL_DATE)
	private LocalDate date;

	private boolean recurring;
	private boolean active;
	private String sensorDeviceId;

}
