package com.hb.hotel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hb.hotel.entities.User;

public interface UserRepository extends CrudRepository <User,Integer>{

	List<User> findByFirstNameAndMobile(String firstName,String mobile);



}
