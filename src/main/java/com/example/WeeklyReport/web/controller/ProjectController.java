package com.example.WeeklyReport.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WeeklyReport.domain.dto.ProjectDto;
import com.example.WeeklyReport.domain.service.ProjectService;
import com.example.WeeklyReport.web.form.ProjectForm;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController {
	
	@Autowired
	ProjectService projectService;

	@GetMapping
	public List<ProjectForm> list() {
		
		List<ProjectForm> projectList = new ArrayList<ProjectForm>();
		
		List<ProjectDto> projectDtoList = projectService.fetchList();
		
		projectDtoList.stream().forEach(x -> projectList.add(ProjectForm.of(x)));
		
		return projectList;
	}
	
}
