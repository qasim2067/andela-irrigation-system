package com.irrigation.system.dto.serializers;

import java.io.IOException;
import java.time.LocalTime;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.irrigation.system.utils.DateUtils;

public class CustomTimeDeserializer extends JsonDeserializer<LocalTime> {

	@Override
	public LocalTime deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		if (StringUtils.hasText(jp.getText()))
			return DateUtils.parseTime(jp.getText());

		return LocalTime.now();
	}
}
