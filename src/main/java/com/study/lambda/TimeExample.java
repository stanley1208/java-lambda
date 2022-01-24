package com.study.lambda;

import static org.junit.Assert.assertEquals;

import java.security.PublicKey;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

public class TimeExample {

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

//		System.out.println("Days in Feb in a leap year: " + Month.FEBRUARY.length(true));
//		System.out.println("Days of year for first day of Aug (leap year): " + Month.AUGUST.firstDayOfYear(true));
//		System.out.println("Month.of(1): " + Month.of(1));
//		System.out.println("Adding two months: " + Month.JANUARY.plus(2));
//		System.out.println("Subtracting a months: " + Month.MARCH.minus(1));

		// 格式化日期
		LocalDate date = LocalDate.of(2017, Month.MARCH, 13);
		System.out.println("Full : " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		System.out.println("Long : " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		System.out.println("Medium:" + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		System.out.println("Short: " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));

		System.out.println(
				"France:" + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.FRANCE)));
		System.out.println("India :"
				+ date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale("hin", "IN"))));
		System.out.println("Brazil:"
				+ date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale("pt", "BR"))));
		System.out.println(
				"Japan :" + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.JAPAN)));
		Locale loc = new Locale.Builder().setLanguage("sr").setScript("Latn").setRegion("RS").build();
		System.out
				.println("Serbian:" + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(loc)));
		
		ZonedDateTime moonLanding=ZonedDateTime.of(LocalDate.of(1969, Month.JULY, 20), LocalTime.of(20, 18),ZoneId.of("UTC"));
		System.out.println(moonLanding.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
		
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("uuuu/MMMM/dd hh:mm:ss a zzz GG");
		System.out.println(moonLanding.format(formatter));
		
		formatter=DateTimeFormatter.ofPattern("uuuu/MMMM/dd hh:mm:ss a VV xxxxx");
		System.out.println(moonLanding.format(formatter));
		
		// 將時鐘往前調
		ZonedDateTime zdt=ZonedDateTime.of(2018,3,11,2,30,0,0,ZoneId.of("America/New_York"));
		System.out.println(zdt.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
	}

	// LocalDate 的 plus 方法
	public void localDatePlus() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate start = LocalDate.of(2017, Month.FEBRUARY, 2);
		LocalDate end = start.plusDays(3);
		end = start.plusWeeks(5);
		end = start.plusMonths(7);
		end = start.plusYears(2);

	}

	// LocalTime 的 plus 方法
	public void localTimePlus() {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
		LocalTime start = LocalTime.of(11, 30, 0, 0);
		LocalTime end = start.plusNanos(1_000_000);
		end = start.plusSeconds(20);
		end = start.plusMinutes(45);
		end = start.plusHours(5);

	}

	// LocalDateTime 的 plus 和 minus 方法
	public void plus_minus() {
		Period period = Period.of(2, 3, 4); // 兩年，三個用，四天
		LocalDateTime start = LocalDateTime.of(2017, Month.FEBRUARY, 2, 11, 30);
		LocalDateTime end = start.plus(period);
		end = start.plus(3, ChronoUnit.HALF_DAYS);
		end = start.minus(period);
		end = start.minus(2, ChronoUnit.CENTURIES);
		end = start.plus(3, ChronoUnit.MILLENNIA);

	}

	// LocalDateTime 的 with 方法
	public void with() {
		LocalDateTime start = LocalDateTime.of(2017, Month.FEBRUARY, 2, 11, 30);
		LocalDateTime end = start.withMinute(45);
		end = start.withHour(16);
		end = start.withDayOfMonth(28);
		end = start.withDayOfYear(300);
		end = start.withYear(2020);
	}

	// 錯誤的用法
	public void withInvalidDate() {
		LocalDateTime start = LocalDateTime.of(2017, Month.FEBRUARY, 2, 11, 30);
		start.withDayOfMonth(29);
	}

	// 將月份調整為有效值值
	public void temporalField() {
		LocalDateTime start = LocalDateTime.of(2017, Month.JANUARY, 31, 11, 30);
		LocalDateTime end = start.with(ChronoField.MONTH_OF_YEAR, 2);

	}

	// 使用 TemporalAdjusters 的靜態方法
	@Test
	public void adjusters() {
		LocalDateTime start = LocalDateTime.of(2017, Month.FEBRUARY, 2, 11, 30);
		LocalDateTime end = start.with(TemporalAdjusters.firstDayOfNextMonth());
		assertEquals("2017-03-01T11:30", end.toString());
		end = start.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
		assertEquals("2017-02-09T11:30", end.toString());
		end = start.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY));
		assertEquals("2017-02-02T11:30", end.toString());
	}

	// 用來解析與格式化LocalDate的作法
	LocalDateTime now = LocalDateTime.now();
	String text = now.format(DateTimeFormatter.ISO_DATE_TIME);
	LocalDateTime dateTime = LocalDateTime.parse(text);

}
