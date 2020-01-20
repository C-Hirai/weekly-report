package com.example.WeeklyReport.env.entity;

public class Report {

	int id;

	String condition;

	String thisWeekPlan;

	String thisWeekResult;

	String problem;

	String nextWeekPlan;

	String memo;

	Project project;

	public Report() {

	}

	public Report(int id, String condition, String thisWeekPlan, String thisWeekResult, String problem,
			String nextWeekPlan, String memo, Project project) {
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
