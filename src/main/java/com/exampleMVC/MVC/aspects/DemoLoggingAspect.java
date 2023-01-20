package com.exampleMVC.MVC.aspects;

import com.exampleMVC.MVC.DAO.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.List;

@Aspect
@Component
public class DemoLoggingAspect {

    //DECLARAR UNA POINTCUT EXPRESSION
    @Pointcut("execution(public * com.exampleMVC.MVC.DAO.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(public Integer com.exampleMVC.MVC.DAO.*.*(..))")
    private void forDaoPackage2(){}

    //AfterReturning metodo termina su ejecución sin errores.
    @AfterReturning(pointcut = "execution(public * findAccounts())",
    returning = "result")
    public void afterReturning(JoinPoint joinPoint, List<Account> result){
        System.out.println("\n ===========> Aspect @AfterReturn Advice on addAccount()");
        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        System.out.println(methodSignature);

        if(!result.isEmpty()){
            for(Account tempAccount: result){
                tempAccount.setName(tempAccount.getName().toUpperCase());
                tempAccount.setLastName(tempAccount.getLastName().toUpperCase());
            }
        }
    }

    @AfterThrowing(pointcut = "execution(public * findAccounts(..))",
    throwing = "exception")
    public void afterThrowing(JoinPoint jp, Throwable exception){
        System.out.println("OH NO! HA OCURRIDO UN ERROR!");
        System.out.println(jp.getSignature());
        System.out.println(exception.getMessage());
    }

    @After("execution(public * findAccounts(..))")
    public void after(JoinPoint jp){
        System.out.println("==================> @After aspect");
        System.out.println("Ha terminado la ejecución del método!!!");
    }

    //@AROUND
    //@Around("execution(public String getFortune(..))")
    //Recibe un handler del Join point que lo invoco.
    //Recibe toda la información de la llamada
    //Puede interceptar la salida.
    public Object aroundGetFortune(ProceedingJoinPoint pjp) throws Throwable{
        String method= pjp.getSignature().toShortString();
        System.out.println("\n=============> @Around Advice! surrounding " + method);
        long start= System.currentTimeMillis();

        Object result = null;
        try{
            result = pjp.proceed();
        }catch(Exception e){
            System.out.println("Oh no! " + e.getMessage());
            long end = System.currentTimeMillis();
            long duration= end - start;
            System.out.println("METHOD FINISHED. Excecution take: " + duration/1000.0 + " seconds\n");
            throw e;
        }

        long end = System.currentTimeMillis();
        long duration= end - start;
        System.out.println("METHOD FINISHED. Excecution take: " + duration/1000.0 + " seconds\n");
        return result;
    }




    //ADVICE BEFORE
    //@Before("forDaoPackage()")
    public void beforeAddAccount(JoinPoint joinPoint){
        System.out.println("\n===========> Aspect @Before Advice on addAccount()");
        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        System.out.println(methodSignature);
        Object[] args= joinPoint.getArgs();
        if(args.length>0){
            System.out.print("Argumentos: ");
        }
        for(Object arg: args){
            System.out.println(arg);
        }
    }
}
