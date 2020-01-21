package com.example.WeeklyReport.env.entity;

import java.time.LocalDate;

public class ReportDate {
	
	int id;

	LocalDate date;
	
	boolean deleteFlg;

	public ReportDate() {

	}

	public ReportDate(int id, LocalDate date, boolean deleteFlg) {
		this.id = id;
		this.date = date;
		this.deleteFlg = deleteFlg;
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

	public boolean isDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(boolean deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

}
