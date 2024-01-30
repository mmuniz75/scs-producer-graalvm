package lab.plates.producer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@OpenAPIDefinition
public class PlatesApplication {
	@Generated
	public static void main(String[] args) {
		SpringApplication.run(PlatesApplication.class, args);
	}


}

