package com.project.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class GuestCurriculum { // 비회원모드 > 1.전체 데이터 조회
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Guest> list = new ArrayList<Guest>();	
	
	public void guestCurriculum() throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\교과과정.txt"));
		
		File file = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\교과과정.txt");
		String line = null;
		
		if (file.exists()) {
			while ((line = reader.readLine()) != null) {
				
				Guest g = new Guest();
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
				
				list.add(g);
				
			}
		}
		
		reader.close();
		
		boolean loop = true;
		
		while (loop) {
			
			Output.guestCurriculum();
			
			String sel = scan.nextLine();

			seeCurriculum();
			
			if (sel.equals("1")) {
				//과정 검색
				searchCurriculum();
					
			} else {
				//프로그램 종료
				loop = false;
			}				
			
		}		
		
	}

	private void searchCurriculum() {
		
		Output.title(Title.SUBJECTSEARCH);
		
		System.out.print("검색(과정명) : ");
		String word = scan.nextLine();
		
		System.out.println("[번호]\t\t[교과목]\t\t[교육과정]\t[교육장소]\t\t[교육기간]\t\t\t[교육일정]\t\t[모집인원]");
		
		for (Guest g : list) {
			
			if (g.getName().toUpperCase().contains(word.toUpperCase())) {
			
				System.out.printf("%4d\t%s\t%10s\t%s\t\t%s ~ %s\t\t%s\t\t   %d\n"
						, g.getSeq()
						, g.getName()
						, g.getSubject()
						, g.getArea()
						, g.getC_1()
						, g.getC()
						, g.getTime()
						, g.getPeople());
			}
			
		}
		
		Output.pause(scan);
		
	}

	private void seeCurriculum() {
		
		Output.title(Title.SUBJECTLIST);
		
		System.out.println("[번호]\t\t[교과목]\t\t[교육과정]\t[교육장소]\t\t[교육기간]\t\t\t[교육일정]\t\t[모집인원]");
		
		for (Guest g : list) {
			
			System.out.printf("%4d\t%s\t%10s\t%s\t\t%s ~ %s\t\t%s\t\t   %d\n"
					, g.getSeq()
					, g.getName()
					, g.getSubject()
					, g.getArea()
					, g.getC_1()
					, g.getC()
					, g.getTime()
					, g.getPeople());
			
		}

		Output.pause(scan);
		
	}

}
