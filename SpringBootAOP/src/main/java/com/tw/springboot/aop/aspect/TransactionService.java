package com.tw.springboot.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionService {
	@Pointcut("@annotation(com.tw.springboot.aop.anno.MyAnno)")
	public void m1() {
	}

	@Before("m1()")
	public void beginTrans() {
		System.out.println("Transaction begin");
	}

	@After("m1()")
	public void endTrans() {
		System.out.println("Transaction end");
	}
}
