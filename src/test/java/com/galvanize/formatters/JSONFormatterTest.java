package com.galvanize.formatters;

import com.galvanize.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSONFormatterTest {

    JSONFormatter formatter;
    Booking booking;
    Booking.RoomType roomType = Booking.RoomType.r;
    String roomNumber = "111";
    String startTime = "08:30am";
    String endTime = "11:00am";

    String hardCodedBookingInformation =
            "{\n" +
                    "  \"type\": \"" + roomType.ToString() + "\",\n" +
                    "  \"roomNumber\": " + roomNumber + ",\n" +
                    "  \"startTime\": \"" + startTime + "\",\n" +
                    "  \"endTime\": \"" + endTime + "\"\n" +
                    "}" ;


    @BeforeEach
    public void Setup() {
        formatter = new JSONFormatter();
    }

    @Test
    public void TestCreateObject() {
        //Setup
        booking = new Booking(roomType, roomNumber, startTime, endTime);
        //Exercise
        String bookingInformation = formatter.format(booking);
        //Assert
        assertEquals(bookingInformation, hardCodedBookingInformation);
        //Teardown
    }
}