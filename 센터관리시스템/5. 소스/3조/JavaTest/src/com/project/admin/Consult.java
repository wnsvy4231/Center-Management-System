package com.project.admin;


public class Consult {
	private int seq;
	private String state;
	private String date;
	private String student;
	private String context;
	private String answer;
	public static int temp;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		if(checkName(student)) {
		this.student = student;
		} else {
			System.out.println("유효하지 않는 이름입니다.");
		}
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	private boolean checkName(String student) {
		if (student.length() > 5)
			return false;
		for (int i = 0; i < student.length(); i++) {
			char c = student.charAt(i);
			if ((c < '가' || c > '힣') && (c == ' ')) // 공백도 포함 잘못된거를 찾는거니까 이(한글)에서 false니까
			{
				return false;
			}
		}
		return true;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
