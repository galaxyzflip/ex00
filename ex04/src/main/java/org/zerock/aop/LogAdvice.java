package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {
	
	
	//pointcut > execution(* ......... )
	@Before("execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("==============================");
	}
	
	//메서드에 전달하는 파타미터가 무엇인지 기록  &&args(str1, str2)
	@Before("execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
	public void logBeforeWithParam(String str1, String str2) {

		log.info("str1 :" + str1);
		log.info("str2 :" + str2);
	}
	
	
	//exception 발생후에 동작한다.
	@AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))",
			throwing = "exception")
	public void logException(Exception exception) {
		log.info("Exception......sfkdljsdljfsl");
		log.info("exception : " + exception);
	}
	
	
	//대상 메소드를 실행할 수 있는 권한을 가지고 메서드의 실행 전과 실행 후에 처리가 가능하다.
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime( ProceedingJoinPoint pjp) {
		
		long start = System.currentTimeMillis();
		
		log.info("Target: " + pjp.getTarget());
		log.info("Param: " + Arrays.toString(pjp.getArgs()));
		
		//invoke method
		Object result = null;
		
		try {
			result = pjp.proceed();
		
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		log.info("TIME: " + (end - start));
		
		return result;
		
		
	}

}

















