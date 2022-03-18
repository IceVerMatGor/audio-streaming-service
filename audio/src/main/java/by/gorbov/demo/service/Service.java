package by.gorbov.demo.service;

import by.gorbov.demo.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);
    private final RestTemplate restTemplate;

    public Service(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Response> doSomething() {
        Response song = restTemplate.getForObject(
                "http://MYFIRSTMICROSERVICE/songs/16",
                Response.class
        );
        List<Response> songDto= new ArrayList<>();
        songDto.add(song);
        LOGGER.info("{}", 12);
        return songDto;
    }
}
