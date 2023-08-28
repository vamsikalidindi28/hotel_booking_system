package com.hb.hotel.service;

import com.hb.hotel.entities.Room;
import com.hb.hotel.entities.User;

public interface HBService {
	boolean registration(User user);

	int login(String firstName, String mobile);

	boolean updateMobile(int userId, String currentMobile, String newMobile);

	User getUser(int userId);
	
	boolean deleteUser(int userId);

	boolean saveRoom(Room room);
	
	Room getRoom(int roomId);
}
