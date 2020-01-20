package com.example.WeeklyReport.domain.dto;

import com.example.WeeklyReport.domain.constants.ProjectStatusType;
import com.example.WeeklyReport.env.entity.Project;
import com.example.WeeklyReport.web.form.ProjectForm;

public class ProjectDto {

	private Integer id;

	private String name;

	private String deadline;

	private String leader;

	private String member;

	private String status;

	public ProjectDto() {

	}

	public ProjectDto(Integer id, String name, String deadline, String leader, String member, String status) {
		this.id = id;
		this.name = name;
		this.deadline = deadline;
		this.leader = leader;
		this.member = member;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public static ProjectDto of(Project project) {

		return new ProjectDto(project.getId(), project.getName(), project.getDeadline(), project.getLeader(),
				project.getMember(), ProjectStatusType.getProjectStatusType(project.getStatusCode()).getLabel());
	}
}
