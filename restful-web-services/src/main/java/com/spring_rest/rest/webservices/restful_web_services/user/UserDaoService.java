package com.spring_rest.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1,"Shahu",LocalDate.now().minusYears(30)));
		users.add(new User(2,"Immu",LocalDate.now().minusYears(18)));
		users.add(new User(3,"Piku",LocalDate.now().minusYears(29)));
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
//	public User findOne(int id) {
//		List<User> filteredUsers = users.stream()
//		        .filter(user -> user.getId() == id)  // Condition to filter users
//		        .collect(Collectors.toList());
//		return filteredUsers[0];
//	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User save(User user) {
		user.setId(users.size() + 1);
		users.add(user);
		return user;
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		users.removeIf(predicate);
		
	}
	
}
