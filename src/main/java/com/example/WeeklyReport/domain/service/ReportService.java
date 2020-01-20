package com.example.WeeklyReport.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WeeklyReport.domain.dto.ReportDateDto;
import com.example.WeeklyReport.domain.dto.ReportDto;
import com.example.WeeklyReport.env.entity.Report;
import com.example.WeeklyReport.env.entity.ReportDate;
import com.example.WeeklyReport.env.mapper.ReportMapper;

@Service
public class ReportService {
	
	@Autowired
	ReportMapper reportMapper;
	
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
	
}
