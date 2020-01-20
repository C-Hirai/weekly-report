package com.example.WeeklyReport.env.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.WeeklyReport.env.entity.Project;

@Mapper
public interface ProjectMapper {

	Project find(int projectId);
	
	List<Project> findList();
	
	void register(Project project);
}
