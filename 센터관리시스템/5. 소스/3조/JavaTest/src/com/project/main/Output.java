package com.project.main;

import java.util.Scanner;

public class Output {

	public void begin() {
		
		System.out.println();
		System.out.println("■■■■■ 프로그램을 시작합니다. ■■■■■");
		System.out.println();	
			
	}
	
	public void menu() {
		
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.println("수강생 정보 관리");
		System.out.println("1. 수강생 목록");
		System.out.println("2. 수강생 등록");
		System.out.println("3. 수강생 삭제");
		System.out.println("4. 수강생 검색");
		System.out.println("5. 수강생 수정");
		System.out.println("6. 종료");
		System.out.println("□□□□□□□□□□□□□□□"); 
		System.out.print("선택(번호) : ");
		
	}
	
	public void teacherMainMenu() {
		
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.println("Lect1234님 어서오세요.");
		System.out.println("1. 회원 정보");
		System.out.println("2. 수강생 관리");
		System.out.println("3. 수업 자료 업로드");
		System.out.println("4. 로그아웃");
		System.out.println("5. 종료");
		System.out.println("□□□□□□□□□□□□□□□"); 
		System.out.print("선택(번호) : ");		
		
	}
	
	public void teacherGradeMenu() {
		
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.println("1. 수강생 성적 추가");
		System.out.println("2. 수강생 성적 수정");
		System.out.println("3. 수강생 성적 삭제");
		System.out.println("4. 이전 화면");
		System.out.println("5. 종료");
		System.out.println("□□□□□□□□□□□□□□□"); 
		System.out.print("선택(번호) : ");
		
	}
	
	public void teacherClassFile() {
		
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.println("1. 수업 자료 업로드");
		System.out.println("2. 수업 자료 수정");
		System.out.println("3. 수업 자료 삭제");
		System.out.println("4. 수업 자료 검색");
		System.out.println("5. 이전 화면");
		System.out.println("6. 종료");
		System.out.println("□□□□□□□□□□□□□□□"); 
		System.out.print("선택(번호) : ");
		
	}
	
	public void studentMenu() {
		
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.println("Std1234님 어서오세요.");
		System.out.println("1. 회원 정보");
		System.out.println("2. 성적 확인");
		System.out.println("3. 출결 확인");
		System.out.println("4. 수업자료 확인");
		System.out.println("5. 상담 문의");
		System.out.println("6. 결재 안내");
		System.out.println("7. 시간표 확인");
		System.out.println("8. 종료");
		System.out.println("□□□□□□□□□□□□□□□"); 
		System.out.print("선택(번호) : ");
		
	}
	
	public void guestMenu() {
		
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.println("Guest님 어서오세요.");
		System.out.println("1. 전체과정 조회");
		System.out.println("2. 수강 추천");
		System.out.println("3. 1대1 문의");
		System.out.println("4. 종료");
		System.out.println("□□□□□□□□□□□□□□□"); 
		System.out.print("선택(번호) : ");
		
	}
	
	public void guestCurriculum() {
		
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.println("1. 교육과정 검색");
		System.out.println("2. 종료");
		System.out.println("□□□□□□□□□□□□□□□"); 
		System.out.print("선택(번호) : ");
		
	}
	
	public void end() {
		
		System.out.println();
		System.out.println("■■■■■ 프로그램을 종료합니다. ■■■■■");
		System.out.println();	
			
	}

	public void title(Title type) {
		
		String title = "";
		
		if (type == Title.ADD) {
			title = "수강생 추가하기";			
		} else if (type == Title.LIST) {			
			title = "수강생 목록보기";			
		} else if (type == Title.DELETE) {			
			title = "수강생 삭제하기";			
		} else if (type == Title.SEARCH) {
			title = "수강생 검색하기";
		} else if (type == Title.CORRECT) {
			title = "수강생 수정하기";
		} else if (type == Title.SUBJECTLIST) {
			title = "교육과정 목록보기";
		} else if (type == Title.SUBJECTSEARCH) {
			title = "교육과정 검색하기";
		} else if (type == Title.TIMETABLE) {
			title = "시간표 출력하기";
		}
		
		System.out.println();
		System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
		System.out.println(title);
		System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
		System.out.println();
		
	}

	public void pause(Scanner scan) {
		
		System.out.println();
		System.out.println("완료되었습니다.");
		System.out.println("계속하려면 엔터를 입력하세요.");
		
		scan.nextLine();
		
	}

}
