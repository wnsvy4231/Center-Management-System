package com.project.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Itemthis {
	public static int numf; // 넘버링 숫자
	
	void staitc(){
		
	}
	public void item(){
		
		//추가 작업에 쓰이는 넘버링 숫자
		int PlusNum = 0;
		//restart 에 사용하고 버려지는 숫자
		int RE = 0;
		
		int count = 0;
		
		//ArrayList 선언
		ArrayList<String> list =new ArrayList<String>();
	
		// 더미 데이터 요소 불러오기
		 try {
			// 파일 객체 생성
			 File file = new File ("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\기자재.txt"); 	// 더미 파일 위치에 맞게 바꿔주세요
			//입력 스트림 생성
			FileReader filereader = new FileReader(file);			
			//입력 버퍼 생성
			 BufferedReader read = new BufferedReader(filereader);
			  String text ="";
			//더미 데이터 요소가 있을때까지 while 
			  while((text  = read.readLine())!=null) {
			//list에 더미데이터 한줄씩 추가함 while 끝날동안 반복		
				  list.add(text);
					}
		 		} catch (Exception e1) {
		 				System.out.println("더미 파일 경로에서 오류");
		 			}
			
			//ArrayList 선언
			 ArrayList<ItemList> listsort = new ArrayList<ItemList>();
			 for(int i=0; i<list.size(); i++) {
					 String temp[] = list.get(i).split("■");
					//ArrayList 에 값을 저장
					 listsort.add(new ItemList(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5],temp[6],temp[7]));	
					 if(i==list.size()-1) {
						 PlusNum = Integer.parseInt(temp[0]);
					 }
			 }
			
			 boolean o = true;
			while(o) {
			 
	
			
				System.out.println("------------------");
				System.out.println("기자재 관리");
				System.out.println("1. 기자재 추가");
				System.out.println("2. 기자재 목록");
				System.out.println("3. 기자재 삭제");
				System.out.println("4. 기자재 검색");
				System.out.println("5. 기자재 수정");
				System.out.println("6. 종료");
				System.out.println("------------------");
				System.out.print("선택(번호) : ");
				
				
				
				// 스캐너 (Scanner) 선언
				Scanner scan = new Scanner(System.in);
						
				// input으로 입력받음
				String input = scan.nextLine();
				System.out.println("------------------");
				
				if(input.equals("1")) {
					//추가
					
					System.out.println("기자재 추가하기");
					System.out.println("------------------");
					System.out.print("품명 : ");
					String q1 = scan.nextLine();
					System.out.print("수량 : ");
					String q2 = scan.nextLine();
					System.out.print("구입일자 : ");
					String q3 = scan.nextLine();
					System.out.print("금액 : ");
					String q4 = scan.nextLine();
					System.out.print("관리유지 : ");
					String q5 = scan.nextLine(); 
					System.out.print("구매처 : ");
					String q6 = scan.nextLine(); 
					System.out.print("비고 : ");
					String q7 = scan.nextLine();
					System.out.println("------------------");
					
					if(!q1.equals("")&&!q2.equals("")&&!q3.equals("")&&!q4.equals("")&&!q5.equals("")&&!q6.equals("")) {
						PlusNum++;
						String b = String.format("%s", PlusNum);
					ItemList a= new ItemList(b,q1, q2, q3, q4, q5, q6, q7);
					listsort.add(a); 
					 System.out.println("추가 되었습니다.");
					 System.out.println("------------------");
					 //출력
					 System.out.println("번호   품명/모델명   수량	구입일자	       금액	      관리유지   제조사 비고");
					 //출력 
					numf = 0;
					 for(int i = 0; i<listsort.size(); i++) {
						 numf++;
						 System.out.print(listsort.get(i));
					 }
					 System.out.println("------------------");
					}else {
						
						System.out.println("입력하지 않은 값이 있습니다.");
						System.out.println("------------------");
					}
					restart(scan);
				
				}else if(input.equals("2")) {
					//목록
					System.out.println("기자재 목록");
					System.out.println("------------------");
					 //출력
					 System.out.println("번호   품명/모델명   수량	구입일자	       금액	      관리유지   제조사 비고");
					 //출력 
					 numf = 0;
					 for(int i = 0; i<listsort.size(); i++) {
						 numf++;
						 System.out.print(listsort.get(i));
					 }
					 System.out.println("------------------");
					 System.out.println("목록을 조회했습니다.");
					 System.out.println("------------------");
					 restart(scan);
				}else if(input.equals("3")) {
					//삭제
					System.out.println("기자재 삭제하기");
					System.out.println("------------------");
					//출력 
					numf=0;
					 for(int i = 0; i<listsort.size(); i++) {
						 numf++;
						 System.out.print(listsort.get(i));
					 }
					 System.out.println("------------------");
					 System.out.print("삭제할 번호 : ");
					 String remove = scan.nextLine();
					 System.out.println("------------------");
				if(remove.contains("1")||remove.contains("2")||remove.contains("3")||remove.contains("4")||remove.contains("5")||remove.contains("6")||remove.contains("7")||remove.contains("8")||remove.contains("9")||remove.contains("0")) {
						 
						 
					
					 int mo = Integer.parseInt(remove);
					
					 for(int i=0; i<listsort.size(); i++) {
						
						 listsort.remove(mo-1);
						break;
					 }


					 
					 
						System.out.println("삭제 되었습니다.");
						System.out.println("------------------");
						 //출력
						 System.out.println("번호   품명/모델명   수량	구입일자	       금액	      관리유지   제조사 비고");
						 //출력 
						 numf = 0;
						 for(int i = 0; i<listsort.size(); i++) {
							 numf++;
							 System.out.print(listsort.get(i));
						 }
						 System.out.println("------------------");
						
						 if(remove.equals("")) {
							 System.out.print("아무것도입력되지 않았습니다.\r\n");
								
						 }
					 }else {
						 System.out.println("목록에 없는 번호 or  숫자가 아닌 값을 입력하셨습니다.");
						 System.out.println("------------------");
						 
					 }
				restart(scan);
				}else if(input.equals("4")) {
					//검색
					System.out.println("기자재 검색하기");
					System.out.println("------------------");
					System.out.print("기자재 검색 : ");
					String serch = scan.nextLine();
					System.out.println("------------------");
				
					
					 //유효성 쓰이는 리스트 인트값
					int aaa = 0;
					int bbb = 0;
					 //출력
					String A = "";
					String B = "";
					numf = 0;
					 for(int i = 0; i<listsort.size(); i++) {
						 
						 A = String.format("%s", listsort.get(i));
						 if(A.contains(serch)) {
							 if(bbb==0) {
							 B = String.format("번호   품명/모델명   수량	구입일자	       금액	      관리유지   제조사 비고");
							 System.out.println(B);
							 bbb++;
							 }
							 numf++;
							 System.out.print(listsort.get(i));
							 aaa++;
						 }			
					 }	 
					 if(aaa==0) {
						  System.out.println("일치하는 항목이 없습니다.");
						  System.out.println("------------------");
						  
					 }
						if(serch.equals("")) {
							System.out.print("아무것도입력되지 않았습니다.\r\n");
							System.out.println("------------------");
							
							
						}
					 restart(scan);
				}else if(input.equals("5")) {
					//수정
					System.out.println("기자재 수정하기");
					System.out.println("------------------");
					 //출력
					 System.out.println("번호   품명/모델명   수량	구입일자	       금액	      관리유지   제조사 비고");
					 //출력 
					 numf = 0;
					 for(int i = 0; i<listsort.size(); i++) {
						 numf++;
						 System.out.print(listsort.get(i));
					 }
					 System.out.println("------------------");
					System.out.print("수정할 번호 : ");
					String fix = scan.nextLine();
					if(fix.contains("1")||fix.contains("2")||fix.contains("3")||fix.contains("4")||fix.contains("5")||fix.contains("6")||fix.contains("7")||fix.contains("8")||fix.contains("9")||fix.contains("0")) {
				
					System.out.println("------------------");
					System.out.print("품명 : ");
					String q1 = scan.nextLine();
					System.out.print("수량 : ");
					String q2 = scan.nextLine();
					System.out.print("구입일자 : ");
					String q3 = scan.nextLine();
					System.out.print("금액 : ");
					String q4 = scan.nextLine();
					System.out.print("관리유지 : ");
					String q5 = scan.nextLine(); 
					System.out.print("구매처 : ");
					String q6 = scan.nextLine(); 
					System.out.print("비고 : ");
					String q7 = scan.nextLine();
					System.out.println("------------------");
					String b = String.format("%s", PlusNum);
					
					int d = Integer.parseInt(fix);
					ItemList a= new ItemList(fix,q1, q2, q3, q4, q5, q6, q7);
					listsort.add(d-1, a);
					listsort.remove(d);
					System.out.println("수정 되었습니다.");
					System.out.println("------------------");
					 //출력
					 System.out.println("번호   품명/모델명   수량	구입일자	       금액	      관리유지   제조사 비고");
					 //출력 
					 numf= 0;
					 for(int i = 0; i<listsort.size(); i++) {
						 numf++;
						 System.out.print(listsort.get(i));
					 }
					 System.out.println("------------------");
					}else if(fix.equals("")) {
						System.out.print("아무것도입력되지 않았습니다.\r\n");
						System.out.println("------------------");
						
					}else {
						System.out.println("목록에 없는 번호 or  숫자가 아닌 값을 입력하셨습니다.");
						 System.out.println("------------------");
					}
					restart(scan);
			//-------------------------------------------------------------		
				}else if(input.equals("6")) {
					System.out.println("종료 합니다.");
					o=false;
					//종료 기능 구현되면 여기에 추가
				}else {
					System.out.println("잘못 입력하셨습니다.");
					restart(scan);
				}
	}

	
		
		
	}
			 
			 
			 
		
		
	

private void restart(Scanner scan) {
	System.out.println("계속하시려면 엔터를 눌러주세요.");
	System.out.print("------------------");
	
	// 엔터 입력 (아무거나 입력해도 되게 구현되있음)
	String enter = scan.nextLine();
	
	
}
}
