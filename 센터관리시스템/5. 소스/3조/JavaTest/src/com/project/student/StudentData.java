package com.project.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentData { //관리자모드 > 3.수강생 관리
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> list = new ArrayList<Student>();
	
	public void studentData() throws Exception {
	
		read();
		
		boolean loop = true;
		
		while (loop) {
			
			Output.menu();
			
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				//학생 목록
				list();
			} else if (sel.equals("2")) {
				//학생 추가
				add();
			} else if (sel.equals("3")) {
				//학생 삭제
				delete();
			} else if (sel.equals("4")) {
				//학생 검색
				search();
			} else if (sel.equals("5")) {
				//학생 수정
				correct();
			} else {
				//프로그램 종료
				loop = false;
			}
			
		}		
	
	}

	private void read() throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\수강생.txt"));
		File file = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\수강생.txt");
		String line = null;
		
		if (file.exists()) {
			while ((line = reader.readLine()) != null) {
				
				//객체 생성
				Student s = new Student();
				
				String[] temp = line.split(",");
				
				int seq = Integer.parseInt(temp[0]);
				int age = Integer.parseInt(temp[2]);
				int gender = Integer.parseInt(temp[3]);
				int score = Integer.parseInt(temp[6]);
				int room = Integer.parseInt(temp[10]);
				
				s.setSeq(seq);
				s.setName(temp[1]);
				s.setAge(age);
				s.setGender(gender);
				s.setTel(temp[4]);
				s.setAddress(temp[5]);
				s.setScore(score);
				s.setGrade(temp[7]);
				s.setJob(temp[8]);
				s.setPay(temp[9]);				
				s.setRoom_num(room);
				s.setMemo(temp[11]);
				
				list.add(s);
				
			}
		}
		
		reader.close();
	}
	
	private void correct() { //학생 수정
		
		Output.title(Title.CORRECT);
		
		System.out.println("[번호]\t[이름]\t[나이]\t[성별]\t[전화번호]\t[주소]\t\t[성적]\t[등급]\t[취업]\t[결재]");
		
		for (Student s : list) {			

				System.out.printf("%5d\t%s\t  %d\t  %s\t%s\t%s\t%4d\t%4s\t%4s\t%4s\n"
						, s.getSeq()
						, s.getName()
						, s.getAge()
						, s.getGender() == 1 ? "남" : "여"
						, s.getTel()
						, s.getAddress()
						, s.getScore()
						, s.getGrade()
						, s.getJob()
						, s.getPay());
			
		}
		
		System.out.print("수정(학생명) : ");
		String word = scan.nextLine();
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		System.out.print("나이 : ");
		int age = scan.nextInt();	
		scan.skip("\r\n");
		
		System.out.print("성별(남자:1, 여자:2) : ");
		int gender = scan.nextInt();
		scan.skip("\r\n");
		
		System.out.print("연락처 : ");
		String tel = scan.nextLine();
		
		System.out.print("주소 : ");
		String address = scan.nextLine();
		
		System.out.print("취업여부 : ");
		String job = scan.nextLine();
		
		System.out.print("결재여부 : ");
		String pay = scan.nextLine();	
		
		
		
		
		System.out.println("[번호]\t[이름]\t[나이]\t[성별]\t[전화번호]\t[주소]\t\t[성적]\t[등급]\t[취업]\t[결재]");
		
		for (Student s : list) {
				
			if (s.getName().contains(word)) {
				
				s.setName(name);
				s.setAge(age);
				s.setGender(gender);
				s.setTel(tel);
				s.setAddress(address);
				s.setJob(job);
				s.setPay(pay);
				
				System.out.printf("%5d\t%s\t  %d\t  %s\t%s\t%s\t%4d\t%4s\t%4s\t%4s\n"
						, s.getSeq()
						, s.getName()
						, s.getAge()
						, s.getGender() == 1 ? "남" : "여"
						, s.getTel()
						, s.getAddress()
						, s.getScore()
						, s.getGrade()
						, s.getJob()
						, s.getPay());
			}
			
		}
		
		filewrite();
		
		Output.pause(scan);
		
	} //학생 수정

	private void search() { //학생 검색
		
		Output.title(Title.SEARCH);
		
		
		System.out.print("검색(학생명) : ");
		String word = scan.nextLine();
		
		System.out.println("[번호]\t[이름]\t[나이]\t[성별]\t[전화번호]\t[주소]\t\t[성적]\t[등급]\t[취업]\t[결재]");
		
		for (Student s : list) {			
			
			if (s.getName().contains(word)) {
				System.out.printf("%5d\t%s\t  %d\t  %s\t%s\t%s\t%4d\t%4s\t%4s\t%4s\n"
						, s.getSeq()
						, s.getName()
						, s.getAge()
						, s.getGender() == 1 ? "남" : "여"
						, s.getTel()
						, s.getAddress()
						, s.getScore()
						, s.getGrade()
						, s.getJob()
						, s.getPay());
			}
			
		}
		
		Output.pause(scan);
		
	} //학생 검색

	private void delete() { //학생 삭제
		
		Output.title(Title.DELETE);
		
		listName();
		
		System.out.print("삭제할 번호 : ");
		int seq = scan.nextInt();
		scan.skip("\r\n");
		
		for(int i=0; i<list.size(); i++) {
			
			if(list.get(i).getSeq() == seq) {
				list.remove(i);
				break;
			}
			
		}
		
		filewrite();
		
		list.clear();
		Student.mainTemp = 0;
		
		try {
			read();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Output.pause(scan);
		
	} //학생 삭제

	private void add() { //학생 추가
		
		Output.title(Title.ADD);
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		System.out.print("나이 : ");
		int age = scan.nextInt();	
		scan.skip("\r\n");
		
		System.out.print("성별(남자:1, 여자:2) : ");
		int gender = scan.nextInt();
		scan.skip("\r\n");
		
		System.out.print("연락처 : ");
		String tel = scan.nextLine();
		
		System.out.print("주소 : ");
		String address = scan.nextLine();
		
		System.out.print("성적 : ");
		int score = scan.nextInt();
		scan.skip("\r\n");
		
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
		
		System.out.print("취업여부 : ");
		String job = scan.nextLine();
		
		System.out.print("결재여부 : ");
		String pay = scan.nextLine();
		
		
		//입력받은 정보 > Student 객페 포장
		Student s = new Student();
		
		Student.temp++; //일련 번호
		
		s.setSeq(Student.temp);
		s.setName(name);
		s.setAge(age);
		s.setAddress(address);
		s.setTel(tel);
		s.setGender(gender);
		s.setScore(score);
		s.setGrade(grade);
		s.setJob(job);
		s.setPay(pay);
		s.setRoom_num(0);
		s.setMemo("없음");
		
		//학생 목록 추가 (******)
		list.add(s);
		
		filewrite();
		
		list.clear();
		Student.mainTemp = 0;
		
		try {
			read();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//잠시 멈춤
		Output.pause(scan);	
		
	} //학생 추가

	private void filewrite() { //덮어쓰기
		
		String path = "C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\수강생.txt";
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path, false));
			
			for (int i=0; i<list.size(); i++) {
				
				writer.write(list.get(Student.mainTemp).getSeq() + "," + list.get(Student.mainTemp).getName() + "," 
							+ list.get(Student.mainTemp).getAge() + "," + list.get(Student.mainTemp).getGender() + "," 
							+ list.get(Student.mainTemp).getTel() + "," + list.get(Student.mainTemp).getAddress() + "," 
							+ list.get(Student.mainTemp).getScore() + "," + list.get(Student.mainTemp).getGrade() + "," 
							+ list.get(Student.mainTemp).getJob() + "," + list.get(Student.mainTemp).getPay() + "," 
							+ list.get(Student.mainTemp).getRoom_num() + "," + list.get(Student.mainTemp).getMemo() + "\r\n");
						Student.mainTemp++;
				
			}
			
			writer.close();			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		
	} //덮어쓰기

	private void list() { //학생 목록
		
		Output.title(Title.LIST);
		
		listName();
		
		Output.pause(scan);
		
	}

	private void listName() {
		
		System.out.println("[번호]\t[이름]\t[나이]\t[성별]\t[전화번호]\t[주소]\t\t[성적]\t[등급]\t[취업]\t[결재]");
		
		for (Student s : list) {
			
			System.out.printf("%5d\t%s\t  %d\t  %s\t%s\t%s\t%4d\t%4s\t%4s\t%4s\n"
								, s.getSeq()
								, s.getName()
								, s.getAge()
								, s.getGender() == 1 ? "남" : "여"
								, s.getTel()
								, s.getAddress()
								, s.getScore()
								, s.getGrade()
								, s.getJob()
								, s.getPay());		
			
		}
		
	} //학생 목록

}
