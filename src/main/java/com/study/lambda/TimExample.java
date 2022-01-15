package com.study.lambda;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class TimExample {

	public static void main(String[] args) {
		// now 根據目前的時間與日期來建立一個實例
//		System.out.println("Instant.now():" + Instant.now());
//		System.out.println("LocalDate.now():" + LocalDate.now());
//		System.out.println("LocalTime.now():" + LocalTime.now());
//		System.out.println("LocalDateTime.now():" + LocalDateTime.now());
//		System.out.println("ZonedDateTime.now():" + ZonedDateTime.now());
		// of 產生新值
//		System.out.println("First landing on the Moon:");
//		LocalDate moonLandingDate = LocalDate.of(1969, Month.JULY, 20);
//		LocalTime moonLandingTime = LocalTime.of(20, 18);
//		System.out.println("Date:" + moonLandingDate);
//		System.out.println("Time:" + moonLandingTime);
//		System.out.println("Neil Amstrong stp onto the surface: ");
//		LocalTime walkTime = LocalTime.of(20, 2, 56, 150_000_000);
//		LocalDateTime walk = LocalDateTime.of(moonLandingDate, walkTime);
//		System.out.println(walk);

		// 取得區域ID的完整串列
//		Set<String> regionNames = ZoneId.getAvailableZoneIds();
//		System.out.println("There are " + regionNames.size() + " region names");

//		LocalDateTime dateTime = LocalDateTime.of(2017, Month.JULY, 4, 13, 20, 10);
//		ZonedDateTime nyc = dateTime.atZone(ZoneId.of("America/New_York"));
//		System.out.println(nyc);
//		// 用 withZoneSameInstant 找時區另一邊
//		ZonedDateTime london = nyc.withZoneSameInstant(ZoneId.of("Europe/London"));
//		System.out.println(london);

		System.out.println("Days in Feb in a leap year: " + Month.FEBRUARY.length(true));
		System.out.println("Days of year for first day of Aug (leap year): " + Month.AUGUST.firstDayOfYear(true));
		System.out.println("Month.of(1): " + Month.of(1));
		System.out.println("Adding two months: " + Month.JANUARY.plus(2));
		System.out.println("Subtracting a months: " + Month.MARCH.minus(1));
	}

}
