package com.example.WeeklyReport.env.entity;

public class Report {

	int id;

	String lastWeekCondition;
	
	String thisWeekCondition;

	String thisWeekPlan;

	String thisWeekResult;

	String problem;

	String nextWeekPlan;

	String memo;
	
	int reportDateId;
	
	int projectId;

	public Report() {

	}

	public Report(int id, String lastWeekCondition, String thisWeekCondition, String thisWeekPlan, String thisWeekResult, String problem,
			String nextWeekPlan, String memo, int reportDateId, int projectId) {
		this.id = id;
		this.lastWeekCondition = lastWeekCondition;
		this.thisWeekCondition = thisWeekCondition;
		this.thisWeekPlan = thisWeekPlan;
		this.problem = problem;
		this.thisWeekResult = thisWeekResult;
		this.nextWeekPlan = nextWeekPlan;
		this.memo = memo;
		this.reportDateId = reportDateId;
		this.projectId = projectId;
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
	
	public int getReportDateId() {
		return reportDateId;
	}

	public void setReportDateId(int reportDateId) {
		this.reportDateId = reportDateId;
	}
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

}
