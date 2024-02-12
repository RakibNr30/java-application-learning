package org.springaop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PaymentAspect {

    /* Before Advice */
    @Before("execution(* org.springaop.service.PaymentServiceImpl.makePayment(..))") /* inner pattern is point cut. (..) for param(s) */
    public void printBefore() {
        System.out.println("Payment Started...");
    }

    /* After Advice */
    @After("execution(* org.springaop.service.PaymentServiceImpl.makePayment(..))") /* inner pattern is point cut. (..) for param(s) */
    public void printAfter() {
        System.out.println("Payment Done...");
    }
}
