package com.project.student;

//Student 클래스의 역할 : 데이터 집합
public class Student {
	
	public static int temp = 300;
	public static int mainTemp;
	private int seq;			//학생번호
	private String name;		//이름
	private int age;			//나이
	private String address;		//주소
	private int gender;			//성별
	private String tel;			//연락처
	private int score;			//성적
	private String grade;		//등급
	private String job;			//취업여부
	private String pay;			//결재여부
	private int room_num;		//강의실번호
	private String memo;		//메모
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (checkName(name))
			this.name = name;
		else
			System.out.println("유효하지 않는 이름입니다.");
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
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if (age < 1 || age > 150) {
			System.out.println("유효하지 않는 나이입니다.");
		} else {
			this.age = age;
		}
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if (checkAddress(address)) {
			this.address = address;
		} else {
			System.out.println("유효하지 않는 주소입니다.");
		}
	}
	private boolean checkAddress(String address) {
		if (address.length() > 15)
			return false;
		for (int i = 0; i < address.length(); i++) {
			char c = address.charAt(i);
			if ((c < '가' || c > '힣') && c!=' ') // 공백도 포함 잘못된거를 찾는거니까 이(한글)에서 false니까
			{
				return false;
			}
		}
		return true;
	}	
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		if(checkTel(tel))
			this.tel = tel;
		}
		private boolean checkTel(String tel) {
			String num = tel.replace("-", "");
			if (num.length() > 11)
				return false;
			for (int i = 0; i < num.length(); i++) {
				char c = num.charAt(i);
				if ((c < '0' || c > '9') && c == ' ') // 공백도 포함 잘못된거를 찾는거니까 이(한글)에서 false니까
				{
					return false;
				}
			}
			return true;
		}
	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		if (gender == 1 || gender == 2) {
			this.gender = gender;
		} else {
			System.out.println("유효하지 않는 성별입니다.");
		}
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		if (score < 0 || score > 100) {
			System.out.println("유효하지 않는 성적입니다.");
		} else {
			this.score = score;
		}
	}
	
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		if (job.equals("O") || job.equals("X")) {
			this.job = job;
		} else {
			System.out.println("유효하지 않는 방식입니다.");
		}
	}
	
	
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		if (pay.equals("O") || pay.equals("X")) {
			this.pay = pay;
		} else {
			System.out.println("유효하지 않는 방식입니다.");
		}
	}
	
	public int getRoom_num() {
		return room_num;
	}
	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}
	
	
	@Override
	public String toString() {
		return "Student [seq=" + seq + ", name=" + name + ", age=" + age + ", address=" + address + ", gender=" + gender
				+ ", tel=" + tel + ", score=" + score + ", grade=" + grade + ", job=" + job + ", pay=" + pay + "]\n";
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
