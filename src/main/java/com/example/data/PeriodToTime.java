package com.example.data;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodToTime {
    public static void main(String[] args) {
        // Определяем две даты
        LocalDate startDate = LocalDate.of(2023, 12, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 2);

        // Вычисляем период между датами
        Period period = Period.between(startDate, endDate);

        // Вывод периода в стандартных единицах
        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());

        // Преобразуем период в общее количество дней
        long totalDays = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("Total Days: " + totalDays);

        // Преобразуем дни в часы и минуты
        long totalHours = totalDays * 24; // Каждый день содержит 24 часа
        long totalMinutes = totalHours * 60; // Каждый час содержит 60 минут

        System.out.println("Total Hours: " + totalHours);
        System.out.println("Total Minutes: " + totalMinutes);
    }
}