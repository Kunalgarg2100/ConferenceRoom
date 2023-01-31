package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class ConferenceRoom {
    private final String name;
    private final int capacity;
    private final List<TimeSlot> bookedTimeSlots;
    public ConferenceRoom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        bookedTimeSlots = new ArrayList<>();
    }
    public String getName(){
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable( TimeSlot timeSlot ){
        if(bookedTimeSlots.contains(timeSlot))
            return false;
        return true;
    }

    public boolean bookTimeSlot(TimeSlot timeSlot) {
        if(!bookedTimeSlots.contains(timeSlot)){
            bookedTimeSlots.add(timeSlot);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ConferenceRoom{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", bookedTimeSlots=" + bookedTimeSlots +
                '}';
    }
}
