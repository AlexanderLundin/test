package com.galvanize.formatters;

import com.galvanize.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVFormatterTest {


    CSVFormatter formatter;
    Booking booking;
    Booking.RoomType roomType = Booking.RoomType.r;
    String roomNumber = "111";
    String startTime = "08:30am";
    String endTime = "11:00am";

    String hardCodedBookingInformation =
            "type,room number,start time,end time" +
                    "\n" + roomType.ToString() + "," + roomNumber  + "," + startTime + "," + endTime;

    @BeforeEach
    public void Setup() {
        formatter = new CSVFormatter();
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