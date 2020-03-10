package com.galvanize;

import com.galvanize.formatters.CSVFormatter;
import com.galvanize.formatters.Formatter;
import com.galvanize.formatters.HTMLFormatter;
import com.galvanize.formatters.JSONFormatter;

public class Application {
    private static String bookingCode;
    private static Booking booking;
    private static String formatterType;

    public static void main(String[] args) {
        bookingCode = args[0];
        formatterType = args[1];
        booking = Booking.parse(bookingCode);
        Formatter formatter = getFormatter(formatterType);
        String formattedBooking = formatter.format(booking);
        System.out.println(formattedBooking);
    }

    public static Formatter getFormatter(String formatterType){
        String formattedBooking = "";

        if(formatterType == "csv"){
            CSVFormatter formatter = new CSVFormatter();
            return formatter;
        }else if (formatterType == "html"){
            HTMLFormatter formatter = new HTMLFormatter();
            return formatter;
        }else if (formatterType == "json"){
            JSONFormatter formatter = new JSONFormatter();
            return formatter;
        }
        return null;
    }
}