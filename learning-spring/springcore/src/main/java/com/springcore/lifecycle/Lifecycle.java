package com.springcore.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lifecycle {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("lifecycleConfig.xml");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("lifecycleConfig.xml");

        XmlLifecycleProduct xmlLifecycleProduct1 = (XmlLifecycleProduct) context.getBean("xmlLifecycleProduct1");
        System.out.println(xmlLifecycleProduct1);
        context.registerShutdownHook();

        System.out.println("==============================");

        InterfaceLifecycle interfaceLifecycle1 = (InterfaceLifecycle) context.getBean("interfaceLifecycle1");
        System.out.println(interfaceLifecycle1);

        System.out.println("=============================");
        AnnotationLifecycle annotationLifecycle1 = (AnnotationLifecycle) context.getBean("annotationLifecycle1");
        System.out.println(annotationLifecycle1);
    }
}
