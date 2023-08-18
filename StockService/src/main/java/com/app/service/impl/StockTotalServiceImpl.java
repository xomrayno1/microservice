package com.app.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.StockTotal;
import com.app.exception.ValidateException;
import com.app.model.request.DecreaseStockRequest;
import com.app.model.response.StockTotalResponse;
import com.app.repository.StockTotalRepository;
import com.app.service.StockTotalService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StockTotalServiceImpl implements StockTotalService {
	
	private final StockTotalRepository stockTotalRepo;
	
	private final ModelMapper modelMapper;

	
	@Override
	public StockTotal findById(Long id) {
		return stockTotalRepo.findById(id).orElse(null);		
	}


	@Override
	public StockTotalResponse findByProductVariantId(Long id) {
		StockTotal stockTotal = stockTotalRepo.findByProductVariantId(id);
		if(stockTotal == null) {
			return null;
		}
		return modelMapper.map(stockTotal, StockTotalResponse.class);
	}

	@Override
	public List<StockTotal> findByProductId(Long id) {
		return stockTotalRepo.findByProductId(id);
	}


	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public void decreaseStock(DecreaseStockRequest decreaseStockRequest) {
		for(DecreaseStockRequest.Stock stock: decreaseStockRequest.getStocks()) {
			StockTotal stockTotal = stockTotalRepo.findByProductVariantId(stock.getProductVariantId());
			if(stockTotal == null) {
				throw new ValidateException(500, "Sản phẩm " + stock.getProductVariantNameFull() + " không tồn tại trong kho");
			}else {
				if(stockTotal.getQuantity() < stock.getQuantity()) {
					throw new ValidateException(500, "Sản phẩm " + stock.getProductVariantNameFull() + " đã hết trong kho");
				}
			}
			stockTotal.setQuantity(stockTotal.getQuantity() - stock.getQuantity());
			stockTotalRepo.save(stockTotal);
		}
 
	}
	
}
