package ru.local.betback;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect {

    //    @Before("@annotation(LogMethod)")
    //    @Pointcut("execution(* * *(..))")
    @Around("@annotation(LogMethod)")
    public Object logMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("testAdvice() is running!");
        return proceedingJoinPoint.proceed();
    }

}
