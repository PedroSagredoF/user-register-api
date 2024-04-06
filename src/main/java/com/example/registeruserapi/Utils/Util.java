package com.example.registeruserapi.Utils;


import java.sql.Date;
import java.util.UUID;

public class Util {

    public static String getUIID() {
        return UUID.randomUUID().toString();
    }

    public static Date addMinutesToDate(int minutes, Date beforeTime) {
        final long MILLIS = 60000;

        long curTimeInMs = beforeTime.getTime();
        Date afterAddingMins = new Date(curTimeInMs + (minutes * MILLIS));
        return afterAddingMins;
    }
}
