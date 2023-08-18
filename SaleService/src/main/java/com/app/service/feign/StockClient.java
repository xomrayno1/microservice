package com.app.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.model.response.APIResponse;
import com.app.model.response.StockTotalResponse;
import com.app.utils.PathUtils;

@FeignClient(name = "stock-service")
public interface StockClient {
	
	@GetMapping(value = PathUtils.STOCK_API_V1 + PathUtils.STOCK_GET_BY_PRODUCT_VARIANT_ID)
	public ResponseEntity<APIResponse<StockTotalResponse>> getByProductVariantId(@PathVariable("product_variant_id") Long id);

}
