package com.project.teacher;

public class Teacher_Student_Management {
	private int seq;
	private String name;
	private int classroom;
	private String grade;
	private String memo;
	private int score;
	private String teacher;
	private int key;
	
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		if(checkName(teacher))
		this.teacher = teacher;
	}
	public static int temp;
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		if(seq>0)
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(checkName(name))
			this.name = name;
	}
	private boolean checkName(String name) {
		if (name.length() > 5)
			return false;
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if ((c < '가' || c > '힣') && (c == ' ')) // 공백도 포함 잘못된거를 찾는거니까 이(한글)에서 false니까
			{
				return false;
			}
		}
		return true;
	}
	public int getClassroom() {
		return classroom;
	}
	public void setClassroom(int classroom) {
		if(checkclassroom(classroom))
			this.classroom = classroom;
		else {
			System.out.println("유효하지 않는 반번호입니다.");
		}
	}
	private boolean checkclassroom(int classroom) {
		if(classroom<0 && classroom>10)
			return false;
		else return true;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		if(checkgrade(grade))
		this.grade = grade;
	}
	private boolean checkgrade(String grade) {
		if(grade.equals("A") || grade.equals("B") || grade.equals("C") || grade.equals("D") || grade.equals("F"))
			return true;
		else return false;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		if(score>0)
		this.score = score;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		if(key>0)
		this.key = key;
	}
	

}
