package com.boot.jpa;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.boot.jpa.dao.UserRepository;
import com.boot.jpa.entity.User;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJpaApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		User user = new User();
		user.setName("Rahul");
		user.setCity("Guwahati");
		
		// Save a single user
		User save = userRepository.save(user);
		System.out.println(save);
		
		
		User user1 = new User();
		user1.setName("Sudemshri");
		user1.setCity("Guwahati");
				
		User user2 = new User();
		user2.setName("Sumi");
		user2.setCity("Delhi");
		
		List<User> list = List.of(user1, user2);
		Iterable<User> iterable = userRepository.saveAll(list);  
		
		iterable.forEach(u->{
			System.out.println(u);
		});
		
		
		//update the user of id 2
		
//		Optional<User> findById = userRepository.findById(2);
//		User user = findById.get();		
//		user.setName("Sudemshri");	
//		userRepository.save(user);
		
		
		//Get data from database
		
//		Iterable<User> itr = userRepository.findAll();
		
//		Iterator<User> iterator = itr.iterator();		
//		while(iterator.hasNext()) {
//			User u = iterator.next();
//			System.out.println(u);
//		}
		
//		itr.forEach(user->System.out.println(user));
//		//itr.forEach(user->{System.out.println(user);});
		
		
		// Delete from Database
		
//		userRepository.deleteById(2);
		
//		Iterable<User> findAll = userRepository.findAll();
//		userRepository.deleteAll(findAll);
				
	}

}
