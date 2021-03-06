package com.project.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentScore { //수강생 모드 > 2.성적 확인
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> list = new ArrayList<Student>();
	ArrayList<Guest> list2 = new ArrayList<Guest>();
	
	public void studentScore() throws Exception {
		Login ro = new Login();
		int a = ro.stdNum;
		
		//수강생,교육과정 데이터 호출
		BufferedReader reader = new BufferedReader(new FileReader("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\수강생.txt"));
		BufferedReader reader2 = new BufferedReader(new FileReader("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\교과과정.txt"));
		File file = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\수강생.txt");
		File file2 = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\교과과정.txt");
		String line = null;
		
		if (file.exists() && file2.exists()) { //파일 체크 & 배열에 담기
			while ((line = reader.readLine()) != null) {
				
				Student s = new Student(); //수강생
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
				
				list.add(s);
				
			}
			while ((line = reader2.readLine()) != null) {
					
					Guest g = new Guest(); //교육과정
					String[] temp = line.split(",");
					
					int seq = Integer.parseInt(temp[0]);
					int Room_num = Integer.parseInt(temp[5]);
					int people = Integer.parseInt(temp[11]);
					
					g.setSeq(seq);
					g.setName(temp[1]);
					g.setSubject(temp[2]);
					g.setC(temp[3]);
					g.setC_1(temp[4]);
					g.setRoom_num(Room_num);
					g.setPlace(temp[6]);
					g.setTime(temp[7]);
					g.setStd_satisfy(temp[8]);
					g.setArea(temp[9]);
					g.setEmp_ratio(temp[10]);
					g.setPeople(people);
					
					list2.add(g);
									
			}
		}
		
		reader.close();
		reader2.close();
		
		int count = 0;
		for (int i=0; i<list2.size(); i++) {
			
			if (list.get(a).getRoom_num() == list2.get(i).getRoom_num()) {
				
				count = i;
				
			}
		
		}
		
		Output.title(Title.STUDENTINFO);
		
		System.out.println("[이름]\t[과정명]\t\t\t\t\t\t[성적]\t[등급]");
		
		System.out.printf("%s\t%s\t%4d\t%4s"
								, list.get(a).getName()
								, list2.get(count).getName()
								, list.get(a).getScore()
								, list.get(a).getGrade());
			
		System.out.println();
		
		Output.pause(scan);		
		
	}

}
