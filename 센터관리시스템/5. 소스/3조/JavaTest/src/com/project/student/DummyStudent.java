package com.project.student;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class DummyStudent { // 수강생 더미데이터
	
	static ArrayList<Student> list = new ArrayList<Student>();
	
	public static void main(String[] args) throws Exception {
		
		FileWriter writer = new FileWriter("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\수강생.txt");
		
			String[] temp1 = { "김", "이", "박", "최", "정", "백", "장", "구", "주", "홍", "신", "안"
					, "오", "윤", "조", "한", "고", "남", "양", "서", "송", "천", "차", "문", "천"};
			String[] temp2 = { "유", "정", "석", "인", "지", "은", "형", "순", "성", "민", "정"
					, "민", "우", "동", "준", "진", "표", "현", "연", "시", "호", "태", "수", "나"
					, "승", "환", "윤", "종", "하", "혁", "원", "성", "희", "규", "경", "서", "채"
					, "혁", "효", "강", "경", "선", "소", "찬", "영", "호", "훈", "주", "재", "철" };
			String[] temp3 = { "서울시", "인천시", "부산시", "대전시", "광주시", "대구시", "목포시"
					, "창원시", "울산시", "제주시", "성남시", "남양주시", "김포시", "구리시", "강릉시"
					, "천안시", "전주시", "여수시", "나주시", "포항시", "사천시", "거제시" };
			String[] temp4 = { "강남구", "강서구", "강북구", "강동구", "종로구", "중구", "용산구"
					, "성동구", "동대문구", "성북구", "도봉구", "금천구", "동작구", "관악구", "서초구"
					, "동구", "서구", "남구", "북구", "수성구", "송파구", "사하구", "연제구", "달서구" };
//			String[] temp5 = { "남", "여" };
//			String[] temp6 = { "자바", "자바스크립트", "파이썬", "유니티", "C" };
//			String[] temp7 = { "A", "B", "C", "D", "F" };
			String[] temp8 = { "O", "X" };
			
			Random rnd = new Random();
			
			for (int i=0; i<300; i++) {
				
				Student s = new Student();
				Student.temp++;
				s.setSeq(Student.temp);
							
				String name = temp1[rnd.nextInt(temp1.length)]
							+ temp2[rnd.nextInt(temp2.length)]
							+ temp2[rnd.nextInt(temp2.length)];
				int age = rnd.nextInt(10) + 20;
				String address = temp3[rnd.nextInt(temp3.length)]
							+ " "
							+ temp4[rnd.nextInt(temp4.length)];
				int gender = rnd.nextInt(2) + 1;
//				String subject = temp6[rnd.nextInt(temp6.length)];
				String tel = "010-" + (rnd.nextInt(9000) + 1000)
							+ "-" + (rnd.nextInt(9000) + 1000);
				int score = rnd.nextInt(50) + 50;
				String grade = "";
	
				if (score <= 100 && score > 90) {
					grade = "A";
				} else if (score <= 90 && score > 80) {
					grade = "B";
				} else if (score <= 80 && score > 70) {
					grade = "C";
				} else if (score <= 70 && score > 60) {
					grade = "D";
				} else {
					grade = "F";
				}
				
				String job = temp8[rnd.nextInt(temp8.length)];
				String pay = temp8[rnd.nextInt(temp8.length)];
				int room_num = rnd.nextInt(10) + 1;
				String memo = "없음";
				
				s.setName(name);
				s.setAge(age);
				s.setAddress(address);
				s.setGender(gender);
				s.setTel(tel);
				s.setScore(score);
				s.setGrade(grade);
				s.setJob(job);
				s.setPay(pay);
				s.setRoom_num(room_num);
				
				list.add(s);
				
				writer.write(s.getSeq() + "," + name + "," + age + "," + gender + "," + tel + "," 
				+ address + "," + score + "," + grade + "," + job + "," + pay + "," + room_num + "," + memo + "\r\n");
				
			}
			
			writer.close();
		
	}
	
	

}
