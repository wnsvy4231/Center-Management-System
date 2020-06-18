package com.project.guest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.test.collection.Member;

//*************강의 추천 기능****************
// 소스 복사 붙여넣기 하거나 "Recommend" 클래스의 "recommend" 메소드 불러오기 해주세요

public class Recommend {
		

		public void recommend(){
			
			// 스캐너 (Scanner) 선언
			Scanner scan = new Scanner(System.in);
			
			//ArrayList 선언
			ArrayList<String> list =new ArrayList<String>();
			// 더미 데이터 요소 불러오기
			 try {
				// 파일 객체 생성
				 File file = new File ("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\교과과정.txt"); 	// 더미 파일 위치에 맞게 바꿔주세요
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
			
//---------------------------------------------------------------------------------------------
			 // 출력 화면 구현
			System.out.println("------------------");
			System.out.println("관리자 수강 추천");
			System.out.println("1. 취업률만 우선순위");
			System.out.println("2. 선호 지역(취업률로 내림차순)");
			System.out.println("3. 선호하는 달(취업률로 내림차순)");
			System.out.println("4. 수강생 만족도 순위");
			System.out.println("5. 종료");
			System.out.println("------------------");
			System.out.print("선택(번호) : ");
			
			// input으로 입력받음
			String input = scan.nextLine();

//--------------------------------------------------------------------------------------		
				// 취업률
			if(input.equals("1")) {
				 
				ArrayList<RecommendList> listsort = listfind(list);
				
				ouput();
				 listsort.sort(new Comparator<RecommendList>() {
						@Override
						public int compare(RecommendList o1, RecommendList o2) {
			
								return o2.getJop().compareTo(o1.getJop()); 
						}
					});
				// 출력
				 for(int i = 0; i<listsort.size(); i++) {
				 System.out.print(listsort.get(i));
				 }
				 listsort.clear();
				 restart(scan);
				 
//------------------------------------------------------------------------------------------				 
				 // 지역
			}else if(input.equals("2")) {
				System.out.print("선호하는 지역을 입력해주세요 : ");
				ArrayList<RecommendList> listsort = list(list);
				
			
				ouput();
				
				 listsort.sort(new Comparator<RecommendList>() {
						@Override
						public int compare(RecommendList o1, RecommendList o2) {
			
							return o2.getJop().compareTo(o1.getJop()); 
						}
					});
				// 출력
			
				 for(int i = 0; i<listsort.size(); i++) {
					
				
					
					
						 System.out.print(listsort.get(i));
						 

				 }
				 listsort.clear();
				 restart(scan);
//-------------------------------------------------------------------------------------------				 
				// 선호하는 달
		}else if(input.equals("3")) {
			System.out.print("선호하는 달을 입력해주세요 : ");
			ArrayList<RecommendList> listsort = list2(list);
				
				
				
				ouput();
				
				 listsort.sort(new Comparator<RecommendList>() {
						@Override
						public int compare(RecommendList o1, RecommendList o2) {
			
							return o2.getJop().compareTo(o1.getJop()); 
						}
					});
				// 출력
				 for(int i = 0; i<listsort.size(); i++) {
						 System.out.print(listsort.get(i));
				 }
				 listsort.clear();
				 restart(scan);
//-------------------------------------------------------------------------------------------				 
				 // 만족도
			}else if(input.equals("4")) {
				ArrayList<RecommendList> listsort = listfind(list);
				ouput();
				 listsort.sort(new Comparator<RecommendList>() {
						@Override
						public int compare(RecommendList o1, RecommendList o2) {
			
								return o2.getHappy().compareTo(o1.getHappy()); 
						}
					});
				// 출력
				 for(int i = 0; i<listsort.size(); i++) {
				 System.out.print(listsort.get(i));
				 }
				 listsort.clear();
				 restart(scan);
//--------------------------------------------------------------------------------------------				 
			}else if(input.equals("5")) {
				//5. 종료
				System.out.println("종료 되었습니다.");
//             ********종료 기능 구현되면 여기에 추가해주세요*******
//--------------------------------------------------------------------------------------------				
				//잘못 입력했을때
			}else {
				
				System.out.println("잘못 입력하셨습니다.");
				restart(scan);
			}	
//--------------------------------------------------------------------------------------------			
		}// recommend 메소드 끝
		private ArrayList<RecommendList> list2(ArrayList<String> list) {
			//ArrayList 선언
		
			Scanner scan = new Scanner(System.in);
		
			String area = scan.nextLine();
			if(area.equals("")) {
				System.out.println("------------------");
				System.out.print("아무것도입력되지 않았습니다.\r\n선호하는 달을 다시 입력해주세요 : ");
				
				ArrayList<RecommendList> listsort = list2(list);
			}
			 ArrayList<RecommendList> listsort = new ArrayList<RecommendList>();
			
			 for(int i=0; i<list.size(); i++) {
					 String temp[] = list.get(i).split(",");
					//ArrayList 에 값을 저장
					 if(temp[4].contains(area)) {
						  
					 listsort.add(new RecommendList(temp[0], temp[1], temp[4], temp[9], temp[8], temp[10]));	 	 
					 }
				}
			return listsort;
		}
//-------------------------------------------------------------------------------------		
		private ArrayList<RecommendList> list(ArrayList<String> list) {
			//ArrayList 선언
			
			Scanner scan = new Scanner(System.in);
		
			String area = scan.nextLine();
			if(area.equals("")) {
				System.out.println("------------------");
				System.out.print("아무것도입력되지 않았습니다.\r\n지역을 다시 입력해주세요 : ");
				
				ArrayList<RecommendList> listsort = list(list);
				
			}
			
			 ArrayList<RecommendList> listsort = new ArrayList<RecommendList>();
			
			 for(int i=0; i<list.size(); i++) {
					 String temp[] = list.get(i).split(",");
					//ArrayList 에 값을 저장
					 if(temp[9].contains(area)) {
						  
						 listsort.add(new RecommendList(temp[0], temp[1], temp[4], temp[9], temp[8], temp[10]));	 
					 }
				}
			return listsort;
		}
//------------------------------------------------------------------------------------------------------------		
		private ArrayList<RecommendList> listfind(ArrayList<String> list) {
			//ArrayList 선언
			 ArrayList<RecommendList> listsort = new ArrayList<RecommendList>();
			 for(int i=0; i<list.size(); i++) {
					 String temp[] = list.get(i).split(",");
					//ArrayList 에 값을 저장
					 listsort.add(new RecommendList(temp[0], temp[1], temp[4], temp[9], temp[8], temp[10]));	 
			 }
			return listsort;
		}
//--------------------------------------------------------------------------------
		private void restart(Scanner scan) {
			System.out.println("계속하시려면 엔터를 눌러주세요.");
			System.out.println("------------------");
			
			// 엔터 입력 (아무거나 입력해도 되게 구현되있음)
			String enter = scan.nextLine();
			
			//강의 추천 기능 재귀호출 (처음으로 이동)
			Recommend re = new Recommend();
			re.recommend();
		}
	//-----------------------------------------------------------------------------
		//교육 과정 출력문 메소드
		private void ouput() {
			System.out.println("조회가 완료되었습니다.");
			System.out.println("------------------");	
			System.out.println("번호\t\t\t교육과정\t\t\t\t\t시작 월\t지역\t수강생만족도        취업률");
			
		}
}// Recommend 클래스 끝


