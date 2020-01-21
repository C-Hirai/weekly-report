package com.example.WeeklyReport.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WeeklyReport.domain.constants.ProjectStatusType;
import com.example.WeeklyReport.domain.dto.ProjectDto;
import com.example.WeeklyReport.env.entity.Project;
import com.example.WeeklyReport.env.mapper.ProjectMapper;

@Service
public class ProjectService {

	@Autowired
	ProjectMapper projectMapper;

	public ProjectDto fetch(int id) {

		Project project = projectMapper.findById(id);

		ProjectDto projectDto = ProjectDto.of(project);

		return projectDto;

	}

	public List<ProjectDto> fetchList() {

		List<Project> projectList = projectMapper.findList();

		List<ProjectDto> projectDtoList = new ArrayList<>();

		projectList.stream().forEach(x -> projectDtoList.add(ProjectDto.of(x)));

		return projectDtoList;
	}

	public void create(ProjectDto projectDto) {

		Project project = new Project(null, projectDto.getName(), projectDto.getDeadline(), projectDto.getLeader(),
				projectDto.getMember(), ProjectStatusType.OPEN.getCode());

		projectMapper.create(project);
	}
	
	public void update(ProjectDto projectDto) {

		Project project = new Project(projectDto.getId(), projectDto.getName(), projectDto.getDeadline(), projectDto.getLeader(),
				projectDto.getMember(), null);

		projectMapper.update(project);
	}
	
	public void changeStatus(int projectId) {

		ProjectStatusType currentStatus = ProjectStatusType.getProjectStatusType(projectMapper.findById(projectId).getStatusCode());

		switch(currentStatus) {
		
		case OPEN:
			projectMapper.changeStatus(projectId, ProjectStatusType.CLOSE.getCode());
			break;
		
		case CLOSE:
			projectMapper.changeStatus(projectId, ProjectStatusType.OPEN.getCode());
			break;
			
		default:
			break;
			
		}
	}
}
