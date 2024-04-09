package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    /* 필기.
     *  @Pointcut : 여러 조인 포인트(실제 타겟)를 매치하기 위해 지정한 표현식
     *  execution([수식어] 리턴타입 [클래스 이름].메소드(파라미터))
     *  public private default protected 접근제어자
     *  *Service.*(..) : 매개변수가 0개 이상인 모든 메소드 지칭
     *  *Service.*(*) : 매개변수가 1개인 모든 메소드 지칭
     *  *Service.*(*, ..) : 매개변수가 2개인 모든 메소드 지칭
     */


    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut() {}

    /* 필기.
    *   advice 의 종류
    *   @Before
    *   @After
    *   @AfterReturning
    *   @AfterThrowing
    *   @Around
    *  */

    /* 필기.
    *   JoinPoint : 포인트 컷으로 패치한 실행 지점(타겟)
    *   이렇게 매치된 조인 포인트에서 해야 할 일을 지정하는 것이 Advice 라고 한다.
    *   매개변수로 전달한 JoinPoint 는 현재 조인 포인트의 메소드명, 인수값 등의
    *   정보들을 가져올 수 있다.
    *  */
    @Before("LoggingAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature() : " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0) {
            System.out.println("Before joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() : " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0) {
            System.out.println("After joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }


}
