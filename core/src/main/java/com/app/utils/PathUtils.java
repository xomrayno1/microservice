package com.app.utils;

public class PathUtils {
	private PathUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static final String VERSION_V1 = "v1";

	public static final String API = "api";

	public static final String SLASH = "/";

	public static final String HEALTH_CHECK_API = "/healthCheck";

	public static final String USER_SERVICE = "user-service";

	public static final String API_V1_PREFIX = SLASH + API + SLASH + VERSION_V1;

	// user api
	public static final String USER_API = "users";

	public static final String USER_API_V1 = API_V1_PREFIX + SLASH + USER_API;

	public static final String SALE_SERVICE = SLASH + "sale";
	
	// category api
	public static final String CATEGORY_API = "category";

	public static final String CATEGORY_API_V1 = SLASH + API + SLASH + VERSION_V1 + SALE_SERVICE + SLASH + CATEGORY_API;

	public static final String CATEGORY_PAGING_SEARCH_SORT_FILTER = SLASH + "category_paging_search_sort_filter";

	public static final String CATEGORY_GET_BY_ID = SLASH + "category_by_id/{id}";

	public static final String CATEGORY_CREATE = SLASH + "category_create";

	public static final String CATEGORY_UPDATE = SLASH + "category_update";

	public static final String CATEGORY_DELETES = SLASH + "category_deletes";

	public static final String CATEGORY_GET_ALL = SLASH + "category_get_all";

	// product api
	public static final String PRODUCT_API = "product";

	public static final String PRODUCT_API_V1 = SLASH + API + SLASH + VERSION_V1 + SALE_SERVICE + SLASH + PRODUCT_API;

	public static final String PRODUCT_PAGING_SEARCH_SORT_FILTER = SLASH + "product_paging_search_sort_filter";

	public static final String PRODUCT_GET_BY_ID = SLASH + "product_by_id/{id}";

	public static final String PRODUCT_CREATE = SLASH + "product_create";

	public static final String PRODUCT_UPDATE = SLASH + "product_update";

	public static final String PRODUCT_DELETES = SLASH + "product_deletes";

	public static final String PRODUCT_GET_ALL = SLASH + "product_get_all";
	
	//variant
	public static final String VARIANT_API = SLASH + "variant";
	
	public static final String VARIANT_CREATE = SLASH + "variant_create";

	// sale api

	public static final String SALE_ORDER_API = "sale_order";

	public static final String SALE_ORDER_API_V1 = SLASH + API + SLASH + VERSION_V1 + SALE_SERVICE + SLASH + SALE_ORDER_API;

	public static final String SALE_ORDER_PAGING_SEARCH_SORT_FILTER = SLASH + "sale_order_paging_search_sort_filter";

	public static final String SALE_ORDER_GET_BY_ID = SLASH + "sale_order_by_id/{id}";

	public static final String SALE_ORDER_CREATE = SLASH + "sale_order_create";
	
	
	// stock  api
	
	public static final String STOCK_SERVICE = SLASH + "stock";
	
	public static final String STOCK_API = "stock";
	
	public static final String STOCK_API_V1 = SLASH + API + SLASH + VERSION_V1 + STOCK_SERVICE + SLASH + STOCK_API;
	
	public static final String STOCK_GET_BY_PRODUCT_VARIANT_ID = SLASH + "stock_by_product_variant_id/{product_variant_id}";
	
	public static final String STOCK_GET_BY_PRODUCT_ID = SLASH + "stock_by_product_id/{product_id}";
	
	// stock trans api
	public static final String STOCK_TRANS_API = "trans";

	public static final String STOCK_TRANS_API_V1 = STOCK_API_V1 +  SLASH +  STOCK_TRANS_API;

	public static final String STOCK_TRANS_PAGING_SEARCH_SORT_FILTER = SLASH + "stock_trans_paging_search_sort_filter";

	public static final String STOCK_TRANS_GET_BY_ID = SLASH + "stock_trans_by_id/{id}";

	public static final String STOCK_TRANS_CREATE = SLASH + "stock_trans_create";

	public static final String STOCK_TRANS_UPDATE = SLASH + "stock_trans_update";

	public static final String STOCK_TRANS_DELETES = SLASH + "stock_trans_deletes";

	public static final String STOCK_TRANS_GET_ALL = SLASH + "product_get_all";
	
	
	 
}
