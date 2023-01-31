package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private final String name;
    private final List<ConferenceRoom> rooms = new ArrayList<>();

    public Building(String name){
        this.name = name;
    }

    public void addRoom(ConferenceRoom room){
        rooms.add(room);
    }
    public String getName(){
        return name;
    }
    public List<ConferenceRoom> getRooms(){
        return rooms;
    }

    @Override
    public String toString() {
        return "Building{" +
                "name='" + name + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
