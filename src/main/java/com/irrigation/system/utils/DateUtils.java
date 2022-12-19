package com.irrigation.system.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateUtils {

	public static final String MONTH_GENERAL_DATE = "MM/yyyy";
	public static final String GENERAL_DATE = "dd-MM-yyyy";

	public static final String DATE_WITH_YEAR = "MMM dd, yyyy";
	public static final String DATE_NO_YEAR = "MMM dd";
	public static final String GENERAL_DATE_TIME = "dd-MM-yyyy HH:mm:ss";

	public static final String GENERAL_TIME = "HH:mm";

	public static LocalTime parseTime(String text) {
		try {
			return LocalTime.parse(text, DateTimeFormatter.ofPattern(GENERAL_TIME));
		} catch (DateTimeParseException e) {
			log.error("Couldn't parse {} ", text);
			throw new DateTimeParseException(e.getMessage(), text, e.getErrorIndex());
		}
	}

	public static LocalDate parseDate(String text) {
		try {
			return text.isEmpty() ? null : LocalDate.parse(text, DateTimeFormatter.ofPattern(GENERAL_DATE));
		} catch (DateTimeParseException e) {
			log.error("Couldn't parse {} ", text);
			throw new DateTimeParseException(e.getMessage(), text, e.getErrorIndex());
		}
	}

	public static LocalDate parseDate(String text, String pattern) {
		try {

			DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern(pattern)
					.parseDefaulting(ChronoField.DAY_OF_MONTH, 1).toFormatter();

			return text.isEmpty() ? null : LocalDate.parse(text, formatter);
		} catch (DateTimeParseException e) {
			log.error("Couldn't parse {} ", text);
			throw new DateTimeParseException(e.getMessage(), text, e.getErrorIndex());
		}
	}

	public static String formatDate(LocalDate date, String patternText) {
		try {
			DateTimeFormatter pattern = DateTimeFormatter.ofPattern(patternText);
			return date.format(pattern);
		} catch (IllegalArgumentException e) {
			log.error("Couldn't convert date {} ", e.getMessage());
			throw e;
		}
	}

	public static Date convertLocalDatetoDate(LocalDate date) {
		return Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

}
