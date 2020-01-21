package com.example.WeeklyReport.web.form;

import com.example.WeeklyReport.domain.dto.ReportDto;

public class ReportForm {

	int id;

    String lastWeekCondition;
	
	String thisWeekCondition;

	String thisWeekPlan;

	String thisWeekResult;

	String problem;

	String nextWeekPlan;

	String memo;
	
	ReportDateForm reportDate;

	ProjectForm project;

	public ReportForm() {

	}

	public ReportForm(int id, String lastWeekCondition, String thisWeekCondition, String thisWeekPlan, String thisWeekResult, String problem,
			String nextWeekPlan, String memo, ReportDateForm reportDate, ProjectForm project) {
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

	public ProjectForm getProject() {
		return project;
	}

	public void setProject(ProjectForm project) {
		this.project = project;
	}
	
	public static ReportForm of(ReportDto reportDto) {
		return new ReportForm(
				reportDto.getId(), 
				reportDto.getLastWeekCondition(), 
				reportDto.getThisWeekCondition(), 
				reportDto.getThisWeekPlan(),
				reportDto.getThisWeekResult(), 
				reportDto.getProblem(),
				reportDto.getNextWeekPlan(),
				reportDto.getMemo(),
				ReportDateForm.of(reportDto.getReportDate()),
				ProjectForm.of(reportDto.getProject()));
	}
}
