package com.GymManagement.gym.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GymManagement.gym.Entity.User;
import com.GymManagement.gym.Model.UserModel;
import com.GymManagement.gym.Service.UserService;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "/create" , method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@Valid @RequestBody UserModel userModel , BindingResult bindingResult ){
		if(bindingResult.hasErrors()) {
			Map<String,String> errors = new HashMap<String,String>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errors.put(error.getField() , error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
		}
		User user = userService.createUser(userModel);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/login" , method = RequestMethod.POST)
	public ResponseEntity<?> loginUser(@RequestParam String userName , @RequestParam String password){
		System.out.println(userName);
		if(userName.equals("") || userName == null
				|| password.equals("") || password == null) {
			return new ResponseEntity<String>("invalid credentials",HttpStatus.BAD_REQUEST);
		}
		User user = userService.login(userName , password);
		
		return new ResponseEntity<User>(user , HttpStatus.OK);
	}
	
	@RequestMapping(path = "/get" , method = RequestMethod.GET)
	public ResponseEntity<?> getUserByName(@RequestParam String userName){
		User user = userService.getUserByUserName(userName);
		if(user == null) {
			return new ResponseEntity<String>("User Not Found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user,HttpStatus.FOUND);
	}
	
	@RequestMapping(path = "/getAllUsers" , method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers(){
		List<User> users = userService.getAllUser();
		if(users.size() < 1) {
			return new ResponseEntity<String>("No Record found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/get/{userId}" , method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@PathVariable Long userId){
		User user = userService.getUserByUserId(userId);
		if(user == null) {
			return new ResponseEntity<String>("User Not Found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user,HttpStatus.FOUND);
	}
	
//	@RequestMapping(path = "/updateUser/{id}" , method = RequestMethod.PUT)
//	public ResponseEntity<?> updateUser(@RequestBody UserModel userModel, @PathVariable Long id){
//		User user = userService.
//	}
}
