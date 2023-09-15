package com.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect // 标识这是一个切面类
public class InvokeLogAspect {

    // 确定切点
    @Pointcut("@annotation(com.springboot.aop.InvokeLog)")
    public void pt(){}

    @Around("pt()")
    public Object printInvokeLog(ProceedingJoinPoint joinPoint) {
        Object proceed = null;
        // 目标方法调用前
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        System.out.println(methodName + "+++即将执行+++");
        try {
            proceed = joinPoint.proceed();

            // 目标方法调用后
            System.out.println(methodName + "===执行完毕===");
        } catch (Throwable e) {
            // 目标方法出现异常后
            System.out.println(methodName + "###出现了异常###");
        }
        return proceed;
    }
}
