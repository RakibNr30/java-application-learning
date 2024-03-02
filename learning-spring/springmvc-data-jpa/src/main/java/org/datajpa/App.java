package org.datajpa;

import org.datajpa.config.AppConfig;
import org.datajpa.entity.Student;
import org.datajpa.repository.StudentRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        StudentRepository studentRepository = context.getBean("studentRepository", StudentRepository.class);

        Student student = new Student();
        student.setName("Abdur Rakib");
        student.setMobile("01710115566");
        student.setAddress("Mymensingh");

        studentRepository.save(student);

        studentRepository
                .findAll()
                .forEach(System.out::println);
    }
}
