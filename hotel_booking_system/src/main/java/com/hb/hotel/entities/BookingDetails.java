package com.hb.hotel.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "bookingdetails")
public class BookingDetails {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "ROOM_ID")
    private Room room_id;

    @Column(name = "date_from")
    private LocalDate date_from;

    @Column(name = "date_to")
    private LocalDate date_to;

    @Column(name = "total_price")
    private double total_price;

    public BookingDetails() {

    }

    public BookingDetails(User user, Room room_id, LocalDate date_from, LocalDate date_to, double total_price) {
        this.user = user;
        this.room_id = room_id;
        this.date_from = date_from;
        this.date_to = date_to;
        this.total_price = total_price;
    }

    @Override
	public String toString() {
		return "BookingDetails [id=" + id + ", user=" + user + ", room_id=" + room_id + ", date_from=" + date_from
				+ ", date_to=" + date_to + ", total_price=" + total_price + "]";
	}
}
