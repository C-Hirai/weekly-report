package com.example.WeeklyReport.web.form;

import java.time.LocalDate;

import com.example.WeeklyReport.domain.dto.ReportDateDto;

public class ReportDateForm {
	
	int id;
	
	LocalDate date;

	public ReportDateForm() {
		
	}
	
	public ReportDateForm(int id, LocalDate date) {
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
	
	public static ReportDateForm of(ReportDateDto reportDateDto) {
		return new ReportDateForm(reportDateDto.getId(), reportDateDto.getDate());
	}
}
