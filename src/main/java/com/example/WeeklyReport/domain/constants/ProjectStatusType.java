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
	
	public String getLabel() {
		return label;
	}

	public String getCode() {
		return code;
	}

	public static ProjectStatusType getProjectStatusType(String value) {
		switch(value) {
		case "open":
		case "10":
			return OPEN;
		case "close":
		case "20":
			return CLOSE;
		default:
			return null;
		}
	}
}
