package com.example.WeeklyReport.web.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.WeeklyReport.domain.dto.ReportDateDto;
import com.example.WeeklyReport.domain.dto.ReportDto;
import com.example.WeeklyReport.domain.service.ReportService;
import com.example.WeeklyReport.env.entity.Report;
import com.example.WeeklyReport.web.form.ReportDateForm;
import com.example.WeeklyReport.web.form.ReportForm;

@RestController
@RequestMapping("/api/report")
@CrossOrigin
public class ReportController {

	@Autowired
	ReportService reportService;

	@GetMapping
	public ReportForm fetch(@RequestParam String id) {

		ReportDto reportDto = reportService.fetch(Integer.parseInt(id));

		ReportForm reportForm = ReportForm.of(reportDto);

		return reportForm;
	}

	@GetMapping("/list")
	public List<ReportForm> fetchList(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam LocalDate date) {

		List<ReportDto> reportDtoList = reportService.fetchList(date);

		List<ReportForm> reportFormList = new ArrayList<ReportForm>();

		reportDtoList.stream().forEach(x -> reportFormList.add(ReportForm.of(x)));

		return reportFormList;
	}

	@GetMapping("/dateList")
	public List<ReportDateForm> fetchDateList() {

		List<ReportDateForm> reportDateFormList = new ArrayList<ReportDateForm>();

		List<ReportDateDto> reportDateDtoList = reportService.fetchDateList();

		reportDateDtoList.stream().forEach(x -> reportDateFormList.add(ReportDateForm.of(x)));

		return reportDateFormList;
	}

	@PostMapping("/new")
	public List<Report> create() {

		List<Report> reportList = reportService.create();

		return reportList;
	}

	@PostMapping("/edit")
	public Report update(@RequestParam String id, @RequestBody ReportForm reportForm) {

		ReportDto reportDto = new ReportDto(Integer.parseInt(id), null, reportForm.getThisWeekCondition(),
				reportForm.getThisWeekPlan(), reportForm.getThisWeekResult(), reportForm.getProblem(),
				reportForm.getNextWeekPlan(), null, null, null);

		Report report = reportService.update(reportDto);

		return report;
	}
	
	@PostMapping("/editMemo")
	public List<ReportDto> updateMemo(@RequestBody List<ReportForm> reportFormList) {

		
		List<ReportDto> reportDtoList = new ArrayList<ReportDto>();
		for(ReportForm reportForm : reportFormList) {
			ReportDto reportDto = new ReportDto();
			reportDto.setId(reportForm.getId());
			reportDto.setMemo(reportForm.getMemo());
			
			reportDtoList.add(reportDto);
		}
		
		List<ReportDto> list = reportService.updateMemo(reportDtoList);

		return list;
	}

}
