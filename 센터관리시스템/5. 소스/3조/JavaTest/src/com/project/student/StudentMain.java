package com.project.student;

import java.util.Scanner;

public class StudentMain { //수강생 모드
	
	Scanner scan = new Scanner(System.in);
	
	public void studentMain() {
	
		boolean loop = true;
		
		while (loop) {
			
			Output.studentMenu(); //수강생 모드 메인메뉴 호출
			
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				//회원 정보
				StudentInfo info = new StudentInfo();
				try {
					info.studentInfo();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (sel.equals("2")) {
				//성적 확인
				StudentScore score = new StudentScore();
				try {
					score.studentScore();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (sel.equals("3")) {
				//출결 확인
				StudentAttend attend = new StudentAttend();
				try {
					attend.studentAttend();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (sel.equals("4")) {
				//수업자료 확인
				StudentFile file = new StudentFile();
				try {
					file.studentFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (sel.equals("5")) {
				//상담 문의
				StudentConsult consult = new StudentConsult();
				try {
					consult.studentConsult();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (sel.equals("6")) {
				//결재 안내
				StudentPay pay = new StudentPay();
				try {
					pay.studentPay();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (sel.equals("7")) {
				//시간표 확인
				StudentTimetable timetable = new StudentTimetable();
				try {
					timetable.studentTimetable();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else {
				//프로그램 종료
				loop = false;
			}
			
		}
	
	}

}
