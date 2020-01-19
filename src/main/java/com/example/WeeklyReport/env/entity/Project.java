package com.example.WeeklyReport.env.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Project {

	private int id;

	private String projectName;
	
	private String deadline;
	
	private String leader;
	
	private String member;
}
