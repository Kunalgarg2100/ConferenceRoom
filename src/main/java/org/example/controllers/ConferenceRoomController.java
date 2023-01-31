package org.example.controllers;

import org.example.models.Booking;
import org.example.models.ConferenceRoom;
import org.example.models.TimeSlot;
import org.example.service.ConferenceRoomService;

import java.util.List;

public class ConferenceRoomController {
    private static volatile ConferenceRoomController instance = null;
    ConferenceRoomService conferenceRoomService;
    public ConferenceRoomController() {
        this.conferenceRoomService = new ConferenceRoomService();
    }

    public static ConferenceRoomController getInstance(){
        synchronized (ConferenceRoomController.class){
            if( instance == null ){
                instance = new ConferenceRoomController();
            }
            return instance;
        }
    }

    public void addUser(String userID, String name ){
        conferenceRoomService.addUser( userID, name );
    }
    public void addBuilding( String buildingName, List<ConferenceRoom> rooms ){
        conferenceRoomService.addBuilding( buildingName, rooms );
    }
    public List<ConferenceRoom> findAvailableRooms(String buildingName, TimeSlot timeSlot ){
        return conferenceRoomService.findAvailableRooms(buildingName, timeSlot );
    }

    public void printConferenceRooms( ){
        conferenceRoomService.listConferenceRooms( );
    }
    public Booking bookRoom(String userID, ConferenceRoom room, TimeSlot timeSlot ){
        return conferenceRoomService.bookRoom(userID, room, timeSlot);
    }
    public List<Booking> listBookings(String userID ){
        return conferenceRoomService.listBookings(userID);
    }

    public void printConferenceRooms(List<ConferenceRoom> conferenceRooms ){
        conferenceRoomService.printConferenceRooms(conferenceRooms);
    }

    public void printBookings(List<Booking> bookings ){
        conferenceRoomService.printBookings(bookings);
    }

//    public void cancelBooking(String userID, Booking booking ){
//        User user = users.get(userID);
//
//        return conferenceRoomService.bookRoom(user, room, timeSlot);
//    }

}
