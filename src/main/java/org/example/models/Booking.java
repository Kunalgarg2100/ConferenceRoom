package org.example.models;

public class Booking {
    private final int bookingID;
    private final User user;
    private final ConferenceRoom room;
    private final TimeSlot slot;

    public Booking(int bookingID, User user, ConferenceRoom room, TimeSlot slot ) {
        this.bookingID = bookingID;
        this.user = user;
        this.room = room;
        this.slot = slot;
    }
    public int getBookingID() {
        return bookingID;
    }

    public User getUser() {
        return user;
    }

    public ConferenceRoom getRoom() {
        return room;
    }

    public TimeSlot getSlot() {
        return slot;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", user=" + user +
                ", room=" + room +
                ", slot=" + slot +
                '}';
    }
}
