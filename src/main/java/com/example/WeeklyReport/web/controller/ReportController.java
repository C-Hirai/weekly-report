package com.example.WeeklyReport.web.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/{reportId}")
	public ReportForm fetch(@PathVariable String reportId) {

		ReportDto reportDto = reportService.fetch(Integer.parseInt(reportId));

		ReportForm reportForm = ReportForm.of(reportDto);

		return reportForm;
	}

	@GetMapping
	public List<ReportForm> fetchList(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam LocalDate date) {

		List<ReportDto> reportDtoList = reportService.fetchList(date);

		List<ReportForm> reportFormList = new ArrayList<ReportForm>();

		reportDtoList.stream().forEach(x -> reportFormList.add(ReportForm.of(x)));

		return reportFormList;
	}

	@GetMapping("/list")
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

}
