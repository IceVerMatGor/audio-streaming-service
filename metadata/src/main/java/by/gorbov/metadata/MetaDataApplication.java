package by.gorbov.metadata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MetaDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetaDataApplication.class, args
		);
	}

}
