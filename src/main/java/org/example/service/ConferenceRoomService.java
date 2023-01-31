package org.example.service;

import org.example.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConferenceRoomService {
    private final HashMap<Building, List<ConferenceRoom> > rooms;
    private final HashMap<String, User> users;
    private final HashMap<String, Building> buldings;
    private final List<Booking> bookings;

    public ConferenceRoomService() {
        this.rooms = new HashMap<>();
        this.users = new HashMap<>();
        this.buldings = new HashMap<>();
        this.bookings = new ArrayList<>();
    }
    public void addUser(String userID, String name ){
        if( !users.isEmpty() && !users.containsKey(userID) ){
            users.put( userID, new User(userID, name) );
        }
        else if( users.isEmpty() ){
            users.put( userID, new User(userID, name) );
        }
        else{

        }
    }
    public void addBuilding(String buildingName, List<ConferenceRoom> conferenceRooms ){
        Building building = new Building(buildingName);
        rooms.put( building, conferenceRooms );
        buldings.put( buildingName, building );
    }

    public void listConferenceRooms( ){
        rooms.forEach((building, conferenceRooms) -> {
            System.out.println( building.getName() + " has rooms : ");
            for( ConferenceRoom room : conferenceRooms ){
                System.out.println("\t" + room.getName() );
            }
        });
    }
    public List<ConferenceRoom> findAvailableRooms( String buildingName, TimeSlot timeSlot ){
        Building building = buldings.get(buildingName);
        List<ConferenceRoom> availableRooms = new ArrayList<>();
        List<ConferenceRoom> allRooms = rooms.get(building);
        for( ConferenceRoom room : allRooms ){
            if(room.isAvailable(timeSlot)){
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public int getNextBookingId(){
        return bookings.size() + 1;
    }

    public Booking bookRoom(String userID, ConferenceRoom room, TimeSlot timeSlot ){
        User user = users.get(userID);
        if( user!= null && room.bookTimeSlot( timeSlot) ){
            int bookingID = getNextBookingId();
            Booking booking = new Booking( bookingID, user, room, timeSlot );
            bookings.add(booking);
            user.addBooking(booking);
            System.out.println("Room booked successfully");
            return booking;
        }
        return null;
    }

    public List<Booking> listBookings( String userID ){
        User user = users.get(userID);
        if(user != null ){
            return user.getBookings();
        }
        return null;
    }

    public void printConferenceRooms(List<ConferenceRoom> conferenceRooms ){
        System.out.println("Available Rooms are :");
        for( ConferenceRoom room : conferenceRooms ) {
            System.out.println("\t" + room.getName());
        };
    }

    public void printBookings(List<Booking> bookings ){
        System.out.println("Bookings are :");
        for( Booking booking : bookings ) {
            System.out.println( booking.getBookingID()  + " " + booking.getUser().getId() + " " + booking.getRoom().getName()
                    + " " +  booking.getSlot() );
        };
    }

//    public void cancelBooking(String userID, Booking booking ){
//        User user = users.get(userID);
//        if( user != null ){
//            user.removeBooking(booking);
//            booking.getRoom()
//        }
//    }
}
