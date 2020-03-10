package com.galvanize.formatters;

import com.galvanize.Booking;

import javax.swing.text.html.HTML;

public class HTMLFormatter implements Formatter {
    @Override
    public String format(Booking booking) {
        String string =
                "<dl>\n" +
                        "  <dt>Type</dt><dd>" + booking.getRoomType().ToString() +"</dd>\n" +
                        "  <dt>Room Number</dt><dd>" + booking.getRoomNumber() + "</dd>\n" +
                        "  <dt>Start Time</dt><dd>" + booking.getStartTime() + "</dd>\n" +
                        "  <dt>End Time</dt><dd>" + booking.getEndTime() + "</dd>\n" +
                        "</dl>";
        return string;
    }
}
