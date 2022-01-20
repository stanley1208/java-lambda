package com.study.lambda;

import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class PayDayAdjuster implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal input) {
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

	// 測試 2017 年 7 月的調整
	@Test
	public void payDay() {
		TemporalAdjuster adjuster = new PayDayAdjuster();
		IntStream.rangeClosed(1, 14).mapToObj(day -> LocalDate.of(2017, Month.JULY, day))
				.forEach(data -> assertEquals(14, data.with(adjuster).getDayOfMonth()));

		IntStream.rangeClosed(15, 31).mapToObj(day -> LocalDate.of(2017, Month.JULY, day))
				.forEach(data -> assertEquals(31, data.with(adjuster).getDayOfMonth()));
	}

}
