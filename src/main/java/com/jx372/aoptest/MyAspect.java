package com.jx372.aoptest;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Before( "execution(public ProductVo com.jx372.aoptest.ProductService.find(..))") //point cut, joinpoint
	public void beforeAdvice(){
		System.out.println("before advice() called");
	}
	
	@After("execution(ProductVo com.jx372.aoptest.ProductService.find(..))")
	public void afterAdvice( ){
		System.out.println("after advice() called");
	}
	
	//return type은 모든지, com.jx372.모든패키지
	@AfterReturning("execution(* com.jx372.*.ProductService.find(..))")
	public void afterReturningAdvice(){
		System.out.println("afterRetunring() called");
	}
	
	//모든 패키지 안에 있는 productservice의 모든 메소드. 모든 exception을 모을 수 도 있다.
	@AfterThrowing(value="execution(* *..*.ProductService.*(..))",throwing="ex")
	public void afterThrowingAdvice(Throwable ex){
		System.out.println("afterThrowingAdvice("+ex+") called");
	}
	
	//before and after, after before를 제거함으로 한가지 기능만 쓸 수 있다. 기능도 넣을 수 있어서 가장 많이씀
	@Around("execution(* *..*.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		//before advice
		System.out.println("[before]aroundAdvice() called");
		
		Object[] parameters = {"camera"};
		Object result = pjp.proceed(parameters);
		
		//after advice
		System.out.println("[after]aroundAdvice() called");
		
		return result;
	}
}
