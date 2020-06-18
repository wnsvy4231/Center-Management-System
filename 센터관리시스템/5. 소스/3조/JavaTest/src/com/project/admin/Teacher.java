package com.project.admin;

public class Teacher {
	public static int temp;
	private int seq;		//강사번호
	private int key;
	private String name; 	//강사 이름
	private int age; 		//강사 나이
	private String address; //강사 주소
	private String tel; 	//강사 연락처
	private String subject;
	private int gender;
	
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		if (checkSubject(subject))
			this.subject = subject;
		else {
			System.out.println("유효하지 않는 과목입니다.");
		}
	}
	private boolean checkSubject(String subject) {
		if(subject.length()>30) {
			return false;
		}
		for (int i = 0; i < subject.length(); i++) {
			char c = subject.charAt(i);
			if ((c < 'a' || c > 'z') && (c < '0' || c > '9') 
									 && (c < 'A' || c > 'Z') 
									 && (c < '가' || c > '힣')
									 && (c != ' ') // 공백도 포함 잘못된거를 찾는거니까 이(한글)에서 false니까
									 && (c != '#'))
			{
				return false;
			}
		} 
		return true;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		if(key>0)
		this.key = key;
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
	@Override
	public String toString() {
		return "Teacher [seq=" + seq + ", key=" + key + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", tel=" + tel + ", subject=" + subject + ", gender=" + String.format("%s", gender == 1 ? "남자":"여자") + "]";
	}
	
    
}
