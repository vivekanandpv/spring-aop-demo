package in.athenaeum.springaopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
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

    @Around("execution(* in.athenaeum.springaopdemo.controller.SampleController.greeter(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //  get the arguments
        Object[] args = joinPoint.getArgs();

        logger.info("greeter() called with: ");
        for (Object a: args) {
            logger.info("Argument: " + a);
        }

        Object greeterReturnValue = joinPoint.proceed();

        logger.info("greeter() finished with result: " + greeterReturnValue);

        return greeterReturnValue;
    }
}
