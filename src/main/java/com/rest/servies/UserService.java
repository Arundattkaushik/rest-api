package com.rest.servies;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.dao.Repository;
import com.rest.entities.User;

@Service
public class UserService {
	@Autowired
	private User user;
	@Autowired
	private Repository repository;


	public User createUser(User user) {
		return this.repository.save(user);
	}

	public List<User> getUsers() {
		List<User> users = (List<User>) this.repository.findAll();
		return users;
	}

	public User getAUser(int indx) {
		user = null;
		try {
			user = this.repository.findById(indx).get();
			return user;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	public String deleteUser(int index) {
		this.repository.deleteById(index);;
		return "deleted successfully";
	}

	public User updateUser(User u, int id) {
		
		User user =  this.repository.findById(id).get();
		if (u.getEmail() !=null) {
			user.setEmail(u.getEmail());
		}
		if (u.getMobile() != null) {
			user.setMobile(u.getMobile());
		}
		if (u.getName() != null) {
			user.setName(u.getName());
		}
		user.setId(id);
		
		return this.repository.save(user);

	}
}
