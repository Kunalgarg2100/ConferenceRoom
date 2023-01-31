package org.example;

import org.example.controllers.ConferenceRoomController;
import org.example.models.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConferenceRoomController conferenceRoomController = ConferenceRoomController.getInstance();
        conferenceRoomController.addUser("u1", "User1" );
        conferenceRoomController.addUser("u2", "User2" );

        ConferenceRoom conferenceRoom1 = new ConferenceRoom("c1", 10);
        ConferenceRoom conferenceRoom2 = new ConferenceRoom("c2", 10);
        List<ConferenceRoom> conferenceRoomList1 = new ArrayList<>();
        conferenceRoomList1.add( conferenceRoom1 );
        conferenceRoomList1.add( conferenceRoom2 );

        conferenceRoomController.addBuilding("Building A", conferenceRoomList1 );
        ConferenceRoom conferenceRoom3 = new ConferenceRoom("c1", 10);
        ConferenceRoom conferenceRoom4 = new ConferenceRoom("c2", 10);
        List<ConferenceRoom> conferenceRoomList2 = new ArrayList<>();
        conferenceRoomList2.add( conferenceRoom3 );
        conferenceRoomList2.add( conferenceRoom4 );
        conferenceRoomController.addBuilding("Building B", conferenceRoomList2 );

        conferenceRoomController.printConferenceRooms();

        TimeSlot timeSlot =  new TimeSlot(LocalTime.of(10,00), LocalTime.of(11,00) );
        List<ConferenceRoom> availableRooms = conferenceRoomController.findAvailableRooms("Building B", timeSlot );
        conferenceRoomController.printConferenceRooms( availableRooms );


        ConferenceRoom roomToBook = availableRooms.get(0);
        conferenceRoomController.bookRoom(f"u1", roomToBook, timeSlot );

        availableRooms = conferenceRoomController.findAvailableRooms("Building B", timeSlot );
        conferenceRoomController.printConferenceRooms( availableRooms );

        List <Booking> bookings = conferenceRoomController.listBookings( "u1" );
        conferenceRoomController.printBookings( bookings );
    }
}