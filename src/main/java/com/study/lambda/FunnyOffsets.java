package com.study.lambda;

import static org.junit.Assert.assertTrue;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

// 非整數小時的時區偏移植
public class FunnyOffsets {
	public static void main(String[] args) {
		Instant instant = Instant.now();
		ZonedDateTime current = instant.atZone(ZoneId.systemDefault());
		System.out.printf("Current time is %s%n%n", current);

		System.out.printf("%10s %20s %13s%n", "Offset", "ZoneId", "Time");
		ZoneId.getAvailableZoneIds().stream().map(ZoneId::of).filter(zoneId -> {
			ZoneOffset offset = instant.atZone(zoneId).getOffset();
			return offset.getTotalSeconds() % (60 * 60) != 0;
		}).sorted(Comparator.comparingInt(zoneId -> instant.atZone(zoneId).getOffset().getTotalSeconds()))
				.forEach(zoneId -> {
					ZonedDateTime zdt = current.withZoneSameInstant(zoneId);
					System.out.printf("%10s %25s %10s%n", zdt.getOffset(), zoneId,
							zdt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
				});

	}

	// 用一個偏移植取得地區名稱
	public static List<String> getRegionNamesForOffset(ZoneOffset offset) {
		LocalDateTime now = LocalDateTime.now();
		return ZoneId.getAvailableZoneIds().stream().map(ZoneId::of)
				.filter(zoneId -> now.atZone(zoneId).getOffset().equals(offset)).map(ZoneId::toString).sorted()
				.collect(Collectors.toList());
	}

	// 取得指定偏移植的地區名稱
	public static List<String> getRegionNamesForZoneId(ZoneId zoneId) {
		LocalDateTime now = LocalDateTime.now();
		ZonedDateTime zdt = now.atZone(zoneId);
		ZoneOffset offset = zdt.getOffset();

		return getRegionNamesForOffset(offset);
	}

	// 取得目前的地區名稱
	@Test
	public void getRegionNamesForSystemDefault() {
		ZonedDateTime now = ZonedDateTime.now();
		ZoneId zoneId = now.getZone();
		List<String> names = getRegionNamesForZoneId(zoneId);

		assertTrue(names.contains(zoneId.getId()));
	}

	// 使用小時與分鐘偏移值來取得地區名稱
	public static List<String> getRegionNamesForOffset(int hours, int minutes) {
		ZoneOffset offset = ZoneOffset.ofHoursMinutes(hours, minutes);
		return getRegionNamesForOffset(offset);
	}

	// 測試指定偏移值的地區名稱
	@Test
	public void getRegionNamesForGMT() {
		List<String> names = getRegionNamesForOffset(0, 0);

		assertTrue(names.contains("GMT"));
		assertTrue(names.contains("Etc/GMT"));
		assertTrue(names.contains("Etc/UTC"));
		assertTrue(names.contains("UTC"));
		assertTrue(names.contains("Etc/Zulu"));
	}

	@Test
	public void getRegionNamesForNepal() {
		List<String> names = getRegionNamesForOffset(5, 45);

		assertTrue(names.contains("Asia/Kathmandu"));
		assertTrue(names.contains("Asia/Katmandu"));
	}

	@Test
	public void getRegionNamesForChicago() {
		ZoneId chicago = ZoneId.of("America/Chicago");
		List<String> names = getRegionNamesForZoneId(chicago);

		assertTrue(names.contains("America/Chicago"));
		assertTrue(names.contains("US/Central"));
		assertTrue(names.contains("Canada/Central"));
		assertTrue(names.contains("Etc/GMT+5") || names.contains("Etc/GMT+6"));
	}
}
