package com.springjdbc;

import com.springjdbc.config.JdbcConfig;
import com.springjdbc.entity.User;
import com.springjdbc.repository.UserRepository;
import com.springjdbc.repository.UserRowMapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");*/

        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        UserRepository userRepository = context.getBean("userRepository", UserRepository.class);

        /*User user = new User();
        user.setId(2);
        user.setName("Full Name 02");
        user.setName("email2@example.com");
        user.setName("Dhaka 02");

        int result = userRepository.insert(user);
        System.out.println("User inserted : " + result);*/

        /*User user = new User();
        user.setId(7);
        user.setName("Full Name 07");
        user.setEmail("email7@example.com");
        user.setAddress("Dhaka 07");

        int result = userRepository.update(user);
        System.out.println("User updated : " + result);*/

        /*int result = userRepository.delete(7);
        System.out.println("User deleted : " + result);*/

        /*User user = userRepository.get(1);
        System.out.println("User : " + user);*/

        List<User> users = userRepository.getAll();
        for (User user: users) {
            System.out.println("User : " + user);
        }
    }
}
