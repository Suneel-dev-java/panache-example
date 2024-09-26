package org.example.resource;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.example.dto.VechicleInformationDto;
import org.example.service.VechicleService;

import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("api/vechile-inforamton")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Vechicle Inforamtion")
public class VechicleResource {

	@Inject
	VechicleService vechicleService;

	@POST
	@Path("/v1")
	@Operation(summary = "save the vechicle inforamtion", description = "save the vechicle inforamtion")
	@APIResponses(value = { @APIResponse(responseCode = "200", description = "SUCCESS"),
			@APIResponse(responseCode = "400", description = "BAD REQUEST"),
			@APIResponse(responseCode = "500", description = "INTERNAL SERVER ERROR") })
	public Response saveVechileData(VechicleInformationDto vechicleInformationDto) {
		VechicleInformationDto vechicle = vechicleService.saveVechicleInfo(vechicleInformationDto);
		return Response.status(Response.Status.OK).entity(vechicle).build();

	}

	@GET
	@Path("/v1")
	@Operation(summary = "get All the vechicle inforamtion", description = "get All the vechicle inforamtion")
	@APIResponses(value = { @APIResponse(responseCode = "200", description = "SUCCESS"),
			@APIResponse(responseCode = "400", description = "BAD REQUEST"),
			@APIResponse(responseCode = "500", description = "INTERNAL SERVER ERROR") })
	public Response getAllVechicleInfo() {
		List<VechicleInformationDto> vechicleInformationDtos = vechicleService.getAllVechicles();
		return Response.status(Response.Status.OK).entity(vechicleInformationDtos).build();
	}

	@GET
	@Path("/v1/id")
	@Operation(summary = "get vechicle inforamtionById", description = "get vechicle inforamtionById")
	@APIResponses(value = { @APIResponse(responseCode = "200", description = "SUCCESS"),
			@APIResponse(responseCode = "400", description = "BAD REQUEST"),
			@APIResponse(responseCode = "500", description = "INTERNAL SERVER ERROR") })
	public Response getVechicleInfo(@Parameter(required = true) @QueryParam(value = "id") Long id) {
		VechicleInformationDto vechicleInformationDtos = vechicleService.getVechicleInfo(id);
		return Response.status(Response.Status.OK).entity(vechicleInformationDtos).build();

	}

	@DELETE
	@Path("/v1/id")
	@Operation(summary = "delete vechicle inforamtionById", description = "delete vechicle inforamtionById")
	@APIResponses(value = { @APIResponse(responseCode = "200", description = "SUCCESS"),
			@APIResponse(responseCode = "400", description = "BAD REQUEST"),
			@APIResponse(responseCode = "500", description = "INTERNAL SERVER ERROR") })
	public Response deleteVechicleInfo(@Parameter(required = true) @QueryParam(value = "id") Long id) {
		VechicleInformationDto vechicleInformationDtos = vechicleService.deleteVechicleInfo(id);
		return Response.status(Response.Status.OK).entity(vechicleInformationDtos).build();

	}

	@PUT
	@Path("v1")
	@Operation(summary = "update vechicle inforamtionById", description = "update vechicle inforamtionById")
	@APIResponses(value = { @APIResponse(responseCode = "200", description = "SUCCESS"),
			@APIResponse(responseCode = "400", description = "BAD REQUEST"),
			@APIResponse(responseCode = "500", description = "INTERNAL SERVER ERROR") })
	public Response updateVechicleInfo(VechicleInformationDto vechicleInformationDto) {
		VechicleInformationDto vechicleInformationDtos = vechicleService.updateVechicleInfo(vechicleInformationDto);
		return Response.status(Response.Status.OK).entity(vechicleInformationDtos).build();

	}
}
