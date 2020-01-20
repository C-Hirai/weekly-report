package com.example.WeeklyReport.env.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.WeeklyReport.env.entity.Report;
import com.example.WeeklyReport.env.entity.ReportDate;

@Mapper
public interface ReportMapper {
	
	Report findById(int reportId);
	
	List<Report> findListById(int weekId);
	
	List<ReportDate> findDateList();
}
