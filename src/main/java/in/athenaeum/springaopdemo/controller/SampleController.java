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

//  We have written an aspect for this controller
//  Spring AOP creates a proxy class which also has greeter(...)
//  When the controller receives the get request, this proxy will be called
//  The proxy's greeter will create a method body that has:
//  Aspect aspect = new LoggingAspect();
//  ProceesingJoinPoint jp = new ProceedingJoinPoint() {    //Anonymous class implementation
//      Object proceed() {
//          return super.greeter(...); // call the real object
//      }
//  }
//  return aspect.logAround(jp);

//  When the type that is proxied is an interface, JDK dynamic proxy mechanism is used
//  For the concrete types, CGLIB proxy mechanism is used
//  More info: https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch08s06.html
//  For this reason, the concrete classes, if used, should be non-final and completely visible
//  Also, the methods that take aspect, should not be final. If the method is final,
//  that's not an error, but it will lose cross-cutting functionality.
