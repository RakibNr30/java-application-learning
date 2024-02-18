package com.security.config;

import com.security.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /* first: we need to understand this config */
    /*@Bean
    public UserDetailsManager getUserDetailsManager() {
        List<GrantedAuthority> grantedAuthorities1 = new ArrayList<>();
        grantedAuthorities1.add(new SimpleGrantedAuthority("admin"));
        grantedAuthorities1.add(new SimpleGrantedAuthority("user"));

        List<GrantedAuthority> grantedAuthorities2 = new ArrayList<>();
        grantedAuthorities2.add(new SimpleGrantedAuthority("user"));

        UserDetails admin = new AppUser("admin", "admin", grantedAuthorities1);
        UserDetails user = new AppUser("user", "user", grantedAuthorities2);

        UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(admin);
        userDetailsManager.createUser(user);

        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }*/

    /* second: we need to understand this config */

    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsManager getUserDetailsManager() {
         UserDetails admin =
                 AppUser
                         .withUsername("admin")
                         //.password("{noop}admin")
                         //.password("{bcrypt}$2a$10$g2DJByAylmAbVrzhUVEYJed9paS/K6TcgCSSdF0HyD9jvqhlYT4Qq")
                         .password("$2a$10$g2DJByAylmAbVrzhUVEYJed9paS/K6TcgCSSdF0HyD9jvqhlYT4Qq")
                         .roles("admin", "user")
                         .build();

         UserDetails user =
                 AppUser
                         .withUsername("user")
                         //.password("${noop}user")
                         //.password("{bcrypt}$2a$10$1NE05R.yJVwKH8qUTpVC0ui9yx/AkV8YPxIN0rFg8YEZpPd.NG3/q")
                         .password("$2a$10$1NE05R.yJVwKH8qUTpVC0ui9yx/AkV8YPxIN0rFg8YEZpPd.NG3/q")
                         .roles("user")
                         .build();

         //return new InMemoryUserDetailsManager(admin, user);

        UserDetailsManager users = new JdbcUserDetailsManager(this.dataSource);
        /*users.createUser(admin);
        users.createUser(user);*/

        return users;
    }

    /* setting up http security  */

    @Bean
    public SecurityFilterChain setSttpSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/signup", "/handle-signup").permitAll()
                        .requestMatchers("/**").hasRole("ADMIN")
                        .requestMatchers("/coder").hasRole("CODER")
                        .requestMatchers("/trainer").hasRole("TRAINER")
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/handle-login")
                        .permitAll()
                )
                .logout(Customizer.withDefaults())
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/access-denied")
                )
                .build();
    }

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
