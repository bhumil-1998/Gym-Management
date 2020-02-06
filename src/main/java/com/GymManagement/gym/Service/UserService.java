package com.GymManagement.gym.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GymManagement.gym.Entity.User;
import com.GymManagement.gym.Model.UserModel;
import com.GymManagement.gym.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(UserModel userModel) {
		User newUser = null;
		try {
			newUser = userRepository.save(new User(null,userModel.getUserName()
					,userModel.getFullName(),userModel.getEmailid()
					,userModel.getContactno(),userModel.getPassword()
					,userModel.getCreatedBy(),userModel.getCreatedDate()
					,false, userModel.getUserType()));
			if(newUser == null) {
				throw new Exception("User Cannot Created");
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return newUser;	
	}
	
	public User getUserByUserName(String userName) {
		User user = null;
		try {
			user = userRepository.findByUserName(userName);
			if(user == null) {
				throw new Exception("User doesn't exists");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
	
	public List<User> getAllUser(){
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public User login(String userName, String password) {
		User checkUser = null;
//		System.out.println(userModel.toString());
		
		try {
			checkUser = userRepository.checkLogin(userName
					, password);
			if(checkUser == null)
				throw new Exception("User doesn't exist");
			return checkUser;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return checkUser;
	}

	public User getUserByUserId(Long userId) {
		Optional<User> user = null;
		try {
			user = userRepository.findById(userId);
			if(user == null) {
				throw new Exception("User doesn't exists");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return user.get();
	}
//	public User updateUser(UserModel userModel , Long id) {
//		User user = getUserByUserId(id);
//		user.setContactno(userModel.getContactno());
//		user.setEmailid(userModel.getEmailid());
//		user.setPassword(userModel.getPassword());
//		user.setFullName(userModel.);
//	}
}
