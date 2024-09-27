package org.example.resource;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.example.common.PageSupport;
import org.example.dto.StockDataDto;
import org.example.service.StockDataService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("api/stock-data")
@Tag(name = "stock-information")
public class StockDataResource {

	@Inject
	StockDataService service;

	@POST
	@Path("/v1")
	@Operation(summary = "save the stock details", description = "save the stock details")
	@APIResponses(value = { @APIResponse(responseCode = "200", description = "SUCCESS"),
			@APIResponse(responseCode = "400", description = "BADREQUEST"),
			@APIResponse(responseCode = "500", description = "INTERNAL SERVER ERROR") })
	public Response saveStockData(StockDataDto stockDataDto) {
		StockDataDto stockData = service.saveStockInforamtion(stockDataDto);
		return Response.status(Response.Status.OK).entity(stockData).build();
	}

	@GET
	@Path("/v1")
	@Operation(summary = "Get all stock details", description = "Get All stock details")
	@APIResponses(value = { @APIResponse(responseCode = "200", description = "SUCCESS"),
			@APIResponse(responseCode = "400", description = "BADREQUEST"),
			@APIResponse(responseCode = "500", description = "INTERNAL SERVER ERROR") })
	public Response getAllStockData(@QueryParam(value = "paze") @DefaultValue(PageSupport.FIRST_PAGE_NUM) int page,
			@QueryParam(value = "size") @DefaultValue(PageSupport.DEFAULT_PAGE_SIZE) int size,
			@QueryParam(value = "isPageSupport") @DefaultValue("true") Boolean isPageSupport) {
		PageSupport<StockDataDto> support = service.getAllStockData(page, size, isPageSupport);
		return Response.status(Response.Status.OK).entity(support).build();

	}

}
