package com.core.model.response;

public enum APIStatus {
	OK(200, "OK"),
	
	ERR_BAD_PARAMS(400, "Bad params"),
 
	ERR_LOGOUT(111, "You're not logged"),
	
	ERR_SYSTEM(101, "ERR_SYSTEM"),
	
	INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR"),
	
	//category 250 299
	ERR_CATEGORY_ID_NOT_EXISTS(251, "category id not exists"),
	ERR_CATEGORY_CODE_NOT_EXISTS(252, "cateogry code not exists"),
	ERR_CATEGORY_NOT_EXISTS(253, "category not exists"),
	ERR_CATEGORY_PARENT_NOT_EXISTS(254, "category parent not exists"),
	
	//category 301 349
	ERR_SALE_ORDER_ID_NOT_EXISTS(251, "Sale order id not exists"),
	ERR_SALE_ORDER_NOT_EXISTS(253, "Sale order not exists"),
	ERR_STOCK_NOT_ENOUGH(254, "Không đủ kho"),
	
	ERR_PRODUCT_ID_NOT_EXISTS(251, "product id not exists"),
	ERR_PRODUCT_NOT_EXISTS(253, "product not exists"),
	
	 
	
	ERR_BAD_UNAUTHORIZED(255, "Sorry! We've got an Unauthorized Redirect URI and can't proceed with the authentication"),
	
	ERR_USER_NOT_EXISTS(253, "Tài khoản không tồn tại"),
	
	ERR_USERNAME_IS_EXISTS(270, "Tên tài khoản đã tồn tại"),
	
	ERR_EMAIL_IS_EXISTS(271, "Email đã tồn tại"),

	ERR_ACCOUNT_IS_NOT_VERIFIED(272, "Tài khoản chưa được xác thực"),
	
	ERR_EMAIL_IS_EXISTSS_AND_ACCOUNT_IS_NOT_VERIFIED(272, "Email đã được đăng ký và tài khoản này chưa được xác thực"),
	
	ERR_OTP_IS_EXPIRE(273, "OTP đã hết hạn"),
	
	ERR_ACCOUNT_AND_PASSWORD_IS_WRONG(275, "Tài khoản hoặc mật khẩu chưa chính xác"),
	
	ERR_OTP_DOES_NOT_EXISTS(276, "OTP không tồn tại"),
	
	
	ERR_FOOD_ID_NOT_EXISTS(251, "category id not exists"),
	ERR_FOOD_CODE_NOT_EXISTS(252, "cateogry code not exists"),
	ERR_FOOD_DOES_NOT_EXISTS(252, "food does not exists"),
 
	;
	
	
	private final int code;
	private final String message;
	
	private APIStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
 
}
