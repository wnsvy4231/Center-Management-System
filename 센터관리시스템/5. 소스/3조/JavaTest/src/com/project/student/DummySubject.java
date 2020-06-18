package com.project.student;

public class DummySubject {

	public static int temp = 10;
	private int seq;			//교과목번호
	private String name;		//교육과정
	private String subject;		//교과목
	private String c;			//교육기간(끝나는 날)
	private String c_1;			//교육기간(시작하는 날)
	private String place;		//교육장소
	private String time;		//교육일정
	private int room_num;		//강의실번호
	private int people;			//모집인원
	private String area;		//선호 지역
	private String std_satisfy;	//수강생 만족도
	private String emp_ratio;	//취업률
	private int cost;			//비용
	private int key;			//고유번호
	
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStd_satisfy() {
		return std_satisfy;
	}
	public void setStd_satisfy(String std_satisfy) {
		this.std_satisfy = std_satisfy;
	}
	public String getEmp_ratio() {
		return emp_ratio;
	}
	public void setEmp_ratio(String emp_ratio) {
		this.emp_ratio = emp_ratio;
	}
	public String getC_1() {
		return c_1;
	}
	public void setC_1(String c_1) {
		this.c_1 = c_1;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public static int getTemp() {
		return temp;
	}
	public static void setTemp(int temp) {
		DummySubject.temp = temp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public int getRoom_num() {
		return room_num;
	}
	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	
}//Subject