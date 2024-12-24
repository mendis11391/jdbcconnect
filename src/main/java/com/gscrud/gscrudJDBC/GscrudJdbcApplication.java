package com.gscrud.gscrudJDBC;

import com.gscrud.gscrudJDBC.Facade.CustomerFacade;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GscrudJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(GscrudJdbcApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			CustomerFacade service = ctx.getBean(CustomerFacade.class);
			service.getCustomers();
		};
	}

}
