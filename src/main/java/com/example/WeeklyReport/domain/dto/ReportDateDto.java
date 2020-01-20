package com.example.WeeklyReport.domain.dto;

import java.time.LocalDate;

import com.example.WeeklyReport.env.entity.ReportDate;

public class ReportDateDto {

	int id;

	LocalDate date;

	public ReportDateDto() {

	}

	public ReportDateDto(int id, LocalDate date) {
		this.id = id;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public static ReportDateDto of(ReportDate reportDate) {
		return new ReportDateDto(reportDate.getId(), reportDate.getDate());
	}
}
