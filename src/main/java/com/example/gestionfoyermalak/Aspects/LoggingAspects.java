package com.example.gestionfoyermalak.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspects {
    @Before("execution(* com.example.gestionfoyermalak.services.*.*(..))")
    public void logMethodeEntry(JoinPoint joinPoint){
        String name =joinPoint.getSignature().getName();
        log.info("In method : "+ name);
    }
    @After("execution(* com.example.gestionfoyermalak.services.*.*(..))")
    public void logMethodeExit(JoinPoint joinPoint){
        String name =joinPoint.getSignature().getName();
        log.info("Out of method : "+name);
    }


}
