package com.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.StockTotal;
import com.app.model.response.APIResponse;
import com.app.model.response.StockTotalResponse;
import com.app.service.StockTotalService;
import com.app.utils.PathUtils;
import com.app.utils.ResponseUtils;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StockTotalController extends BaseController {
	
	private final StockTotalService stockTotalService;
	
	@GetMapping(value = PathUtils.STOCK_API_V1 + PathUtils.STOCK_GET_BY_PRODUCT_VARIANT_ID)
	public ResponseEntity<APIResponse<StockTotalResponse>> getByProductVariantId(@PathVariable("product_variant_id") Long id) {
		StockTotalResponse stockTotal = stockTotalService.findByProductVariantId(id);
		return responseSuccess(stockTotal);
	}
	
	@GetMapping(value = PathUtils.STOCK_API_V1 + PathUtils.STOCK_GET_BY_PRODUCT_ID)
	public ResponseEntity<APIResponse> getByProductId(@PathVariable("product_id") Long id) {
		List<StockTotal> stockTotals = stockTotalService.findByProductId(id);
		return ResponseUtils.responseSuccess(stockTotals);
	}
	
}
