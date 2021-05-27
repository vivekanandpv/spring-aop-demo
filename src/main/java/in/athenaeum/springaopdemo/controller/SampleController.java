package in.athenaeum.springaopdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sample")
public class SampleController {
    @GetMapping("/{firstName}/{lastName}")
    public String greeter(@PathVariable String firstName, @PathVariable String lastName) {
        return "Hi there! " + firstName + " " + lastName + "!";
    }
}
