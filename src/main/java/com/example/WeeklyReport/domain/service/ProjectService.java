package com.example.WeeklyReport.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WeeklyReport.domain.dto.ProjectDto;
import com.example.WeeklyReport.env.entity.Project;
import com.example.WeeklyReport.env.mapper.ProjectMapper;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectMapper projectMapper;
	
	public ProjectDto fetch(int projectId) {
		
		Project project = projectMapper.find(projectId);
		
		ProjectDto projectDto = ProjectDto.of(project);
		
		return projectDto;
		
	}

	public List<ProjectDto> fetchList() {
		
		List<Project> projectList = projectMapper.findAll();
		
		List<ProjectDto> projectDtoList = new ArrayList<>();
		
		projectList.stream().forEach(x -> projectDtoList.add(ProjectDto.of(x)));
		
		return projectDtoList;
	}
}
