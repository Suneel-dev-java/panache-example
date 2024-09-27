package org.example.service;

import java.util.Comparator;
import java.util.List;

import org.example.common.PageSupport;
import org.example.dto.StockDataDto;
import org.example.entity.StockData;
import org.example.repository.StockDataRepository;
import org.modelmapper.ModelMapper;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class StockDataServiceImpl implements StockDataService {

	@Inject
	StockDataRepository stockDataRepository;

	@Inject
	ModelMapper mapper;

	@Override
	@Transactional
	public StockDataDto saveStockInforamtion(StockDataDto stockDataDto) {
		StockData stockData = mapper.map(stockDataDto, StockData.class);
		stockDataRepository.persist(stockData);
		return mapper.map(stockData, StockDataDto.class);
	}

	@Override
	public PageSupport<StockDataDto> getAllStockData(int page, int size, Boolean isPageSupport) {
		if (Boolean.TRUE.equals(isPageSupport)) {
			PanacheQuery<StockData> query = stockDataRepository.findAll();
			List<StockData> stockDatas = query.page(page, size).list();
			List<StockDataDto> stockDataDtos = stockDatas.stream().filter(response -> response != null)
					.sorted(Comparator.comparing(StockData::getId).reversed())
					.map(result -> mapper.map(result, StockDataDto.class)).toList();
			PageSupport<StockDataDto> pageSupport = new PageSupport<StockDataDto>(stockDataDtos, page, size,
					query.count());
			return pageSupport;
		} else {

			List<StockData> stockDatas = stockDataRepository.listAll();
			List<StockDataDto> stockDataDtos = stockDatas.stream().filter(response -> response != null)
					.sorted(Comparator.comparing(StockData::getId).reversed())
					.map(result -> mapper.map(result, StockDataDto.class)).toList();
			PageSupport<StockDataDto> pageSupport = new PageSupport<StockDataDto>(stockDataDtos, page, size,
					stockDatas.size());
			return pageSupport;

		}
	}

}
