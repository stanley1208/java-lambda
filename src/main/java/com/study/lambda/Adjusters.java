package com.study.lambda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQueries;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class Adjusters {

	public static Temporal adjustInto(Temporal input) {
		LocalDate date = LocalDate.from(input); // 將任何 Temporal 轉換成 LocalDate 的實用方式
		int day;
		if (date.getDayOfMonth() < 15) {
			day = 15;
		} else {
			day = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
		}
		date = date.withDayOfMonth(day);
		if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
			date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
		}
		return input.with(date);
	}

	// 使用方法參考
	@Test
	public void payDayWithMethodRef() {

		IntStream.rangeClosed(1, 14).mapToObj(day -> LocalDate.of(2017, Month.JULY, day))
				.forEach(data -> assertEquals(14, data.with(Adjusters::adjustInto).getDayOfMonth()));

		IntStream.rangeClosed(15, 31).mapToObj(day -> LocalDate.of(2017, Month.JULY, day))
				.forEach(data -> assertEquals(31, data.with(Adjusters::adjustInto).getDayOfMonth()));
	}
	// 使用 TemporalQueries 方法
	@Test
	public void queries() {
		assertEquals(ChronoUnit.DAYS, LocalDate.now().query(TemporalQueries.precision()));
		assertEquals(ChronoUnit.NANOS, LocalTime.now().query(TemporalQueries.precision()));
		assertEquals(ZoneId.systemDefault(), ZonedDateTime.now().query(TemporalQueries.zone()));
		assertEquals(ZoneId.systemDefault(), ZonedDateTime.now().query(TemporalQueries.zoneId()));

	}
	// 計算離國際海盜模仿日還有幾天
	public long daysUntilPirateDay(TemporalAccessor temporal) {
		int day = temporal.get(ChronoField.DAY_OF_MONTH);
		int month = temporal.get(ChronoField.MONTH_OF_YEAR);
		int year = temporal.get(ChronoField.YEAR);
		LocalDate date = LocalDate.of(year, month, day);
		LocalDate tlapd = LocalDate.of(year, Month.SEPTEMBER, 19);
		if (date.isAfter(tlapd)) {
			tlapd = tlapd.plusYears(1);

		}
		return ChronoUnit.DAYS.between(date, tlapd);
	}

	// 透過方法參考使用 TemporalQuery
	public void pirateDay() {
		IntStream.range(10, 19).mapToObj(n -> LocalDate.of(2017, Month.SEPTEMBER, n))
				.forEach(date -> assertTrue(date.query(this::daysUntilPirateDay) <= 9));
		IntStream.rangeClosed(20, 30).mapToObj(n -> LocalDate.of(2017, Month.SEPTEMBER, n)).forEach(date -> {
			Long days = date.query(this::daysUntilPirateDay);
			assertTrue(days >= 354 && days < 365);
		});
	}
}