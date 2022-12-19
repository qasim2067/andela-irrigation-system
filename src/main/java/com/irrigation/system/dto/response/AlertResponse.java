package com.irrigation.system.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.irrigation.system.dto.serializers.CustomDateTimeSerializer;
import com.irrigation.system.entity.Slots;

import lombok.Data;

@Data
public class AlertResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6728708385903210035L;
	
	private Slots slot;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	private LocalDateTime alertTime;

	private String message;

	private Integer retryCalls;
}
