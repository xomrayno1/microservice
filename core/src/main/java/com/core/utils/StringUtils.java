package com.core.utils;

import java.util.Locale;

public class StringUtils {
	private static final String EMPTY_STRING = "";

	private StringUtils() {
		throw new IllegalArgumentException("StringUtils is uitl class");
	}

	public static boolean isNullOrEmpty(String value) {
		return value == null || value.trim().isEmpty() || EMPTY_STRING.equals(value.trim());
	}

	public static String capitalize(String value) {
		if (!isNullOrEmpty(value) && value.length() > 1) {
			if (value.length() > 1) {
				return value.substring(0, 1).toUpperCase(Locale.ENGLISH).concat(value.substring(1));
			}
			return value.substring(0, 1).toUpperCase(Locale.ENGLISH);
		}
		return null;
	}

	public static String wraptextSearchFullLike(String text) {
		return "%" + text.trim() + "%";
	}
}
