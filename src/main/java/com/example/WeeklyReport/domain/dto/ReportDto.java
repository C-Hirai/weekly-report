package com.example.WeeklyReport.domain.dto;

import com.example.WeeklyReport.env.entity.Report;

public class ReportDto {

	int id;

    String lastWeekCondition;
	
	String thisWeekCondition;

	String thisWeekPlan;

	String thisWeekResult;

	String problem;

	String nextWeekPlan;

	String memo;
	
	ReportDateDto reportDate;

	ProjectDto project;

	public ReportDto() {

	}

	public ReportDto(int id, String lastWeekCondition, String thisWeekCondition, String thisWeekPlan, String thisWeekResult, String problem,
			String nextWeekPlan, String memo, ReportDateDto reportDate, ProjectDto project) {
		this.id = id;
		this.lastWeekCondition = lastWeekCondition;
		this.thisWeekCondition = thisWeekCondition;
		this.thisWeekPlan = thisWeekPlan;
		this.problem = problem;
		this.thisWeekResult = thisWeekResult;
		this.nextWeekPlan = nextWeekPlan;
		this.memo = memo;
		this.reportDate = reportDate;
		this.project = project;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastWeekCondition() {
		return lastWeekCondition;
	}

	public void setLastWeekCondition(String lastWeekCondition) {
		this.lastWeekCondition = lastWeekCondition;
	}

	public String getThisWeekCondition() {
		return thisWeekCondition;
	}

	public void setThisWeekCondition(String thisWeekCondition) {
		this.thisWeekCondition = thisWeekCondition;
	}

	public String getThisWeekPlan() {
		return thisWeekPlan;
	}

	public void setThisWeekPlan(String thisWeekPlan) {
		this.thisWeekPlan = thisWeekPlan;
	}

	public String getThisWeekResult() {
		return thisWeekResult;
	}

	public void setThisWeekResult(String thisWeekResult) {
		this.thisWeekResult = thisWeekResult;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getNextWeekPlan() {
		return nextWeekPlan;
	}

	public void setNextWeekPlan(String nextWeekPlan) {
		this.nextWeekPlan = nextWeekPlan;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public ReportDateDto getReportDate() {
		return reportDate;
	}

	public void setReportDate(ReportDateDto reportDate) {
		this.reportDate = reportDate;
	}

	public ProjectDto getProject() {
		return project;
	}

	public void setProject(ProjectDto project) {
		this.project = project;
	}

	public static ReportDto of(Report report) {
		return new ReportDto(
				report.getId(), 
				report.getLastWeekCondition(), 
				report.getThisWeekCondition(), 
				report.getThisWeekPlan(),
				report.getThisWeekResult(), 
				report.getProblem(), 
				report.getNextWeekPlan(), 
				report.getMemo(),
				ReportDateDto.of(report.getReportDate()),
				ProjectDto.of(report.getProject()));
	}
}
