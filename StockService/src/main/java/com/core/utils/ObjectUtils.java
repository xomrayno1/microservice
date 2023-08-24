package com.core.utils;

import java.beans.PropertyDescriptor;

public class ObjectUtils {
	private ObjectUtils() {
		throw new IllegalArgumentException("ObjectUtils is uitl class");
	}
 
	public static Object getter(Object object, String propertyName) {
		if(object != null && !StringUtils.isNullOrEmpty(propertyName)) {
			try {
				PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, object.getClass());
				return propertyDescriptor.getReadMethod().invoke(object);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static Object setter(Object object, String propertyName, Object value) {
		try {
			return new PropertyDescriptor(propertyName, object.getClass())
						.getWriteMethod().invoke(object, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void setterValue(Object object, String propertyName, Object value) {
		try {
			new PropertyDescriptor(propertyName, object.getClass())
						.getWriteMethod().invoke(object, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
	}
}
