package in.athenaeum.springaopdemo.controller;

import in.athenaeum.springaopdemo.aspect.AppExceptionHandler;
import in.athenaeum.springaopdemo.aspect.AppLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sample")
public class SampleController {
    @AppLog
    @AppExceptionHandler
    @GetMapping("/{firstName}/{lastName}")
    public String greeter(@PathVariable String firstName, @PathVariable String lastName) {
        if (firstName.length() < 5) {
            throw new RuntimeException("Name must not be less than 5 characters");
        }
        return "Hi there! " + firstName + " " + lastName + "!";
    }

    @GetMapping
    public String greeter() {
        return "Hello, world!";
    }
}