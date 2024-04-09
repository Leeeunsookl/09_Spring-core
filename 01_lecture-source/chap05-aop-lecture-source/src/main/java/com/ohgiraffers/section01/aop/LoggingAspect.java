package com.ohgiraffers.section01.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    /* 필기.
     *  @Pointcut : 여러 조인 포인트(실제 타겟)를 매치하기 위해 지정한 표현식
     */


    @Pointcut("execution()")

}
