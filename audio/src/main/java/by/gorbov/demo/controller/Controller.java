package by.gorbov.demo.controller;

import by.gorbov.demo.dto.Response;
import by.gorbov.demo.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping
    public List<Response> doSome(){
        return service.doSomething();
    }
}
