package com.galvanize.formatters;

import com.galvanize.Booking;

public class CSVFormatter implements Formatter{
    @Override
    public String format(Booking booking) {
        String csv = "type,room number,start time,end time\n" +
                String.format("%s,%s,%s,%s", booking.getRoomType().ToString(), booking.getRoomNumber(), booking.getStartTime(), booking.getEndTime());
        return csv;
    }
}
