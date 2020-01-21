package com.example.WeeklyReport.env.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.WeeklyReport.env.entity.ReportDate;

@Mapper
public interface ReportDateMapper {
	
	ReportDate findLatest();
	
	List<ReportDate> findList();
	
	void insert(@Param("date") LocalDate date, @Param("deleteFlg") boolean deleteFlg);
}
