package com.example.WeeklyReport.env.entity;

import java.time.LocalDate;

public class ReportDate {
	
	int id;

	LocalDate date;

	public ReportDate() {

	}

	public ReportDate(int id, LocalDate date) {
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

}
