package ru.local.betback;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect {

    //    @Before("@annotation(LogMethod)")
    //    @Pointcut("execution(* * *(..))")
//    @Around("@annotation(LogMethod)")
    @AfterReturning("execution(* ru..*Controller.*(..))")
    public void logMethod(JoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("testAdvice() is running!");
    }

}
