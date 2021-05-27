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
public class LoggingAspect {    //  Cross-cutting concern
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    //  Before is an advice
    //  execution... is a join point and uses point-cut expression
    @Before("execution(* in.athenaeum.springaopdemo.controller.SampleController.greeter())")
    public void beforeExecution() {
        logger.info("About to execute the method");
    }

    //  After is an advice
    @After("execution(* in.athenaeum.springaopdemo.controller.SampleController.greeter())")
    public void afterExecution() {
        logger.info("Finished executing the method");
    }
}
