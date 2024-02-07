package com.springorm;

import com.springorm.entity.User;
import com.springorm.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static UserRepository userRepository;

    public static void main( String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        userRepository = context.getBean("userRepository", UserRepository.class);

        /*User user = new User();
        user.setName("Full Name");
        user.setEmail("email@example.com");
        user.setAddress("Dhaka");

        int result = userRepository.save(user);
        System.out.println("saved : " + result);*/

        /*User user = userRepository.get(1);
        System.out.println(user);*/

        /*List<User> users = userRepository.getAll();
        for (User user: users) {
            System.out.println(user);
        }*/

        /*User user = new User();
        user.setId(2);
        user.setName("Full Name 01");
        user.setEmail("email01@example.com");
        user.setAddress("Dhaka 01");

        userRepository.update(user);
        System.out.println("updated");*/

        /*userRepository.delete(2);
        System.out.println("deleted");*/

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean loop = true;

        while (loop) {
            System.out.println("Press 1 for display all user");
            System.out.println("Press 2 for add new user");
            System.out.println("Press 3 for display single user");
            System.out.println("Press 4 for update user");
            System.out.println("Press 5 for delete user");
            System.out.println("Press 6 for exit");

            try {
                int option = Integer.parseInt(bufferedReader.readLine());

                switch (option) {
                    case 1:
                        /* for display all user */
                        showAllUser();
                        break;
                    case 2:
                        addUser();
                        /* for add new user */
                        break;
                    case 3:
                        /* for display single user */
                        showUser();
                        break;
                    case 4:
                        /* for update user */
                        updateUser();
                        break;
                    case 5:
                        /* for delete user*/
                        deleteUser();
                        break;
                    case 6:
                        loop = false;
                        /* for exit */
                        break;
                    default:
                        break;
                }

            } catch (Exception e) {
                System.err.println("Invalid option! Please try again.");
                System.err.println(e.getMessage());
            }
        }

        System.out.println("Thanks!");
    }

    private static void showAllUser() {
        List<User> users = userRepository.getAll();

        System.out.println("***********************************************");
        System.out.println("User List:");
        if (!users.isEmpty()) {
            for (User user: users) {
                System.out.println(user);
            }
        } else {
            System.err.println("No user found.");
        }
        System.out.println("***********************************************");
    }

    private static void addUser() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter Name: ");
        String name = bufferedReader.readLine();

        System.out.print("Enter E-mail: ");
        String email = bufferedReader.readLine();

        System.out.print("Enter Address: ");
        String address = bufferedReader.readLine();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAddress(address);
        userRepository.save(user);

        System.out.println("***********************************************");
        System.out.println("User added successfully.");
        System.out.println("***********************************************");
    }

    private static void showUser() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter Id: ");
        int id = Integer.parseInt(bufferedReader.readLine());
        User user = userRepository.get(id);

        System.out.println("***********************************************");
        System.out.println("User View:");
        if (user != null) {
            System.out.println(user);
        } else {
            System.err.println("User not found.");
        }
        System.out.println("***********************************************");
    }

    private static void updateUser() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter Id: ");
        int id = Integer.parseInt(bufferedReader.readLine());
        User user = userRepository.get(id);

        System.out.println("***********************************************");
        System.out.println("User Update:");
        if (user != null) {
            System.out.print("Enter Name: ");
            String name = bufferedReader.readLine();

            System.out.print("Enter E-mail: ");
            String email = bufferedReader.readLine();

            System.out.print("Enter Address: ");
            String address = bufferedReader.readLine();

            user.setName(name);
            user.setEmail(email);
            user.setAddress(address);

            userRepository.update(user);
            System.out.println("User updated successfully.");
        } else {
            System.err.println("User not found.");
        }
        System.out.println("***********************************************");

    }

    private static void deleteUser() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter Id: ");
        int id = Integer.parseInt(bufferedReader.readLine());
        User user = userRepository.get(id);

        System.out.println("***********************************************");
        System.out.println("User Delete:");
        if (user != null) {
            userRepository.delete(id);
            System.out.println("User deleted successfully.");
        } else {
            System.err.println("User not found.");
        }
        System.out.println("***********************************************");
    }
}
