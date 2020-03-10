package com.galvanize;

import com.galvanize.formatters.JSONFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookingTest {
    Booking booking;
    Booking booking2;
    Booking booking3;
    Booking booking4;
    Booking.RoomType roomTypeR;
    Booking.RoomType roomTypeS;
    Booking.RoomType roomTypeA;
    Booking.RoomType roomTypeC;
    String roomNumber;
    String startTime;
    String endTime;

    @BeforeEach
    public void Setup(){
        //Setup
        roomTypeR = Booking.RoomType.r;
        roomTypeS = Booking.RoomType.s;
        roomTypeA = Booking.RoomType.a;
        roomTypeC = Booking.RoomType.c;
        roomNumber = "100";
        startTime = "10:00AM";
        endTime = "10:30AM";
        booking = new Booking(roomTypeR, roomNumber, startTime, endTime );
        booking2 = new Booking(roomTypeS, roomNumber, startTime, endTime );
        booking3 = new Booking(roomTypeA, roomNumber, startTime, endTime );
        booking4 = new Booking(roomTypeC, roomNumber, startTime, endTime );

    }

//    Booking Class
//    A constructor that takes 4 arguments:
//    Room Type (an enum value)
//    Room Number (a String)
//    Start Time (a String)
//    End Time (a String)
    @Test
    public void TestBookingValueConstructor() {
        //Setup
        Booking myBooking = new Booking(roomTypeR, roomNumber, startTime, endTime );
        //Exercise
        Boolean areBookingsEqual = booking.CompareTo(myBooking);
        //Assert
        assertTrue(areBookingsEqual);
        //Teardown
    }

//    Getters for all 4 fields
    @Test
    public void TestGetters() {
        //Setup
        //Exercise
        Booking.RoomType getterRoomType = booking.getRoomType();
        String getterRoomNumber = booking.getRoomNumber();
        String getterStartTime = booking.getStartTime();
        String getterEndTime = booking.getEndTime();
        //Assert
        assertEquals(getterRoomType , roomTypeR);
        assertEquals(getterRoomNumber , roomNumber);
        assertEquals(getterStartTime , startTime);
        assertEquals(getterEndTime , endTime);
        //Teardown
    }


//    In the main com.galvanize package you should define a class named Booking, and the Booking class should have 4 parts:
//
//    A nested enum that represents the 4 Room Types
    @Test
    public void TestBookingEnumR() {
        //Setup
        //Exercise
        String roomType = booking.getRoomType().ToString();
        String actual = Booking.RoomType.r.label;
        //Assert
        assertEquals(roomType, actual);
        //Teardown
    }

    @Test
    public void TestBookingEnumS() {
        //Setup
        //Exercise
        String roomType = booking2.getRoomType().ToString();
        String actual = Booking.RoomType.s.label;
        //Assert
        assertEquals(roomType, actual);
        //Teardown
    }

    @Test
    public void TestBookingEnumA() {
        //Setup
        //Exercise
        String roomType = booking3.getRoomType().ToString();
        String actual = Booking.RoomType.a.label;
        //Assert
        assertEquals(roomType, actual);
        //Teardown
    }

    @Test
    public void TestBookingEnumC() {
        //Setup
        //Exercise
        String roomType = booking4.getRoomType().ToString();
        String actual = Booking.RoomType.c.label;
        //Assert
        assertEquals(roomType, actual);
        //Teardown
    }

    
//    A static method named .parse that:
//    takes in a booking code
//    returns an instance of Booking object
    @Test
    public void TestParseBookingCode() {
        //Setup
        String bookingCode = "a111-08:30am-11:00am";
        Booking myBooking = Booking.parse(bookingCode);
        Booking.RoomType roomType = myBooking.getRoomType();
        //Exercise
        //Assert
        assertEquals(roomType , roomTypeA);
        //Teardown
    }




}
