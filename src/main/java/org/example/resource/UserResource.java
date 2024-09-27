package org.example.resource;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.example.dto.UserInformationDto;
import org.example.service.UserInformationService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("api/user-info")
@Tag(name = "UserInforamtion")
public class UserResource {

	@Inject
	UserInformationService userInformationService;

	@POST
	@Path("/v1")
	@Operation(summary = "save user Information", description = "save user Information")
	@APIResponses(value = { @APIResponse(responseCode = "200", description = "SUCCESS"),
			@APIResponse(responseCode = "400", description = "BADREQUEST"),
			@APIResponse(responseCode = "500", description = "INTERNAL SERVER ERROR") })
	public Response saveUserInforamtion(UserInformationDto userInformationDto) {
		UserInformationDto uDto = userInformationService.saveUserInforamtion(userInformationDto);
		return Response.status(Response.Status.OK).entity(uDto).build();

	}

	@GET
	@Path("/v1")
	@Operation(summary = "get All user Information", description = "get All user Information")
	@APIResponses(value = { @APIResponse(responseCode = "200", description = "SUCCESS"),
			@APIResponse(responseCode = "400", description = "BADREQUEST"),
			@APIResponse(responseCode = "500", description = "INTERNAL SERVER ERROR") })
	public Response getAllUserInforamtion() {
		List<UserInformationDto> userInformationDtos = userInformationService.getAllUserInfo();
		return Response.status(Response.Status.OK).entity(userInformationDtos).build();
	}

	@DELETE
	@Path("/v1")
	@Operation(summary = "delete user Information", description = "delete All user Information")
	@APIResponses(value = { @APIResponse(responseCode = "200", description = "SUCCESS"),
			@APIResponse(responseCode = "400", description = "BADREQUEST"),
			@APIResponse(responseCode = "500", description = "INTERNAL SERVER ERROR") })
	public Response deleteUserInformation(@QueryParam("id") Long id) {
		UserInformationDto userInformationDto = userInformationService.deleteUserInformation(id);
		return Response.status(Response.Status.OK).entity(userInformationDto).build();
	}

}
