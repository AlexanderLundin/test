package com.galvanize.formatters;

import com.galvanize.Booking;

public class JSONFormatter implements Formatter {
    @Override
    public String format(Booking booking) {


                String string = "{\n" +
                "  \"type\": \"" + booking.getRoomType().ToString() + "\",\n" +
                "  \"roomNumber\": " + booking.getRoomNumber() + ",\n" +
                "  \"startTime\": \"" + booking.getStartTime() + "\",\n" +
                "  \"endTime\": \"" + booking.getEndTime() + "\"\n" +
                "}" ;

//        String string =
//        "{" +
//            "\r\n\t\"type\": \"" + booking.getRoomType().ToString() + "\"," +
//                "\r\n\t\"roomNumber\": \"" + booking.getRoomNumber() + "\"," +
//                "\r\n\t\"startTime\": \"" + booking.getStartTime() + "\"," +
//                "\r\n\t\"endTime: \"" + booking.getEndTime()  +
//        "\r\n}";

        return string;
    }
}
