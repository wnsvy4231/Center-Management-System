package com.project.guest;

public class RecommendList {
	private String num; 					// 번호
	private String curriculum; 		// 교육과정
	private String month; 				// 시작 월
	private String area; 					// 지역
	private String happy;				// 만족도
	private String jop;						// 취업률
	
	
	
	
	
	
	public String getNum() {
		return num;
	}
	public RecommendList(String num, String curriculum, String month, String area, String happy, String jop) {
		this.num = num;
		this.curriculum = curriculum;
		this.month = month;
		this.area = area;
		this.happy = happy;
		this.jop = jop;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCurriculum() {
		return curriculum;
	}
	@Override
	public String toString() {
		
		
		return String.format("%s %-58s\t%4s %11s %16s %7s\r\n", num,curriculum,month,area,happy,jop);
		
	}
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getHappy() {
		return happy;
	}
	public void setHappy(String happy) {
		this.happy = happy;
	}
	public String getJop() {
		return jop;
	}
	public void setJop(String jop) {
		this.jop = jop;
	}
	
	

}
