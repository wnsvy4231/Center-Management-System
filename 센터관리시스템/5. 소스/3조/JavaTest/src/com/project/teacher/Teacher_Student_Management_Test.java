package com.project.teacher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.project.teacher.Teacher_Login;

public class Teacher_Student_Management_Test {
		

		private static Teacher_Student_Management_Output output;
		private static Scanner scan;
		private static HashMap<Integer, Teacher_Student_Management> map;
		private static  int i = 1;

		static {
			output = new Teacher_Student_Management_Output();
			scan = new Scanner(System.in);
			map = new HashMap<Integer,Teacher_Student_Management>();
		}

		public static void  Teacher_Management(String id) {
			//main(String[] aaa)
			try {
				String path = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\학생관리";
				File dir = new File(path);
				boolean loop = false;
				for(File list:dir.listFiles()) {
					if(list.isFile()) {
						loop = true;
					} else {
						loop = false;
					}
				}
				
				
				if(!loop) {
					dummy();
				} else {
					read();
				}
				
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			
			boolean loop = true;

			while (loop) {

				output.menu();

				String sel = scan.nextLine();

				if (sel.equals("1")) {
					add();
				} else if (sel.equals("2")) {
					correct();
				} else if(sel.equals("3")) {
					delete();
				}
				else if(sel.equals("4")) {
					search();
				} else if(sel.equals("5")) {
					search1();
				} else if(sel.equals("6")) {
					list();
				} else if(sel.equals("7")) {
					loop = false;
				}

			}
			output.pause(scan);
			Teacher_Login.teacher(id);

		} // main

		private static void search1() {
			System.out.print("검색(강의실): "); // 홍길동 > 길동 검색률을 높임
			int classroom = scan.nextInt();
			scan.skip("\r\n");
			try {
				read();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("[번호]\t[이름]\t[배정 받은 강의실]\t[선생님]\t\t[점수]\t[성적]\t[메모]");
			Set<Integer> set = map.keySet();
			for (Integer key : set) {

				if (map.get(key).getClassroom()==classroom) {
					System.out.printf("%3d\t%s\t\t%d\t\t\t%s\t\t%d\t\t%s\t%s\n",
							map.get(key).getSeq(),map.get(key).getName(),map.get(key).getClassroom(),map.get(key).getTeacher(),
							map.get(key).getScore(),map.get(key).getGrade(),map.get(key).getMemo());

				}
			}
			map.clear();
			Teacher_Student_Management.temp=0;
			output.pause(scan);
			
		}

		private static void delete() {
			output.title(Teacher_Student_Management_Title.DELETE);
			
			list();
			try {
				read();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.out.print("삭제할 번호: ");
			int seq = scan.nextInt();
			scan.skip("\r\n");
		
			Set<Integer> keys = map.keySet(); 
			Iterator<Integer> kiter = keys.iterator();
			
			while(kiter.hasNext()) {
				Integer key = kiter.next();
				if (map.get(key).getSeq() == seq) {
					map.remove(key);
					break; 
				}
			}
			//System.out.println(map.size());
			filewrite();
			
			map.clear();
			Teacher_Student_Management.temp=0;
			output.pause(scan);
			
			
		}
		

		private static void read() throws Exception {
			map.clear();
			Teacher_Student_Management.temp=0;
			String path = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\학생관리\\학생관리.txt";
				BufferedReader reader = new BufferedReader(new FileReader(path));
				String line = null;
				while((line=reader.readLine())!=null) {
					Teacher_Student_Management.temp++;	
					String[] item = line.split(",");
					map.put(Teacher_Student_Management.temp,new Teacher_Student_Management());
					map.get(Teacher_Student_Management.temp).setSeq(Integer.parseInt(item[0]));
					map.get(Teacher_Student_Management.temp).setName((item[1]));
					map.get(Teacher_Student_Management.temp).setClassroom((Integer.parseInt(item[2])));
					map.get(Teacher_Student_Management.temp).setTeacher((item[3]));
					map.get(Teacher_Student_Management.temp).setScore(Integer.parseInt((item[4])));
					map.get(Teacher_Student_Management.temp).setGrade((item[5]));
					map.get(Teacher_Student_Management.temp).setMemo((item[6]));
					map.get(Teacher_Student_Management.temp).setKey((Integer.parseInt(item[7])));
					
					
				}
			reader.close();
			
			
		}

		private static void correct() {
			output.title(Teacher_Student_Management_Title.CORRECT);
			System.out.println("수강생 수정: ");

			list();

			Set<Integer> set = map.keySet();
			System.out.print("수정할 수강생 번호(고유번호): ");
			int num = scan.nextInt();
			scan.nextLine();

			System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
			System.out.println("1. 이름 (수강생)");
			System.out.println("2. 강의실");
			System.out.println("3. 점수");
			System.out.println("4. 메모");
			System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
			System.out.print("수정할 번호: ");
			int num1 = scan.nextInt();
			scan.nextLine();
			boolean loop = true;
			try {
				read();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (loop) {
				switch (num1) {
				case 1:
					System.out.print("이름(수강생): ");
					String name = scan.nextLine();
					if(checkName(name)) {
					map.get(num).setName(name);
					}
					else {
						System.out.println("유효하지 않는 학생이름입니다.");
					}
					loop = false;
					break;
				case 2:
					System.out.print("강의실(1~10): ");
					int classroom = scan.nextInt();
					scan.skip("\r\n");
					map.get(num).setClassroom(classroom);
					loop = false;
					break;
				case 3:
					System.out.print("점수: ");
					int score = scan.nextInt();
					scan.skip("\r\n");
					map.get(num).setScore(score);
					if(score>=90) {
						map.get(num).setGrade("A");
					} else if(score>=80) {
						map.get(num).setGrade("B");
					} else if(score>=70) {
						map.get(num).setGrade("C");
					} else if(score>=60) {
						map.get(num).setGrade("D");
					} else {
						map.get(num).setGrade("F");
					}
					loop = false;
					break;
				case 4:
					System.out.print("메모: ");
					String memo = scan.nextLine();
					map.get(num).setMemo(memo);
					loop = false;
					break;
				default:
					System.out.println("잘못된 숫자를 입력하셨습니다.");
				}
			}
			filewrite();
			map.clear();
			Teacher_Student_Management.temp=0;
			
		}

		private static void add() {
			output.title(Teacher_Student_Management_Title.ADD);

			System.out.print("이름(수강생): ");
			String name = scan.nextLine();

			System.out.print("강의실(1~10): ");
			int classroom = scan.nextInt();
			scan.skip("\r\n");
			
			System.out.print("점수: ");
			int score = scan.nextInt();
			scan.skip("\r\n");

			System.out.print("선생님: ");
			String teacher = scan.nextLine();
			
			System.out.print("메모: ");
			String memo = scan.nextLine();
			
			
			try {
				read();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Teacher_Student_Management.temp++; // 공용변수, 살아있는 변수
			
			map.put(Teacher_Student_Management.temp, new Teacher_Student_Management());
			map.get(Teacher_Student_Management.temp).setSeq(Teacher_Student_Management.temp); // 자기 개인 번호로 받아
			if(checkName(name))
			map.get(Teacher_Student_Management.temp).setName(name);
			else {
				System.out.println("유효하지 않는 학생이름입니다.");
			}
			map.get(Teacher_Student_Management.temp).setTeacher(teacher);
			map.get(Teacher_Student_Management.temp).setClassroom(classroom);;
			if(score>=90) {
				map.get(Teacher_Student_Management.temp).setGrade("A");
			} else if(score>=80) {
				map.get(Teacher_Student_Management.temp).setGrade("B");
			} else if(score>=70) {
				map.get(Teacher_Student_Management.temp).setGrade("C");
			} else if(score>=60) {
				map.get(Teacher_Student_Management.temp).setGrade("D");
			} else {
				map.get(Teacher_Student_Management.temp).setGrade("F");
			}
			map.get(Teacher_Student_Management.temp).setScore(score);
			map.get(Teacher_Student_Management.temp).setMemo(memo);
			map.get(Teacher_Student_Management.temp).setKey(Teacher_Student_Management.temp);
			
			
		
			try {
				String path = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\학생관리\\학생관리.txt";
				File file = new File(path);
				BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
				writer.write(map.get(Teacher_Student_Management.temp).getSeq() + "," + map.get(Teacher_Student_Management.temp).getName() 
						+ "," + map.get(Teacher_Student_Management.temp).getClassroom() + "," + 
						map.get(Teacher_Student_Management.temp).getTeacher()+ "," + map.get(Teacher_Student_Management.temp).getScore()+ "," +  map.get(Teacher_Student_Management.temp).getGrade()+","
						+ map.get(Teacher_Student_Management.temp).getMemo()+","
						+map.get(Teacher_Student_Management.temp).getKey()+"\r\n");
				writer.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 잠시 멈춤
			map.clear();
			Teacher_Student_Management.temp=0;
			output.pause(scan); // 매개변수로 scan하면 복잡성이 증가

			
		}

		private static void search() {
			output.title(Teacher_Student_Management_Title.SEARCH);

			// 검색?
			// -> list() 작업과 유사
			// 1. list(): 모든 데이터 출력
			// 2. search(): 일부 데이터 출력. 조건부 list()

			System.out.print("검색(수강생): "); // 홍길동 > 길동 검색률을 높임
			String word = scan.nextLine();

			System.out.println("[번호]\t[학생이름]\t[배정 받은 강의실]\t[선생님]\t\t[점수]\t[성적]\t[메모]");
			Set<Integer> set = map.keySet();
			try {
				read();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Integer key : set) {

				// if(s.getName().contains(word)) {
				// if(s.getName().toUpperCase().contains(word.toUpperCase())) // 대소문자 구분 없이 한쪽으로
				// 몰아야 돼 그걸 안하면 철저하게 찾는 거임
				if (map.get(key).getName().indexOf(word) > -1) {
					System.out.printf("%3d\t%s\t\t%d\t\t\t%s\t\t%d\t\t%s\t%s\n",
							map.get(key).getSeq(),map.get(key).getName(),map.get(key).getClassroom(),map.get(key).getTeacher(),
							map.get(key).getScore(),map.get(key).getGrade(),map.get(key).getMemo());

				}
			}
			map.clear();
			Teacher_Student_Management.temp=0;
			output.pause(scan);
			
		}


		private static void filewrite() {	
			
			Set<Integer> set = map.keySet(); 
		
			String path = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\학생관리\\학생관리.txt";
			File file = new File(path);
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				for (Integer key : set) {

					writer.write(map.get(key).getSeq() + "," + map.get(key).getName() + "," + map.get(key).getClassroom() + "," 
					+ map.get(key).getTeacher()+"," + map.get(key).getScore()+","+map.get(key).getGrade()+ "," +
							map.get(key).getMemo()+","+map.get(key).getKey()+"\r\n");

				}
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private static void list() {
			output.title(Teacher_Student_Management_Title.LIST);
			try {
				read();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.out.println("[번호]\t[고유 번호]\t[학생이름]\t[배정 받은 강의실]\t[선생님]\t[점수]\t[성적]\t[메모]");
				
				ArrayList<Teacher_Student_Management> list = new ArrayList<Teacher_Student_Management>();
				Set<Integer> set = map.keySet(); 
				for(Integer key:set) {
				list.add(new Teacher_Student_Management());
				list.get(key-1).setName(map.get(key).getName());
				list.get(key-1).setKey(map.get(key).getKey());
				list.get(key-1).setSeq(map.get(key).getSeq());
				list.get(key-1).setClassroom(map.get(key).getClassroom());
				list.get(key-1).setTeacher(map.get(key).getTeacher());
				list.get(key-1).setScore(map.get(key).getScore());
				list.get(key-1).setGrade(map.get(key).getGrade());
				list.get(key-1).setMemo(map.get(key).getMemo());
				            
				} 
				
				List<Teacher_Student_Management>  items = list;
				 HashMap<Integer, Teacher_Student_Management> map1 = new <Integer, Teacher_Student_Management> HashMap();
				i=1;
				items.stream().sorted((item1,item2)->item1.getName().compareTo(item2.getName()))
							  .sorted((item1,item2)->item1.getClassroom()-item2.getClassroom()) 
							  .forEach(item->{
								  	int seq = item.getSeq();
								 	System.out.printf("%3d\t%d\t\t%s\t%d\t\t%s\t%d\t%s\t%s\n",i,item.getSeq(),item.getName(),
									item.getClassroom(),item.getTeacher(),item.getScore(),item.getGrade(),item.getMemo());
								 	item.setSeq(seq);
								 	map1.put(i,item);
								 	i++;
								 
							 		}	
								 );
				
				
				map.clear();
				Teacher_Student_Management.temp=0;
				output.pause(scan);
			
		}


		private static void dummy() throws Exception {
			int length = 300;
		
			Random rnd = new Random();
			String path = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\과목\\과목.txt";
			File file = new File(path);
			File file1 = new File("C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\선생님\\선생님.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedReader reader1 = new BufferedReader(new FileReader(file1));
		
			ArrayList <ArrayList<String>> teacher = new ArrayList<ArrayList<String>>();
			teacher.add(new ArrayList<String>());
			teacher.add(new ArrayList<String>());
			//if문 전에 열어야 돼~
			int cnt=1;
			String line = null;
			
			if (file1.exists()) {
				while((line=reader1.readLine())!=null) {
					String[] item = line.split(",");
					teacher.get(0).add(item[1]); // 강사 이름
					teacher.get(1).add(item[8]); // 강의실
				}
			} else {
				System.out.println("파일이 존재하지 않습니다.");
			}
			
			int person_sum = 0;
			
			line = null;
			
			ArrayList <ArrayList<String>> subject = new ArrayList<ArrayList<String>>();
			subject.add(new ArrayList<String>());
			subject.add(new ArrayList<String>());
			subject.add(new ArrayList<String>());
			subject.add(new ArrayList<String>());
			
			if(file.exists()) {
				while((line=reader.readLine())!=null) {
					String[] item = line.split(",");
					subject.get(0).add(item[1]); // 과정명
					subject.get(1).add(item[11]); // 인원수
					subject.get(2).add(item[5]); //강의실 
			}
			
			for(int i=0;i<subject.get(0).size();i++) {
				for(int j=0;j<teacher.get(0).size();j++) {
					if(subject.get(2).get(i).equals(teacher.get(1).get(j))) {
						subject.get(3).add(teacher.get(0).get(j)); // 강사이름
					}
				}
			}
			
				
			for(int i=0;i<subject.get(1).size();i++) {
				person_sum+=Integer.parseInt(subject.get(1).get(i));
				
			}
			
			for(int i=0;i<person_sum;i++) {
				Teacher_Student_Management s = new Teacher_Student_Management();
				map.put(i, s);
			}
			
			File file3 = new File("C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\수강생\\수강생.txt");
			
			BufferedReader reader3 = new BufferedReader(new FileReader(file3));
			
			File file2 = new File("C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\학생관리\\학생관리.txt");
			
			BufferedWriter writer2 = new BufferedWriter(new FileWriter(file2));
		    String[] memo = {"지각이 많음","성실함","열심히 함","수업시간에 잠","성적이 좋음"};
			line = null;
			reader1.readLine();
			
			ArrayList<ArrayList<String>> student = new ArrayList<ArrayList<String>>();
			student.add(new ArrayList<String>());
			student.add(new ArrayList<String>());
			student.add(new ArrayList<String>());
			
			student.add(new ArrayList<String>());
			student.add(new ArrayList<String>());
			student.add(new ArrayList<String>());
			student.add(new ArrayList<String>());
			
			int i=0;
			reader3.readLine();
			while((line=reader3.readLine())!=null) {
				String[] item = line.split(",");
				student.get(0).add(item[1]); // 수강생 이름
				student.get(1).add(item[6]); //수강생 성적
				student.get(2).add(item[7]); // 수강생 등급
				
				if(i>9) {
					i=0;
				}
				student.get(3).add(subject.get(0).get(i)); // 과정명 
				student.get(4).add(subject.get(1).get(i)); // 인원수
				student.get(5).add(subject.get(2).get(i)); // 강의실 
				student.get(6).add(subject.get(3).get(i)); // 강사이름
			    
				
				i++;
				
			}
			
			reader3.close();
			for(int k=0;k<student.get(0).size();k++) {
				Teacher_Student_Management.temp++;
				map.get(k).setSeq(Teacher_Student_Management.temp);
				map.get(k).setName(student.get(0).get(k));
				map.get(k).setScore(Integer.parseInt(student.get(1).get(k)));
				map.get(k).setGrade(student.get(2).get(k));
				map.get(k).setClassroom(Integer.parseInt(student.get(5).get(k)));
				map.get(k).setMemo(memo[rnd.nextInt(memo.length)]);
				map.get(k).setTeacher(student.get(6).get(k));
				map.get(k).setKey(Teacher_Student_Management.temp);
				
				writer2.write(map.get(k).getSeq()+","+map.get(k).getName()+","+map.get(k).getClassroom()+","
				+ map.get(k).getTeacher()+","+map.get(k).getScore()+","+map.get(k).getGrade() +","+map.get(k).getMemo()+","+map.get(k).getKey()+"\r\n");
			}
			
				writer2.close();
				map.clear();
				Teacher_Student_Management.temp=0;

			}
			reader.close();
			reader1.close();
			
		
		}
		private static boolean checkName(String name) {
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
}
