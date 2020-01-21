package com.example.WeeklyReport.domain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WeeklyReport.domain.dto.ReportDateDto;
import com.example.WeeklyReport.domain.dto.ReportDto;
import com.example.WeeklyReport.env.entity.Project;
import com.example.WeeklyReport.env.entity.Report;
import com.example.WeeklyReport.env.entity.ReportDate;
import com.example.WeeklyReport.env.mapper.ProjectMapper;
import com.example.WeeklyReport.env.mapper.ReportDateMapper;
import com.example.WeeklyReport.env.mapper.ReportMapper;

@Service
public class ReportService {

	private final static int ONE_WEEK_DAY = 7;

	@Autowired
	ReportMapper reportMapper;
	
	@Autowired
	ReportDateMapper reportDateMapper;

	@Autowired
	ProjectMapper projectMapper;

	public ReportDto fetch(int reportId) {

		Report report = reportMapper.findById(reportId);

		ReportDto reportDto = ReportDto.of(report);

		return reportDto;
	}

	public List<ReportDto> fetchList(LocalDate date) {
		
		ReportDate reportDate = reportDateMapper.findByDate(date);

		List<Report> reportList = new ArrayList<Report>();
		if(Objects.nonNull(reportDate)) {
			reportList = reportMapper.findListById(reportDate.getId());
		}

		List<ReportDto> reportDtoList = new ArrayList<ReportDto>();

		reportList.stream().forEach(x -> reportDtoList.add(ReportDto.of(x)));

		return reportDtoList;
	}

	public List<ReportDateDto> fetchDateList() {

		List<ReportDateDto> reportDateDtoList = new ArrayList<ReportDateDto>();

		List<ReportDate> reportDateList = reportDateMapper.findList();

		reportDateList.stream().forEach(x -> reportDateDtoList.add(ReportDateDto.of(x)));

		return reportDateDtoList;
	}

	public List<Report> create() {

		ReportDate reportDate = reportDateMapper.findLatest();

		if (Objects.nonNull(reportDate)) {
			reportDateMapper.insert(reportDate.getDate().plusDays(ONE_WEEK_DAY), false);
		} else {
			reportDateMapper.insert(LocalDate.now(), false);
		}
		
		ReportDate createDate = reportDateMapper.findLatest();
		List<Project> openProjectList = projectMapper.findOpenList();
		
		List<Report> reportList = new ArrayList<Report>();
		for (Project p : openProjectList) {
			Report r = new Report();
			r.setReportDateId(createDate.getId());
			r.setProjectId(p.getId());
			
			Report lastWeekReport = reportMapper.findLastWeek(createDate.getId()-1, p.getId());
			if(Objects.nonNull(lastWeekReport)) {
				r.setLastWeekCondition(lastWeekReport.getThisWeekCondition());
				r.setThisWeekPlan(lastWeekReport.getNextWeekPlan());
				r.setProblem(lastWeekReport.getProblem());
			}

			reportList.add(r);
		}

		reportList.stream().forEach(x -> reportMapper.insert(x));

		return reportList;
	}

}
