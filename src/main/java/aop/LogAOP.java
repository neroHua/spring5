package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.annotation.*;

@Aspect
public class LogAOP {

    @Pointcut(value = "execution(public * com.nero.hua..*Test())")
    public void logTestPointCut1() {
    }

    @Pointcut(value = "execution(public * com.nero.hua..*test())")
    public void logTestPointCut2() {
    }

    @Pointcut(value = "logTestPointCut1() ||a logTestPointCut2()")
    public void logTestPointCut() {
    }


//    @Around("execution(public * com.nero.hua..*test()) || execution(public * com.nero.hua..*Test())")
    @Around("logTestPointCut()")
    public void test(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before test");
        proceedingJoinPoint.proceed();
        System.out.println("after test");
    }

    @Around("execution(public * com.nero.hua..*fly())")
    public void fly(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before fly");
        proceedingJoinPoint.proceed();
        System.out.println("after fly");
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Documented
    public @interface Log {
    }

    @Around("@annotation(aop.LogAOP.Log)")
    public void logAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before annotation");
        proceedingJoinPoint.proceed();
        System.out.println("after annotation");
    }

}
