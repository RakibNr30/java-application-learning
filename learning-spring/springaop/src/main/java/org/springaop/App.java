package org.springaop;

import org.springaop.service.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        PaymentService paymentService = context.getBean("paymentService", PaymentService.class);

        // auth, print: paymentStarted
        paymentService.makePayment(1577.13);
    }
}
