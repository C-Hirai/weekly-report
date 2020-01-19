package com.example.WeeklyReport.web.form;

import com.example.WeeklyReport.domain.dto.ProjectDto;

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
public class ProjectForm {

	private int id;

	private String name;
	
	private String deadline;
	
	private String leader;
	
	private String member;
	
	private String status;
	
    public static ProjectForm of(ProjectDto projectDto) {
		
		return new ProjectForm(
				projectDto.getId(),
				projectDto.getName(),
				projectDto.getDeadline(),
				projectDto.getLeader(),
				projectDto.getMember(),
				projectDto.getStatus()
				);
	}
}
