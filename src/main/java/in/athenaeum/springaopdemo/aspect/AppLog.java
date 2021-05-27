package in.athenaeum.springaopdemo.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
public @interface AppLog {
}
