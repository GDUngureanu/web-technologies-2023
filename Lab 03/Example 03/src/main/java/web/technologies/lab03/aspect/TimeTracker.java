package web.technologies.lab03.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TimeTracker {

    @Around("execution(* web.technologies.lab03.system.TextileConsole.*(..)) || execution(* web.technologies.lab03.system.FashionConsole.*(..))")
    public Object logSystemTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();  // Continue with method execution

        long endTime = System.currentTimeMillis();
        log.info("Time taken by " + joinPoint.getSignature() + ": " + (endTime - startTime) + " ms");

        return proceed;
    }

    @Around("execution(* web.technologies.lab03.service.*.*.*(..))")
    public Object logServiceTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();

        // Retrieve only the simple class name without the package info
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        Object proceed = joinPoint.proceed();  // Continue with method execution

        long executionTime = System.nanoTime() - start;
        log.info("{}#{} executed in {} ns", className, methodName, executionTime);

        return proceed;
    }
}
