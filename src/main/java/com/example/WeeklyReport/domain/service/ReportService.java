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

	public ReportDto fetch(int id) {

		Report report = reportMapper.findById(id);
		ReportDate reportDate = reportDateMapper.findById(report.getReportDateId());
		Project project = projectMapper.findById(report.getProjectId());

		ReportDto reportDto = ReportDto.of(report, reportDate, project);

		return reportDto;
	}

	public List<ReportDto> fetchList(LocalDate date) {

		ReportDate queryDate = reportDateMapper.findByDate(date);

		List<Report> reportList = new ArrayList<Report>();
		if (Objects.nonNull(queryDate)) {
			reportList = reportMapper.findListById(queryDate.getId());
		}

		List<ReportDto> reportDtoList = new ArrayList<ReportDto>();
		for (Report report : reportList) {
			ReportDate reportDate = reportDateMapper.findById(report.getReportDateId());
			Project project = projectMapper.findById(report.getProjectId());

			ReportDto reportDto = ReportDto.of(report, reportDate, project);
			reportDtoList.add(reportDto);
		}

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

			Report lastWeekReport = reportMapper.findLastWeek(createDate.getId() - 1, p.getId());
			if (Objects.nonNull(lastWeekReport)) {
				r.setLastWeekCondition(lastWeekReport.getThisWeekCondition());
				r.setThisWeekPlan(lastWeekReport.getNextWeekPlan());
				r.setProblem(lastWeekReport.getProblem());
			}

			reportList.add(r);
		}

		reportList.stream().forEach(x -> reportMapper.insert(x));

		return reportList;
	}

	public Report update(ReportDto reportDto) {

		Report report = new Report(reportDto.getId(), null, reportDto.getThisWeekCondition(),
				reportDto.getThisWeekPlan(), reportDto.getThisWeekResult(), reportDto.getProblem(),
				reportDto.getNextWeekPlan(), null, null, null);
		
		reportMapper.update(report);
		
		return report;
	}
	
	public List<ReportDto> updateMemo(List<ReportDto> reportDtoList) {

		for(ReportDto reportDto : reportDtoList) {
			reportMapper.updateMemo(reportDto.getId(), reportDto.getMemo());
		}
		
		return reportDtoList;
	}

}
