package in.athenaeum.springaopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@EnableAspectJAutoProxy
@Component
public class ExceptionAspect {
    private Logger logger = Logger.getLogger(ExceptionAspect.class.getName());

    //  for any method, execution(* *(..))
    @AfterThrowing(
            pointcut =
                    "@annotation(in.athenaeum.springaopdemo.aspect.AppExceptionHandler)",
            throwing = "exception"
    )
    public void handleException(RuntimeException exception) throws Throwable {
        logger.severe("Runtime exception logged in advice " + exception.getMessage());
    }
}
