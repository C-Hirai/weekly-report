package com.example.WeeklyReport.env.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.WeeklyReport.env.entity.Report;
import com.example.WeeklyReport.env.entity.ReportDate;

@Mapper
public interface ReportMapper {
	
	Report findById(int reportId);
	
	List<Report> findListById(int weekId);
	
	ReportDate findLatestDate();
	
	void insert(@Param("date") LocalDate date, @Param("deleteFlg") boolean deleteFlg);
	
	List<ReportDate> findDateList();
}
