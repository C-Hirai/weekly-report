package com.example.WeeklyReport.domain.dto;

import com.example.WeeklyReport.domain.constants.ProjectStatusType;
import com.example.WeeklyReport.env.entity.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ProjectDto {

	private int id;

	private String name;
	
	private String deadline;
	
	private String leader;
	
	private String member;
	
	private String status;
	
	public static ProjectDto of(Project project) {
		
		return new ProjectDto(
				project.getId(),
				project.getName(),
				project.getDeadline(),
				project.getLeader(),
				project.getMember(),
				ProjectStatusType.getLabel(project.getStatusCode())
				);
	}
}
