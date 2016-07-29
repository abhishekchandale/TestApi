package com.example.apis;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserDao;
import com.example.repository.UserRepository;
import com.example.request.LoginRequest;
import com.example.response.LoginRes;
import com.example.response.LoginResponse;
import com.example.response.MessageResponse;
import com.example.response.SuperResponse;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
@Produces(MediaType.APPLICATION_JSON)

public class UsersAPI {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody List<UserDao> getAllUsers() {
		return userRepository.findAll();
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody SuperResponse getOne(@RequestBody LoginRequest req) {
		try {
			UserDao foundUser = null;
			//LoginRes loginRes=null;
			for (UserDao user : getAllUsers()) {
				if (user.getEmail().trim().equalsIgnoreCase(req.getEmail().trim())) {
					foundUser = user;
					break;
				}
			}
			if (foundUser == null)
				return new MessageResponse("Invalid Username");
			else {
				if (foundUser.getPassword().equals(req.getPassword())) {
					final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				    System.out.println("uuid = " + uuid);
				    foundUser.setRandomId(uuid);
					return new LoginRes("", uuid);
				} else {
					return new MessageResponse("Invalid Password");
				}
			}
		} catch (Exception e) {
			return new MessageResponse("Error Finding User:" + e.getMessage());
		}

	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody SuperResponse getOne(@PathVariable("id") long id) {
		try {
			if (userRepository.exists(id)) {
				return userRepository.findOne(id);
			} else {
				return new MessageResponse("User Not Found");
			}
		} catch (Exception ex) {
			return new MessageResponse("Error reading the user:" + ex.toString());
		}
	}


	@RequestMapping(method = RequestMethod.POST, value = "/addorupdate")
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody SuperResponse createOrUpdate(@RequestBody UserDao users) {
		UserDao foundUser=null;
		for (UserDao user : getAllUsers()) {
			if (user.getEmail().trim().equalsIgnoreCase(users.getEmail().trim())) {
				foundUser = user;
				break;
			}
		}
	
		if(foundUser==null){
			try{
				final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			    System.out.println("uuid = " + uuid);
			     foundUser=users;
			     foundUser.setRandomId(uuid);
			     userRepository.save(foundUser);
				return new LoginRes("Registration successfully !",uuid);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		return new MessageResponse("EmailID Already Exists");
	}

	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody SuperResponse delete(@PathVariable("id") long id) {
		try {
			if (userRepository.exists(id)) {
				userRepository.delete(id);
				return new MessageResponse("User Deleted");
			} else {
				return new MessageResponse("User Not Found");
			}
		} catch (Exception ex) {
			return new MessageResponse("Error deleting the user:" + ex.toString());
		}
	}
}
