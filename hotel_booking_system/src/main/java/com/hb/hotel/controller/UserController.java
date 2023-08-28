package com.hb.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hb.hotel.entities.User;
import com.hb.hotel.repositories.UserRepository;
import com.hb.hotel.service.HBService;

@RestController
public class UserController {

	@Autowired
	private HBService hbService;
	@Autowired
	private UserRepository userRepository;

	@PostMapping(value = "/Registration")
	public ResponseEntity<Boolean> Registration(@RequestBody User user) {
		boolean isRegister = hbService.registration(user);
		if (isRegister) {
			return new ResponseEntity<Boolean>(isRegister, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(isRegister, HttpStatus.NOT_FOUND);

		}

	}  

	@GetMapping("/Login")
	public ResponseEntity<Integer> Login(@RequestParam String firstName, @RequestParam String mobile) {

		int UserId = hbService.login(firstName, mobile);

		// 3 display
		if (UserId > 0) {
			return new ResponseEntity<Integer>(UserId, HttpStatus.OK);
		} else {
			return new ResponseEntity<Integer>(UserId, HttpStatus.NOT_FOUND);

		}
	}

	@PutMapping(value = "/UpdateMobile")
	public ResponseEntity<Boolean> UpdateMobile(@RequestParam int userId, @RequestParam String currentMobile,
			@RequestParam String newMobile) {

		boolean isUdateMobile = hbService.updateMobile(userId, currentMobile, newMobile);

		if (isUdateMobile) {
			return new ResponseEntity<>(isUdateMobile, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(isUdateMobile, HttpStatus.NOT_FOUND);

		}

	}

	@DeleteMapping(value = "/DeleteUser/{userId}")
	public ResponseEntity<Boolean> DeleteUser(@PathVariable("userId") int userId) {
		boolean isDeleteUser = hbService.deleteUser(userId);
		if (isDeleteUser) {
			return new ResponseEntity<Boolean>(isDeleteUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(isDeleteUser, HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(value = "/getUser/{userId}")
	public ResponseEntity<User> getUser(@PathVariable int userId) {
		User getUser = hbService.getUser(userId);
		if (getUser != null) {
			return new ResponseEntity<>(getUser, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	
}
