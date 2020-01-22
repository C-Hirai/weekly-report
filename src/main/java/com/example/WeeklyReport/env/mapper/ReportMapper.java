package com.example.WeeklyReport.env.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.WeeklyReport.env.entity.Report;

@Mapper
public interface ReportMapper {

	Report findById(int id);

	Report findLastWeek(@Param("reportDateId") int reportDateId, @Param("projectId") int projectId);

	List<Report> findListById(int reportDateId);

	void insert(Report report);
	
	void update(Report report);
	
	void updateMemo(@Param("id") int Id, @Param("memo") String memo);
}
