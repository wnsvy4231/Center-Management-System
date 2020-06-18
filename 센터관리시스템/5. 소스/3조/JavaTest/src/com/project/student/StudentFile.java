package com.project.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class StudentFile { //수강생 모드 > 4.수업 자료 확인
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> list = new ArrayList<Student>();
	ArrayList<Data> list2 = new ArrayList<Data>();
	
	public void studentFile() throws Exception {
		Login ro = new Login();
		int a = ro.stdNum;
		
		//수강생 데이터 호출
		BufferedReader reader = new BufferedReader(new FileReader("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\수강생.txt"));
		File file = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\수강생.txt");
		String line = null;
		
		if (file.exists()) { //파일 체크 & 배열에 담기
			while ((line = reader.readLine()) != null) {
				
				Student s = new Student();
				String[] temp = line.split(",");
				
				int seq = Integer.parseInt(temp[0]);
				int age = Integer.parseInt(temp[2]);
				int gender = Integer.parseInt(temp[3]);
				int score = Integer.parseInt(temp[6]);
				int room_num = Integer.parseInt(temp[10]);
				
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
				s.setRoom_num(room_num);
				
				list.add(s);
				
			}
		}
		
		int cnt = list.get(a).getRoom_num(); //학생의 강의실번호

		//강의실 번호에 맞는 수업자료 호출
		String path = String.format("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\수업자료\\수업자료%d.txt", cnt);
		BufferedReader reader2 = new BufferedReader(new FileReader(path));
		File file2 = new File(path);
		
		if (file2.exists()) { //파일 체크 & 배열에 담기
			
			while ((line = reader2.readLine()) != null) {
					
					Data d = new Data();
					String temp = line;
					
					d.setSentence(temp);					
					
					list2.add(d);
									
			}
		}
		
		reader.close();
		reader2.close();
		int count = 1;
		Date date = new Date(file2.lastModified());		
		
		Output.title(Title.STUDENTFILE);
		System.out.println(file2.getName());
		
		System.out.println("[번호]\t[이름]\t\t[수정한 날짜]\t\t[내용]");
		
		System.out.printf("%3d\t%s\t%tF %tT\t%s"
					, count
					, file2.getName()
					, date
					, date
					, list2.get(1).getSentence());
			
		System.out.println();
		
		Output.pause(scan);		
		
	}

}
