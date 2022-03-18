package by.gorbov.demotest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class MainController {

    @GetMapping
    public String lol() {
        return "123";
    }
}
