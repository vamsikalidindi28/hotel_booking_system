package com.hb.hotel.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hb.hotel.entities.BookingDetails;

public interface BookingDetailsRepository extends CrudRepository<BookingDetails,Integer> {

}
