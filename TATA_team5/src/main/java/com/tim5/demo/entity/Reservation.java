package com.tim5.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "users_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users users;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "hotel_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Hotel hotel;

    public Reservation(Users users, Hotel hotel) {
        this.users = users;
        this.hotel = hotel;
    }

    public Reservation() {
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
