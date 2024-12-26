package com.example.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Dates {
    public static void main(String[] args) {
//        LocalTime time = LocalTime.now();
//        System.out.println(time);
        //Дата и время
//        LocalDateTime dateTime = LocalDateTime.now();
//        System.out.println(dateTime);
        //Форматирование даты и времени
        LocalDate march2003 = LocalDate.of(2003, 3, 1);
        LocalDate may2003 = LocalDate.of(2003, 5, 1);
        Period dif = Period.between(march2003, may2003);
        int days = dif.getMonths();
        System.out.println(days);
        LocalDate january2000 = LocalDate.of(2000, 1, 1);
        LocalDate today = LocalDate.now();
        Period difq = Period.between(january2000, LocalDate.now());
        int months = difq.getMonths();
        System.out.println(months);

//        LocalDate localDate = LocalDate.now();
//
//        LocalDate tomorrow = LocalDate.now().plusDays(1);
//        boolean isDateAfter = localDate.compareTo(tomorrow) > 0; // false
//        System.out.println(isDateAfter);
//        LocalDate now = LocalDate.now();
//        LocalDate _2024 =LocalDate.of(2024,12,02);
//        System.out.println(now.isBefore(_2024));
//        LocalDateTime myDateObj = LocalDateTime.now();
//        myDateObj = myDateObj.plusDays(10);
//        myDateObj = myDateObj.plusHours(1);
//        myDateObj = myDateObj.plus(Period.ofMonths(4));
//        System.out.println("Before formatting: " + myDateObj);
//        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd:MM:yy HH:mm:ss");
//        String formattedDate = myDateObj.format(myFormatObj);
//        System.out.println("After formatting: " + formattedDate);

    }
}
