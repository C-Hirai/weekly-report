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
import com.example.WeeklyReport.env.mapper.ReportMapper;

@Service
public class ReportService {

	private final static int ONE_WEEK_DAY = 7;

	@Autowired
	ReportMapper reportMapper;

	@Autowired
	ProjectMapper projectMapper;

	public ReportDto fetch(int reportId) {

		Report report = reportMapper.findById(reportId);

		ReportDto reportDto = ReportDto.of(report);

		return reportDto;
	}

	public List<ReportDto> fetchList(int weekId) {

		List<Report> reportList = reportMapper.findListById(weekId);

		List<ReportDto> reportDtoList = new ArrayList<ReportDto>();

		reportList.stream().forEach(x -> reportDtoList.add(ReportDto.of(x)));

		return reportDtoList;
	}

	public List<ReportDateDto> fetchDateList() {

		List<ReportDateDto> reportDateDtoList = new ArrayList<ReportDateDto>();

		List<ReportDate> reportDateList = reportMapper.findDateList();

		reportDateList.stream().forEach(x -> reportDateDtoList.add(ReportDateDto.of(x)));

		return reportDateDtoList;
	}

	public List<Report> create() {

		ReportDate reportDate = reportMapper.findLatestDate();

		if (Objects.nonNull(reportDate)) {
			reportMapper.insertDate(reportDate.getDate().plusDays(ONE_WEEK_DAY), false);
		} else {
			reportMapper.insertDate(LocalDate.now(), false);
		}
		
		ReportDate createDate = reportMapper.findLatestDate();
		List<Project> openProjectList = projectMapper.findOpenList();
		
		List<Report> reportList = new ArrayList<Report>();
		for (Project project : openProjectList) {
			Report report = new Report();
			report.setReportDateId(createDate.getId());
			report.setProjectId(project.getId());

			reportList.add(report);
		}

		reportList.stream().forEach(x -> reportMapper.insert(x));

		return reportList;
	}

}
