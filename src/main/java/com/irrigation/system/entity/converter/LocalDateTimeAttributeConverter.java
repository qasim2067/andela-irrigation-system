package com.irrigation.system.entity.converter;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
		return (attribute == null ? null : Timestamp.valueOf(attribute));
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
		return (dbData == null ? null
				: Instant.ofEpochMilli(dbData.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime());
	}

}
