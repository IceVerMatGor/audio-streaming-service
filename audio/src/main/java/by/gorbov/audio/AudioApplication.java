package by.gorbov.audio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.content.rest.config.RestConfiguration;
import org.springframework.context.annotation.Import;



@EnableEurekaClient
@SpringBootApplication
public class AudioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudioApplication.class, args);
	}

}
