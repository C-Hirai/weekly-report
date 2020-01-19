package com.example.WeeklyReport.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WeeklyReport.domain.dto.ProjectDto;
import com.example.WeeklyReport.domain.service.ProjectService;
import com.example.WeeklyReport.web.form.ProjectForm;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;

	@GetMapping
	public List<ProjectForm> list() {
		
		List<ProjectForm> projectList = new ArrayList<ProjectForm>();
		
		List<ProjectDto> projectDtoList = projectService.fetchList();
		System.out.println(projectDtoList.size());
		
		projectDtoList.stream().forEach(x -> projectList.add(ProjectForm.of(x)));
		
		return projectList;
	}
	
}
