package com.rest.webservice.restfulwebservice.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 0;
	
	static {
		users.add(new User(++userCount,"Paco Germela",LocalDate.now().minusYears(20)));
		users.add(new User(++userCount,"Elver Galaraga",LocalDate.now().minusYears(10)));
		users.add(new User(++userCount,"Rosa Melano",LocalDate.now().minusYears(12)));
	}
			
	public List<User> findAll(){
		return users;
	}
	public User findOne(int id) {
		
		for (User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
		
	}
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	public boolean delete(int id) {
		for (User user : users) {
			if(user.getId() == id) {
				int index = users.indexOf(user);
				users.remove(index);
				return true;
			}
		}
		return false;
	}
	public User update(User user) {
		for (User userTarget : users) {
			if(user.getId() == userTarget.getId()) {
				userTarget.setbDay(user.getbDay());
				userTarget.setName(user.getName());
				return userTarget;
			}
		}
		return null;
	
	}
}
