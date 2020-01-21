package com.example.WeeklyReport.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ProjectForm fetch(@RequestParam String id) {

		ProjectDto projectDto = projectService.fetch(Integer.parseInt(id));

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

	@PostMapping("/edit")
	public ProjectDto update(@RequestBody ProjectForm projectForm, @RequestParam String id) {

		ProjectDto projectDto = new ProjectDto(Integer.parseInt(id), projectForm.getName(),
				projectForm.getDeadline(), projectForm.getLeader(), projectForm.getMember(), null);

		projectService.update(projectDto);

		return projectDto;
	}
	
	@PostMapping("/change")
	public String changeStatus(@RequestParam String id) {

		projectService.changeStatus(Integer.parseInt(id));

		return id;
	}

}
