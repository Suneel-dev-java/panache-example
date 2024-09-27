package org.example.service;

import org.example.common.PageSupport;
import org.example.dto.StockDataDto;

public interface StockDataService {

	StockDataDto saveStockInforamtion(StockDataDto stockDataDto);

	PageSupport<StockDataDto> getAllStockData(int page, int size, Boolean isPageSupport);

}
