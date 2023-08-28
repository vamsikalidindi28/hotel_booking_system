package com.hb.hotel.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hb.hotel.entities.Room;
import com.hb.hotel.entities.User;
import com.hb.hotel.repositories.RoomRepository;
import com.hb.hotel.repositories.UserRepository;
import com.hb.hotel.service.HBService;

@Service
public class HBServiceImpl implements HBService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoomRepository roomRepository;

	@Transactional
	@Override
	public boolean registration(User user) {
		return userRepository.save(user).getUser_id() > 0;
	}

	@Transactional
	@Override
	public boolean saveRoom(Room room) {
		return roomRepository.save(room).getRoomId() > 0;
	}

	@Override
	public int login(String firstName, String mobile) {
		List<User> users = userRepository.findByFirstNameAndMobile(firstName, mobile);
		if (users != null && !users.isEmpty()) {
			return users.get(0).getUser_id();

		}
		return 0;
	}

	@Transactional
	@Override
	public boolean updateMobile(int userId, String currentMobile, String newMobile) {

		User user = getUser(userId);

		if (currentMobile.equals(user.getMobile())) {
			user.setMobile(newMobile);
			return registration(user);
		}
		return false;
	}

	@Override
	public User getUser(int userId) {
		Optional<User> optionalObject = userRepository.findById(userId);
		if (optionalObject.isPresent()) {
			User user = optionalObject.get();
			if (user.getRoom() == null) {
				user.setRoom(null);
			}
			return user;
		}
		return null;
	}

	@Transactional
	@Override
	public boolean deleteUser(int userId) {
		try {
			userRepository.deleteById(userId);
			return true;
		} catch (Exception e) {
			return false;

		}

	}

	@Override
	public Room getRoom(int roomId) {
		return roomRepository.findById(roomId).get();

	}

}
