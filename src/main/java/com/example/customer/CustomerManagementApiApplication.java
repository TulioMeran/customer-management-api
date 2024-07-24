package com.example.customer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Customer Management API REST API Documentation",
				description = "Customer Management API REST API Documentation ",
				version = "v1",
				contact = @Contact(
						name = "Tulio Meran",
						email = "rtulio007@gmail.com",
						url = ""
				),
				license = @License(
						name = "Apache 2.0"
				)
		)
)
public class CustomerManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementApiApplication.class, args);
	}

}
