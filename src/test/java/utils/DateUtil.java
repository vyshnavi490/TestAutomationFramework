package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	public static long getCurrentMilliseconds() {
		return System.currentTimeMillis();
	}

	public static String generateDateString() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_SS");
		String formattedDate = now.format(formatter);
		return formattedDate;
	}
}