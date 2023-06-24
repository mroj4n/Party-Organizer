package pl.edu.pwr.party_organizer.aspect;

import pl.edu.pwr.party_organizer.model.Party;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import pl.edu.pwr.party_organizer.model.Guest;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
@Aspect
public class StatisticAspect {
    private Map<String, Integer> methodCallsCount = new HashMap<>();
    private Party oldestEvent;

    // Pointcut for getAllEvents method in EventService
    @Pointcut("execution(public java.util.List<com.example.model.Event> com.example.service.EventService.getAllEvents())")
    public void getAllEventsPointcut() {}

    // Pointcut for deleteEvent method in EventService
    @Pointcut("execution(public void com.example.service.EventService.deleteEvent(Integer)) && args(id)")
    public void deleteEventPointcut(Integer id) {}

    // Pointcut for createGuest method in GuestService
    @Pointcut("execution(public com.example.model.Guest com.example.service.GuestService.createGuest(com.example.model.Guest)) && args(guest)")
    public void createGuestPointcut(Guest guest) {}

    // Pointcut for deleteGuest method in GuestService
    @Pointcut("execution(public void com.example.service.GuestService.deleteGuest(Long)) && args(id)")
    public void deleteGuestPointcut(Long id) {}

    // Advice for getAllEvents method
    @Around("getAllEventsPointcut()")
    public Object GetAllEvents(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Collecting statistics for getAllEvents method");
        System.out.println("Method Name: " + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        System.out.println("Statistics collection completed for getAllEvents method");
        return result;
    }

    // Advice for deleteEvent method
    @Around("deleteEventPointcut(id)")
    public Object DeleteEvent(ProceedingJoinPoint joinPoint, Integer id) throws Throwable {
        System.out.println("Collecting statistics for deleteEvent method");
        System.out.println("Method Name: " + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        System.out.println("Statistics collection completed for deleteEvent method");
        return result;
    }

    // Advice for createGuest method
    @Around("createGuestPointcut(guest)")
    public Object CreateGuest(ProceedingJoinPoint joinPoint, Guest guest) throws Throwable {
        System.out.println("Collecting statistics for createGuest method");
        System.out.println("Method Name: " + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        System.out.println("Statistics collection completed for createGuest method");
        return result;
    }

    // Advice for deleteGuest method
    @Around("deleteGuestPointcut(id)")
    public Object DeleteGuest(ProceedingJoinPoint joinPoint, Long id) throws Throwable {
        System.out.println("Collecting statistics for deleteGuest method");
        System.out.println("Method Name: " + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        System.out.println("Statistics collection completed for deleteGuest method");
        return result;
    }

    // Advice to calculate the oldest event
    @AfterReturning(pointcut = "getAllEventsPointcut()", returning = "events")
    public void checkForOldestEvent(List<Party> events) {
        System.out.println("Calculating the oldest event");
        OffsetDateTime oldestDate = null;

        for (Party event : events) {
            OffsetDateTime eventDate = event.getDate().atStartOfDay().atOffset(ZoneOffset.ofHours(0));;
            if (oldestDate == null || eventDate.isBefore(oldestDate)) {
                oldestDate = eventDate;
                oldestEvent = event;
            }
        }

        System.out.println("Oldest Event: " + oldestEvent);
    }

    public Party getOldestEvent() {
        return oldestEvent;
    }

    @Around("execution(public * com.example.service.*.*(..))")
    public Object ServiceMethodsLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        incrementMethodCallCount(methodName);
        System.out.println("Collecting statistics for method: " + methodName);
        System.out.println("Method Name: " + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        System.out.println("Statistics collection completed for method: " + methodName);
        return result;
    }

    private void incrementMethodCallCount(String methodName) {
        int count = methodCallsCount.getOrDefault(methodName, 0);
        methodCallsCount.put(methodName, count + 1);
    }

    public  Map<String, Integer> getMethodCallsCount() {
        return methodCallsCount;
    }
}
