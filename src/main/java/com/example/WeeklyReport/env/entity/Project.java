package com.example.WeeklyReport.env.entity;

public class Project {

	private Integer id;

	private String name;
	
	private String deadline;
	
	private String leader;
	
	private String member;
	
	private String statusCode;
	
	public Project() {
		
	}
	
	public Project(Integer id, String name, String deadline, String leader, String member, String statusCode) {
		this.id = id;
		this.name = name;
		this.deadline = deadline;
		this.leader = leader;
		this.member = member;
		this.statusCode = statusCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
}
