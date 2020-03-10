package com.galvanize.formatters;

import com.galvanize.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HTMLFormatterTest {
    HTMLFormatter formatter;
    Booking booking;
    Booking.RoomType roomType = Booking.RoomType.r;
    String roomNumber = "111";
    String startTime = "08:30am";
    String endTime = "11:00am";

    String hardCodedBookingInformation =
            "<dl>\n" +
                    "  <dt>Type</dt><dd>" + roomType.ToString() + "</dd>\n" +
                    "  <dt>Room Number</dt><dd>" + roomNumber + "</dd>\n" +
                    "  <dt>Start Time</dt><dd>" + startTime + "</dd>\n" +
                    "  <dt>End Time</dt><dd>" + endTime + "</dd>\n" +
                    "</dl>";

    @BeforeEach
    public void Setup() {
        formatter = new HTMLFormatter();
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