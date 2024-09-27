package org.example.resource;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.example.dto.StudentInformationDto;
import org.example.service.StudentInforamtionService;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("api/student-information")
@Tag(name = "StudentInforamtion")
public class StudentInformationResource {

	@Inject
	StudentInforamtionService service;

	@POST
	@Path("/v1")
	@Operation(summary = "save the studentInformation", description = "save the student Information")
	@APIResponses(value = { @APIResponse(responseCode = "200", description = "SUCCESS"),
			@APIResponse(responseCode = "400", description = "BAD REQUEST"),
			@APIResponse(responseCode = "500", description = "INTERNAL SERVER ERROR") })
	public Response saveStudentInfo(StudentInformationDto studentInformationDto) {
		StudentInformationDto sDto = service.saveStudentInfo(studentInformationDto);
		return Response.status(Response.Status.OK).entity(sDto).build();

	}

}
