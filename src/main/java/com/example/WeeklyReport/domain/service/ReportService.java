package com.example.WeeklyReport.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WeeklyReport.domain.dto.ReportDateDto;
import com.example.WeeklyReport.env.entity.ReportDate;
import com.example.WeeklyReport.env.mapper.ReportMapper;

@Service
public class ReportService {
	
	@Autowired
	ReportMapper reportMapper;

	public List<ReportDateDto> fetchDateList() {
		
		List<ReportDateDto> reportDateDtoList = new ArrayList<ReportDateDto>();
		
		List<ReportDate> reportDateList = reportMapper.findDateList();
		
		reportDateList.stream().forEach(x -> reportDateDtoList.add(ReportDateDto.of(x)));
		
		return reportDateDtoList;
	}
}
