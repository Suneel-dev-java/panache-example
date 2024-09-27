package org.example;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
@OpenAPIDefinition(info = @Info(title = "Quarkus Frame Work ", 
version = "1.0.0", description = "This API allows CRUD operations for Vechicle Information.", 
contact = @Contact(name = "Vechicle Information API Support", email = "support@vi.com"), 
license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html")))
public class VechicleInformation implements QuarkusApplication {

	public static void main(String[] args) {
		Quarkus.run(VechicleInformation.class, args);
	}

	@Override
	public int run(String... args) throws Exception {
		System.out.println("Application Started..........");
		Quarkus.waitForExit();
		return 0;
	}

}
