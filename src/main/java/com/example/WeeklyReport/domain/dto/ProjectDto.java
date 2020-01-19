package com.example.WeeklyReport.domain.dto;

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

	private String projectName;
	
	private String deadline;
	
	private String leader;
	
	private String member;
	
	public static ProjectDto of(Project project) {
		
		return new ProjectDto(
				project.getId(),
				project.getProjectName(),
				project.getDeadline(),
				project.getLeader(),
				project.getMember()
				);
	}
}
