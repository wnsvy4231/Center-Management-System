package com.project.guest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Guest_Main {
	
	private static Output output; //전역
	private static Scanner scan;
	private static ArrayList<Guest> list;
	
	static {
		
		output = new Output();
		scan = new Scanner(System.in);
		list = new ArrayList<Guest>();
		
	}
	
	public void gest(){
		
		output.begin();
		
		boolean loop = true;
		
		while (loop) {
			
			output.guestMenu();
			
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				//전체 데이터 조회
				try {
					seeCurriculum();
				} catch (Exception e) {
					e.printStackTrace();
				}
				output.guestCurriculum();
				String sel2 = scan.nextLine();
				if (sel2.equals("1")) {
					//전체 과정 조회
					
					
					searchCurriculum();
					System.out.println("계속하시려면 엔터를 누르세요..");
					System.out.println("------------------");
					String ent =  scan.nextLine();
					
				} else {
					//프로그램 종료
					loop = false;
				}				
			} else if (sel.equals("2")) {
				//수강 추천순 조회
				Recommend re = new Recommend();
				re.recommend();
//				curriculumList();
			} else if (sel.equals("3")) {
				Nonmember_Inquiry_Test qq = new Nonmember_Inquiry_Test();
				qq.non();
				//1 : 1 문의
//				question();
			}else if (sel.equals("4")) {
				//프로그램 종료
				loop = false;	
				
			}else {
				System.out.println("목록에 없는 항목을 입력하셨습니다.");
				System.out.println("계속하시려면 엔터를 누르세요..");
				System.out.println("------------------");
				String ent =  scan.nextLine();
				Guest_Main ge = new Guest_Main();
				ge.gest();
			}
			
		}		
		
		output.end();
		
		
	}

	private static void searchCurriculum() {
		
		output.title(Title.SUBJECTSEARCH);
		
		System.out.print("검색(과정명) : ");
		String word = scan.nextLine();
		
		System.out.println("[번호]\t\t\t[교과목]\t\t\t[교육과정]\t\t[교육장소]\t\t\t[교육기간]\t\t\t\t[교육일정]\t\t\t[모집인원]");
		
		for (Guest g : list) {
			
			if (g.getName().contains(word)) {
			
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
		
	}

	private static void seeCurriculum() throws Exception {
		
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
		
		output.title(Title.SUBJECTLIST);
		
		curriculum();
		
		output.pause(scan);	
		
	}

	private static void curriculum() {
		
		System.out.println("[번호]\t\t\t[교과목]\t\t\t\t[교육과정]\t\t[교육장소]\t\t\t\t[교육기간]\t\t\t\t[교육일정]\t\t\t[모집인원]");
		
		for (Guest g : list) {
			
			System.out.printf("%4d\t%s\t%10s\t\t%s\t\t\t%s ~ %s\t\t%s\t\t   %d\n"
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

}
