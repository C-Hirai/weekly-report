package com.example.WeeklyReport.web.form;

import java.time.LocalDate;

import com.example.WeeklyReport.domain.dto.ReportDateDto;

public class ReportDateForm {
	
	int id;
	
	LocalDate date;
	
	boolean deleteFlg;

	public ReportDateForm() {
		
	}
	
	public ReportDateForm(int id, LocalDate date, boolean deleteFlg) {
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
	
	public static ReportDateForm of(ReportDateDto reportDateDto) {
		return new ReportDateForm(reportDateDto.getId(), reportDateDto.getDate(), reportDateDto.isDeleteFlg());
	}
}
