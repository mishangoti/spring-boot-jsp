package com.jpa.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJspApplication.class, args);
//		
//		UserRepository userRepository = context.getBean(UserRepository.class);
//		
//		User user = new User();
//		user.setName("Goti");
//		user.setCity("Canada");
//		user.setStatus("developer");
//		
//		User user1 = userRepository.save(user);
//		System.out.println(user1);
//		
//		List<User> allUser = userRepository.getAllUser();
//		allUser.forEach(e -> {
//			System.out.println(e);
//		});
//		
//		List<User> userByName = userRepository.getUserByName("Goti");
//		userByName.forEach(e -> {
//			System.out.println(e);
//		});
//		
//		List<User> getUsers = userRepository.getUsers();
//		getUsers.forEach(e -> {
//			System.out.println(e);
//		});
//		System.out.println("test");
	
	}

}
