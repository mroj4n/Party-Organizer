package pl.edu.pwr.party_organizer.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class StatisticAspect {
    @Pointcut("execution(public * pl.edu.pwr.party_organizer.*.*.*(..)) ")
    public void myPointcut(){}

    @Around("myPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("In Around Aspect");
        System.out.println("Method Name :" + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));
        Object value = joinPoint.proceed();
        return value;
    }
}
