package com.springcore.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpEL {
    public static void main(String[] args) {
        ApplicationContext context = new  ClassPathXmlApplicationContext("spELConfig.xml");

        Student student = context.getBean("student", Student.class);
        System.out.println(student);

        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("20 + 40");
        System.out.println(expression.getValue());
        System.out.println(parser.parseExpression("20 + 50").getValue());

    }
}
