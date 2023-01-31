package org.example.models;

import org.example.models.Booking;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private final String name;
    private List<Booking> bookings;

    public User(String id, String name ) {
        this.id = id;
        this.name = name;
        this.bookings = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking( Booking booking ){
        bookings.add(booking);
    }

    public void cancelBooking( Booking booking ){
        bookings.remove(booking);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bookings=" + bookings +
                '}';
    }
}
