package com.hb.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hb.hotel.entities.Room;
import com.hb.hotel.entities.User;
import com.hb.hotel.service.HBService;

@RestController
public class RoomController {

	@Autowired
	private HBService hbService;
	@PostMapping(value ="/SaveRoom")
	public ResponseEntity<Boolean> SaveRoom(@RequestBody Room room){
		boolean isSaveroom = hbService.saveRoom(room);
		if (isSaveroom) {
			return new ResponseEntity<Boolean>(isSaveroom, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(isSaveroom, HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(value = "/GetRoom/{roomId}")
	public ResponseEntity<Room> GetRoom(@PathVariable int roomId){
		Room getRoom = hbService.getRoom(roomId);
		if (getRoom != null) {
			return new ResponseEntity<>(getRoom, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

}
