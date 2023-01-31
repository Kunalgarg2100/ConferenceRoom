package org.example.models;

import java.time.LocalTime;

public class TimeSlot {
    private final LocalTime start;
    private final LocalTime end;
    public TimeSlot(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }
    public LocalTime getStartTime(){
        return start;
    }
    public LocalTime getEndTime() {
        return end;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
