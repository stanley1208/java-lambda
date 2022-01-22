package com.study.lambda;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

// 將 java.util 類別轉換成 java.time 類別
public class ConvertDate {
	public LocalDate convertFromSqlDatetoLD(java.sql.Date sqlDate) {
		return sqlDate.toLocalDate();
	}
	
	public java.sql.Date convertToSqlDateFromLD(LocalDate localDate){
		return java.sql.Date.valueOf(localDate);
	}
	
	public LocalDateTime convertFromTimestampToLDT(Timestamp timestamp) {
		return timestamp.toLocalDateTime();
	}
	
	public Timestamp convertToTimestampFromLDT(LocalDateTime localDateTime) {
		return Timestamp.valueOf(localDateTime);
	}
}
