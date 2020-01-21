package com.example.WeeklyReport.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/{projectId}")
	public ProjectForm fetch(@PathVariable String projectId) {

		ProjectDto projectDto = projectService.fetch(Integer.parseInt(projectId));

		ProjectForm projectForm = ProjectForm.of(projectDto);

		return projectForm;
	}

	@GetMapping("/list")
	public List<ProjectForm> fetchList() {

		List<ProjectForm> projectFormList = new ArrayList<ProjectForm>();

		List<ProjectDto> projectDtoList = projectService.fetchList();

		projectDtoList.stream().forEach(x -> projectFormList.add(ProjectForm.of(x)));

		return projectFormList;
	}

	@PostMapping("/new")
	public ProjectDto create(@RequestBody ProjectForm projectForm) {

		ProjectDto projectDto = new ProjectDto(null, projectForm.getName(), projectForm.getDeadline(),
				projectForm.getLeader(), projectForm.getMember(), null);

		projectService.create(projectDto);

		return projectDto;
	}

	@PostMapping("/edit/{projectId}")
	public ProjectDto update(@RequestBody ProjectForm projectForm, @PathVariable String projectId) {

		ProjectDto projectDto = new ProjectDto(Integer.parseInt(projectId), projectForm.getName(),
				projectForm.getDeadline(), projectForm.getLeader(), projectForm.getMember(), null);

		projectService.update(projectDto);

		return projectDto;
	}
	
	@PostMapping("/change/{projectId}")
	public String changeStatus(@PathVariable String projectId) {

		projectService.changeStatus(Integer.parseInt(projectId));

		return projectId;
	}

}
