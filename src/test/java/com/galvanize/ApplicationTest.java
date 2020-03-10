package com.galvanize;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTest {
    Application myApp;
    PrintStream original;
    ByteArrayOutputStream outContent;

    // This block captures everything written to System.out
    @BeforeEach
    public void setOut() {
        original = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        myApp = new Application();
    }

    // This block resets System.out to whatever it was before
    @AfterEach
    public void restoreOut() {
        System.setOut(original);
    }

    Booking.RoomType roomType = Booking.RoomType.c;
    String roomNumber = "111";
    String startTime = "08:30am";
    String endTime = "11:00am";

    @Test
    public void TestCSVFormatter() {
        //Setup
        String[] args = new String[2];
        args[0] = "a111-08:30am-11:00am";
        args[1] = "csv";
        myApp.main(args);
        String systemOut = outContent.toString().trim(); //will give you what your code printed to System.out
        //Exercise
        String expected = "type,room number,start time,end time" +
        "\nAuditorium,111,08:30am,11:00am";
        //Assert
        assertEquals(expected, systemOut);
        //Teardown
    }

    @Test
    public void TestJSONFormatter() {
        //Setup
        String[] args = new String[2];
        args[0] = "c111-08:30am-11:00am";
        args[1] = "json";
        myApp.main(args);
        String systemOut = outContent.toString().trim(); //will give you what your code printed to System.out

        //Exercise
        String expected =
                "{\n" +
                        "  \"type\": \"" + roomType.ToString() + "\",\n" +
                        "  \"roomNumber\": " + roomNumber + ",\n" +
                        "  \"startTime\": \"" + startTime + "\",\n" +
                        "  \"endTime\": \"" + endTime + "\"\n" +
                        "}" ;
        //Assert
        assertEquals(expected, systemOut);
        //Teardown
    }
}