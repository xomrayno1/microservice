package com.core.utils;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

public class Commons {
	private static SecureRandom secureRandom = new SecureRandom();

	private Commons() {
		throw new IllegalArgumentException("Commons is uitl class");
	}

	public static String generateCategoryCode() {
		return "C" + generateRandomNumber();
	}

	public static String generateSupplierCode() {
		return "S" + generateRandomNumber();
	}

	public static String generateProductCode() {
		return "P" + generateRandomNumber();
	}

	public static String generateTrainingScheduleCode() {
		return "TN" + generateRandomNumber();
	}
	
	public static String generateFoodCode() {
		return "F" + generateRandomNumber();
	}

	public static Long generateRandomNumber() {
		return Math.abs(secureRandom.nextLong() % 100000000000L);
	}
	
	public static String randomOTP() {
		return generateRandomNumber().toString().substring(0, 8);
	}

	public static <T> Optional<T> formatValue(T t) {
		return Optional.empty();
	}
	
	public static <T> boolean isNullOrEmpty(List<T> values) {
		return values == null || values.isEmpty();
	}
}
