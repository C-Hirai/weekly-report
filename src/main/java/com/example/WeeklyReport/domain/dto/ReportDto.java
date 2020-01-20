package com.example.WeeklyReport.domain.dto;

import com.example.WeeklyReport.env.entity.Report;

public class ReportDto {

	int id;

	String condition;

	String thisWeekPlan;

	String thisWeekResult;

	String problem;

	String nextWeekPlan;

	String memo;

	ProjectDto project;

	public ReportDto() {

	}

	public ReportDto(int id, String condition, String thisWeekPlan, String thisWeekResult, String problem,
			String nextWeekPlan, String memo, ProjectDto project) {
		this.id = id;
		this.condition = condition;
		this.thisWeekPlan = thisWeekPlan;
		this.problem = problem;
		this.thisWeekResult = thisWeekResult;
		this.nextWeekPlan = nextWeekPlan;
		this.memo = memo;
		this.project = project;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
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

	public ProjectDto getProject() {
		return project;
	}

	public void setProject(ProjectDto project) {
		this.project = project;
	}

	public static ReportDto of(Report report) {
		return new ReportDto(
				report.getId(), 
				report.getCondition(), 
				report.getThisWeekPlan(),
				report.getThisWeekResult(), 
				report.getProblem(), 
				report.getNextWeekPlan(), 
				report.getMemo(),
				ProjectDto.of(report.getProject()));
	}
}
