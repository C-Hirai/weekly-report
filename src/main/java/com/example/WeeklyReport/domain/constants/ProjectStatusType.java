package com.example.WeeklyReport.domain.constants;

public enum ProjectStatusType {

	OPEN("open", "10"),
	CLOSE("close", "20");
	
	private String label;
	private String code;
	
	private ProjectStatusType(String label, String code) {
		this.label = label;
		this.code = code;
	}
	
	public static String getLabel(String code) {
		switch(code) {
		case "10":
			return OPEN.label;
		case "20":
			return CLOSE.label;
		default:
			return "";
		}
	}
	
	public static String getCode(String label) {
		switch(label) {
		case "open":
			return OPEN.code;
		case "close":
			return CLOSE.code;
		default:
			return "";
		}
	}
}
