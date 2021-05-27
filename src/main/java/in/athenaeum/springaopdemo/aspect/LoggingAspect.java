package in.athenaeum.springaopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@EnableAspectJAutoProxy
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Before("execution(* in.athenaeum.springaopdemo.controller.SampleController.greeter())")
    public void beforeExecution() {
        logger.info("About to execute the method");
    }

    @After("execution(* in.athenaeum.springaopdemo.controller.SampleController.greeter())")
    public void afterExecution() {
        logger.info("Finished executing the method");
    }
}
