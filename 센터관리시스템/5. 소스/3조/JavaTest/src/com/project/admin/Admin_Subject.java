package com.project.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.admin.DummySubject;
import com.project.admin.Title;
import com.test.two.Dummy;

public class Admin_Subject {

	private static ArrayList<DummySubject> list;
	private static Scanner scan;
	
	static {	
		list = new ArrayList<DummySubject>();
		scan = new Scanner(System.in);
	}
	
	public void Subject() throws Exception {
		
		read();
		
		boolean loop = true;
		
		while (loop) {
			
			menu();
			
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				//교과과정 목록
				list();
			} else if (sel.equals("2")) {
				//교과과정 추가
				add();
			} else if (sel.equals("3")) {
				//교과과정 수정
				correct();
			} else if (sel.equals("4")) {
				//교과과정 삭제
				delete();
			} else if (sel.equals("5")) {
				//교과과정 검색
				search();
			} else if (sel.equals("6")){
				//프로그램 종료
				loop = false;
			} else {
				System.out.println("다시 입력하세요.");
			}
			
		}		
	
	}

	public void menu() {
		
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.println("수업 관리");
		System.out.println("1. 조회");
		System.out.println("2. 추가");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 검색");
		System.out.println("6. 종료");
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.print("선택(번호) : ");

	}
	
	public void title(Title type) {
		
		String title = "";
		
		if (type == Title.ADD) {
			title = "수업 추가";			
		} else if (type == Title.LIST) {			
			title = "수업 목록";			
		} else if (type == Title.DELETE) {			
			title = "수업 삭제";			
		} else if (type == Title.SEARCH) {
			title = "수업 검색";
		} else if (type == Title.CORRECT) {
			title = "수업 수정";
		}
		
		System.out.println();
		System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
		System.out.println(title);
		System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
		System.out.println();
		
	}//title
	
	public void read() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\교과과정.txt"));
		File file = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\교과과정.txt");
		String line = null;
		
		if (file.exists()) {
			while ((line = reader.readLine()) != null) {
				
				//객체 생성
				DummySubject s = new DummySubject();
				
				String[] temp = line.split(",");
				
				int seq = Integer.parseInt(temp[0]);
				int room_num = Integer.parseInt(temp[5]);
				int people = Integer.parseInt(temp[11]);
				int cost = Integer.parseInt(temp[12]);
				
				s.setSeq(seq);
				s.setName(temp[1]);
				s.setSubject(temp[2]);
				s.setC(temp[3]);
				s.setC_1(temp[4]);
				s.setRoom_num(room_num);
				s.setPlace(temp[6]);
				s.setTime(temp[7]);
				s.setStd_satisfy(temp[8]);
				s.setArea(temp[9]);
				s.setEmp_ratio(temp[10]);
				s.setCost(cost);
				s.setPeople(people);
				
				list.add(s);
				
			}
		}
		
		reader.close();
	}
	
	public void add() throws Exception {

		title(Title.ADD);
		
		System.out.print("강의제목 : ");
		String name = scan.nextLine();
		
		System.out.print("교과목 : ");
		String subject = scan.nextLine();
		
		System.out.print("교육기간(시작) : ");
		String date1 = scan.nextLine();
		
		System.out.print("교육기간(끝) : ");
		String date2 = scan.nextLine();
		
		System.out.print("강의실번호 : ");
		int room = scan.nextInt();
		scan.skip("\r\n");	
		
		System.out.print("모집인원 : ");
		int people = scan.nextInt();
		scan.skip("\r\n");
		
		DummySubject s = new DummySubject();
		
		DummySubject.temp = 10;
		DummySubject.temp++;
		
		s.setSeq(DummySubject.temp);
		s.setName(name);
		s.setSubject(subject);
		s.setC(date1);
		s.setC_1(date2);
		s.setRoom_num(room);
		s.setPeople(people);
		
		list.add(s);
		
		filewrite();
		
		list.clear();
		
		DummySubject.maintemp = 1;
		
		try {
			read();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		pause(scan);

	}//add
		
	public void list() {
		
		title(Title.LIST);
		
		listName();
		
		pause(scan);
		
	}
	
	public void correct() {
		
		title(Title.CORRECT);
		
//		for (DummySubject s : list) {			
//
//			System.out.printf("%3d\t %s\t %s\t\t %s ~ %s\t %4d\t\t %3d\t\n"
//					, s.getSeq()
//					, s.getName()
//					, s.getSubject()
//					, s.getC_1()
//					, s.getC()
//					, s.getRoom_num()
//					, s.getPeople());
//			
//		}
		
		System.out.print("수정(번호) : ");
		int num = scan.nextInt();
		scan.skip("\r\n");
		
		System.out.print("교육과정 : ");
		String name = scan.nextLine();
		
		System.out.print("교과목 : ");
		String subject = scan.nextLine();
		
		System.out.print("교육기간(시작) : ");
		String date1 = scan.nextLine();
		
		System.out.print("교육기간(끝) : ");
		String date2 = scan.nextLine();
		
		System.out.print("강의실번호 : ");
		int room = scan.nextInt();
		scan.skip("\r\n");	
		
		System.out.print("모집인원 : ");
		int people = scan.nextInt();
		scan.skip("\r\n");		
		
		for (DummySubject s : list) {
		
			
			if (s.getSeq() == num) {
				
				s.setSeq(num);
				s.setName(name);
				s.setSubject(subject);
				s.setC(date2);
				s.setC_1(date1);
				s.setRoom_num(room);
				s.setPeople(people);
				
				System.out.printf("%3d\t%s\t%s\t%s ~ %s\t%d\t%d\n"
						,s.getSeq()
						,s.getName()
						,s.getSubject()
						,s.getC()
						,s.getC_1()
						,s.getRoom_num()
						,s.getPeople());
			}
			
		}
		
		pause(scan);

	}//correct
	
	public void delete() throws Exception {
		
		title(Title.DELETE);
		
		System.out.print("삭제할 번호 : ");
		int sel = scan.nextInt();
		scan.skip("\r\n");
		
		for(int i=0; i<list.size(); i++) {
			
			if(list.get(i).getSeq() == sel) {
				list.remove(i);
				break;
			}
			
		}
		
		filewrite();
		
		list.clear();
		
		DummySubject.maintemp = 1;
		
		try {
			read();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pause(scan);

	}
	
	public void search() {
		
		title(Title.SEARCH);
		
		System.out.print("검색(번호) : ");
		int num = scan.nextInt();
		scan.skip("\r\n");
		
		System.out.println("[번호]\t\t[교육과정]\t\t\t\t[교과목]\t\t\t[교육기간]\t\t\t[강의실번호]\t[모집인원]");
		
		for (DummySubject s : list) {			
			if (s.getSeq() == num) {
				System.out.printf("%3d\t %s\t %s\t\t %s ~ %s\t %4d\t\t %3d\t\n"
						, s.getSeq()
						, s.getName()
						, s.getSubject()
						, s.getC_1()
						, s.getC()
						, s.getRoom_num()
						, s.getPeople());
			}
			
		}
		
		pause(scan);
		
	}
	
	private static void listName() {
			
			System.out.println("[번호]\t\t[교육과정]\t\t\t\t[교과목]\t\t\t[교육기간]\t\t\t[강의실번호]\t[모집인원]");
			
			for (DummySubject s : list) {
				
				System.out.printf("%3d\t %s\t %s\t\t %s ~ %s\t %4d\t\t %3d\t\n"
						, s.getSeq()
						, s.getName()
						, s.getSubject()
						, s.getC_1()
						, s.getC()
						, s.getRoom_num()
						, s.getPeople());
			}
			
	}//listName
	
	private void filewrite() { //덮어쓰기
		
		String path = "C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\교과과정.txt";
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path, false));
			
			for (int i=0; i<list.size(); i++) {
				
				writer.write(list.get(DummySubject.maintemp).getSeq() + "," + list.get(DummySubject.maintemp).getName() + "," 
							+ list.get(DummySubject.maintemp).getSubject() + "," + list.get(DummySubject.maintemp).getC()  + "," 
							+ list.get(DummySubject.maintemp).getC_1() + "," + list.get(DummySubject.maintemp).getRoom_num() + "," 
							+ list.get(DummySubject.maintemp).getPlace() + "," + list.get(DummySubject.maintemp).getTime() + "," 
							+ list.get(DummySubject.maintemp).getStd_satisfy() + "," + list.get(DummySubject.maintemp).getArea() + "," 
							+ list.get(DummySubject.maintemp).getEmp_ratio() + "," + list.get(DummySubject.maintemp).getPeople() + "," 
							+ list.get(DummySubject.maintemp).getCost() + "," + list.get(DummySubject.maintemp).getKey() + "\r\n");
						DummySubject.maintemp++;
				
			}
			
			writer.close();			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		
	} //덮어쓰기
	
	public void pause(Scanner scan) {
		
		System.out.println();
		System.out.println("완료되었습니다.");
		System.out.println("계속하려면 엔터를 입력하세요.");
		
		scan.nextLine();
		
	}//pause
	
}//Admin_Subject