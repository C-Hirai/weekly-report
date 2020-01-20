package com.example.WeeklyReport.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WeeklyReport.domain.dto.ReportDateDto;
import com.example.WeeklyReport.domain.dto.ReportDto;
import com.example.WeeklyReport.domain.service.ReportService;
import com.example.WeeklyReport.web.form.ReportDateForm;
import com.example.WeeklyReport.web.form.ReportForm;

@RestController
@RequestMapping("/api/report")
@CrossOrigin
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@GetMapping("/{reportId}")
	public ReportForm fetch(@PathVariable String reportId) {
		
		ReportDto reportDto = reportService.fetch(Integer.parseInt(reportId));
		
		ReportForm reportForm = ReportForm.of(reportDto);
		
		return reportForm;
	}
	
	@GetMapping("/dateList")
	public List<ReportDateForm> fetchDateList(){
		
		List<ReportDateForm> reportDateFormList = new ArrayList<ReportDateForm>();
		
		List<ReportDateDto> reportDateDtoList = reportService.fetchDateList();
		
		reportDateDtoList.stream().forEach(x -> reportDateFormList.add(ReportDateForm.of(x)));
		
		return reportDateFormList;
	}

}
