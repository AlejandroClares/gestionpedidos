package com.pgrsoft.gestionpedidos.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AopConfig {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.pgrsoft.gestionpedidos.backend.restcontrollers.*.*(..))")
	public void beforeEndpointsExecution(JoinPoint joinPoint){
		
		//Advice
	
		String clase = joinPoint.getSourceLocation().getWithinType().getSimpleName();
		String metodo = joinPoint.getSignature().getName();
		
		
		logger.info("acceso a " + clase + "/" + metodo);
	}
	
	
	@AfterThrowing(pointcut = "execution(* com.pgrsoft.gestionpedidos.backend.presentation.services.impl.*.*(..))", throwing = "ex")
    public void bussinesLayerException(Exception ex) {
		System.out.println("***************************************************************");
        //ex.printStackTrace();
    }
	
	@AfterThrowing(pointcut = "execution(* com.pgrsoft.gestionpedidos.backend.restcontrollers.*.*(..))", throwing = "ex")
    public void logError2(Exception ex) {
        ex.printStackTrace();
    }
	
	
}
