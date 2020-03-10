package com.galvanize;

import java.util.HashMap;
import java.util.Map;


public class Booking {
    private final RoomType roomType;
    private final String roomNumber;
    private final String startTime;
    private final String endTime;


    // constructors

    public Booking (String roomType, String roomNumber, String startTime, String endTime){
        this.roomType = RoomType.valueOf(roomType);
        this.roomNumber = roomNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Booking (RoomType roomType, String roomNumber, String startTime, String endTime){
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Booking() {
        this.roomType = RoomType.r;
        this.roomNumber = "";
        this.startTime = "";
        this.endTime = "";
    }



    // getters and setters


    public RoomType getRoomType() {
        return this.roomType;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getRoomNumber() {
        return  this.roomNumber;
    }


    // nested classes


    //https://www.baeldung.com/java-enum-values
    public enum RoomType {
        r("Conference Room"),
        s("Suite"),
        a("Auditorium"),
        c("Classroom");

        public final String label;

        private RoomType(String label) {
            this.label = label;
        }

        public String ToString() {
            return this.label;
        }

    }


    // comparing


    public Boolean CompareTo(Booking newBooking) {
        String newRoomType = newBooking.getRoomType().ToString();
        String newRoomNumber = newBooking.getRoomNumber();
        String newStartTime = newBooking.getStartTime();
        String newEndTime = newBooking.getEndTime();
        if (
                (0 == newRoomType.compareTo(this.getRoomType().ToString())) &&
                        (0 == newRoomNumber.compareTo(this.getRoomNumber())) &&
                        (0 == newStartTime.compareTo(this.getStartTime())) &&
                        (0 == newEndTime.compareTo(this.getEndTime()))
        ) {
            return true;
        }
        return false;
    }


    // parsing


    public static Booking parse(String bookingCode) {
        if(bookingCode != "" && bookingCode != null && bookingCode.length() > 0){
            return doParse(bookingCode);
        }
        return new Booking();
    }

    public static Booking doParse (String bookingCode){
        String roomType = bookingCode.substring(0, 1);
        String remainingString = bookingCode.substring(1, bookingCode.length());
        String[] parts = remainingString.split("-");
        String roomNumber = parts[0];
        String startTime = parts[1];
        String endTime = parts[2];
        Booking newBooking = new Booking(roomType, roomNumber, startTime, endTime);
        return newBooking;

    }

}
