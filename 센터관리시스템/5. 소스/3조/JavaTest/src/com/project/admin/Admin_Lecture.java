package com.project.admin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Admin_Lecture {
	
	private static Scanner scan;
	private static HashMap<Integer, Teacher> map;
	
	static {
		scan = new Scanner(System.in);
		map = new HashMap<Integer, Teacher>();
	}

	public void menu() {
		
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.println("강사 관리");
		System.out.println("1. 조회");
		System.out.println("2. 추가");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 검색(이름)");
		System.out.println("6. 검색(교과목)");
		System.out.println("7. 검색(전화번호)");
		System.out.println("8. 종료");
		System.out.println("□□□□□□□□□□□□□□□");

	}
	
	public void title(Title type) {
		
		String title = "";
		
		if (type == Title.ADD) {
			title = "강사 추가";			
		} else if (type == Title.LIST) {			
			title = "강사 조회";			
		} else if (type == Title.DELETE) {			
			title = "강사 삭제";			
		} else if (type == Title.SEARCH) {
			title = "강사 검색";
		} else if (type == Title.CORRECT) {
			title = "강사 수정";
		}
		
		System.out.println();
		System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
		System.out.println(title);
		System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
		System.out.println();
		
	}//title
	
	public void add() {

		title(Title.ADD);
		
		System.out.print("이름: ");
		String name = scan.nextLine();

		System.out.print("나이: ");
		int age = scan.nextInt();
		scan.skip("\r\n");

		System.out.print("연락처: ");
		String tel = scan.nextLine();

		System.out.print("주소: ");
		String address = scan.nextLine();

		System.out.print("성별(1 : 남자, 2: 여자):");
		int gender = scan.nextInt();
		scan.skip("\r\n");

		System.out.print("과목: ");
		String subject = scan.nextLine();

		Teacher.temp++; // 공용변수, 살아있는 변수
		map.put(Teacher.temp, new Teacher());
		map.get(Teacher.temp).setSeq(Teacher.temp); // 자기 개인 번호로 받아
		map.get(Teacher.temp).setName(name);
		map.get(Teacher.temp).setAge(age);
		map.get(Teacher.temp).setAddress(address);
		map.get(Teacher.temp).setTel(tel);
		map.get(Teacher.temp).setAddress(address);
		map.get(Teacher.temp).setGender(gender);
		map.get(Teacher.temp).setSubject(subject);

		// 잠시 멈춤
		pause(scan);

	}//add
		
	public void list() {
		
		title(Title.LIST);
		
		System.out.println("[번호]\t[이름]\t[나이]\t[연락처]\t\t[주소]\t\t[성별]\t[과목]");

		Set<Integer> set = map.keySet();
		for (Integer key : set) {
			System.out.printf("%3d\t%s\t%d\t%s\t%s\t%s\t%s\t\n", 
					map.get(key).getSeq(), 
					map.get(key).getName(),
					map.get(key).getAge(),
					map.get(key).getTel(), 
					map.get(key).getAddress(),
					map.get(key).getGender() == 1 ? "남" : "여", 
					map.get(key).getSubject());
		}
		
		pause(scan);
		
	}
	
	public void correct() {
		title(Title.CORRECT);
		System.out.println("강사 수정: ");

		list();

		Set<Integer> set = map.keySet();
		System.out.print("수정할 강사 번호: ");
		int num = scan.nextInt();
		scan.nextLine();
		int find = 0;
		for (Integer key : set) {
			if (map.get(key).getKey() == num) {
				find = key;
			}
		}
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("1. 이름");
		System.out.println("2. 나이");
		System.out.println("3. 연락처");
		System.out.println("4. 주소");
		System.out.println("5. 성별");
		System.out.println("6. 과목");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.print("수정할 번호: ");
		int num1 = scan.nextInt();
		scan.nextLine();
		boolean loop = true;
		while (loop) {
			switch (num1) {
			case 1:
				System.out.print("이름: ");
				String name = scan.nextLine();
				map.get(find).setName(name);
				loop = false;
				break;
			case 2:
				System.out.print("나이: ");
				int age = scan.nextInt();
				scan.skip("\r\n");
				map.get(find).setAge(age);
				loop = false;
				break;
			case 3:
				System.out.print("연락처: ");
				String tel = scan.nextLine();
				map.get(find).setTel(tel);
				loop = false;
				break;
			case 4:
				System.out.print("주소: ");
				String address = scan.nextLine();
				map.get(find).setAddress(address);
				loop = false;
				break;
			case 5:
				System.out.print("성별: ");
				int gender = scan.nextInt();
				scan.skip("\r\n");
				map.get(find).setGender(gender);
				loop = false;
				break;
			case 6:
				System.out.print("과목: ");
				String subject = scan.nextLine();
				map.get(find).setSubject(subject);
				loop = false;
				break;
			default:
				System.out.println("잘못된 숫자를 입력하셨습니다.");
			}
		}
	}
	
	public void delete() {
		
		title(Title.DELETE);
		
		list();

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
		
		pause(scan);

	}
	
	public void search3() {
		
		title(Title.SEARCH);
		
		System.out.print("검색(전화번호): "); // 홍길동 > 길동 검색률을 높임 
		String word = scan.nextLine();

		listName(word);
		
		pause(scan);
		
	}
	
	public void search2() {
		
		title(Title.SEARCH);

		System.out.print("검색(교과목): "); // 홍길동 > 길동 검색률을 높임
		String word = scan.nextLine();

		listName(word);
		Set<Integer> set = map.keySet();
		for (Integer key : set) {

			// if(s.getName().contains(word)) {
			// if(s.getName().toUpperCase().contains(word.toUpperCase())) // 대소문자 구분 없이 한쪽으로
			// 몰아야 돼 그걸 안하면 철저하게 찾는 거임
			if (map.get(key).getSubject().toUpperCase().indexOf(word.toUpperCase()) > -1) {
				System.out.printf("%5d\t%s\t%d\t%s\t%s\t%s\t%s\t\n", 
						map.get(key).getSeq(), 
						map.get(key).getName(),
						map.get(key).getAge(),
						map.get(key).getTel(), 
						map.get(key).getAddress(),
						map.get(key).getGender() == 1 ? "남자" : "여자", 
						map.get(key).getSubject());
			}

		}
		pause(scan);
	}
	
	public void search() {
		
		title(Title.SEARCH);
		
		// 검색?
		// -> list() 작업과 유사
		// 1. list(): 모든 데이터 출력
		// 2. search(): 일부 데이터 출력. 조건부 list()

		System.out.print("검색(강사명): "); // 홍길동 > 길동 검색률을 높임
		String word = scan.nextLine();

		System.out.println("[번호]\t[이름]\t[나이]\t[연락처]\t\t[주소]\t\t[성별]\t[과목]");
		Set<Integer> set = map.keySet();
		for (Integer key : set) {

			// if(s.getName().contains(word)) {
			// if(s.getName().toUpperCase().contains(word.toUpperCase())) // 대소문자 구분 없이 한쪽으로
			// 몰아야 돼 그걸 안하면 철저하게 찾는 거임
			if (map.get(key).getName().indexOf(word) > -1) {
				System.out.printf("%5d\t%s\t%d\t%s\t%s\t%s\t%s\t\n", 
						map.get(key).getSeq(), 
						map.get(key).getName(),
						map.get(key).getAge(),
						map.get(key).getTel(), 
						map.get(key).getAddress(),
						map.get(key).getGender() == 1 ? "남자" : "여자", 
						map.get(key).getSubject());
			}

		}
		
		pause(scan);
		
	}
	
	private static void listName(String word) {
		
		System.out.println("[번호]\t[이름]\t[나이]\t[연락처]\t[주소]\t[성별]\t[과목]");
		Set<Integer> set = map.keySet();
		for (Integer key : set) {
			if (map.get(key).getTel().replace("-", "").contains(word)) {
				System.out.printf("%5d\t%s\t%d\t%s\t%s\t%s\t%s\t\n", 
						map.get(key).getSeq(), 
						map.get(key).getName(),
						map.get(key).getAge(),
						map.get(key).getTel(), 
						map.get(key).getAddress(),
						map.get(key).getGender() == 1 ? "남자" : "여자", 
						map.get(key).getSubject());
			}
		}
			
	}//listName
	
	public void leacherDummy() throws Exception {
		
		int length = 10;
		String[] temp1 = { "김", "이", "박", "최", "정", "진","홍" };
		String[] temp2 = { "유", "정", "석", "인", "지", "은", "형", "순", "성", "민" };
		String[] temp3 = { "서울시", "인천시", "부산시", "대전시", "광주시" };
		String[] temp4 = { "강남구", "강서구", "강북구", "강동구" };
		String[] temp5 = { "Java", "Pthyon", "C#", "Android", "Linux", "HTML", "WML", "Javascript"};
		Random rnd = new Random();
		String path = "C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\강사.txt";
		File file = new File(path);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\강사.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		for(int i=0;i<length;i++) {
			Teacher s = new Teacher();
			map.put(i, s);
		}
		
		
		//if문 전에 열어야 돼~
		int cnt=1;
		if (file.exists()) {
			for (int i=0;i<length;i++) {
				
				Teacher.temp++;
				map.get(i).setSeq(Teacher.temp);

				String name = temp1[rnd.nextInt(temp1.length)] + temp2[rnd.nextInt(temp2.length)]
						+ temp2[rnd.nextInt(temp2.length)];

				int age = rnd.nextInt(10) + 20;

				String address = temp3[rnd.nextInt(temp3.length)] + " " + temp4[rnd.nextInt(temp4.length)];
				String tel = "010-" + (rnd.nextInt(9000) + 1000) + "-" + (rnd.nextInt(9000) + 1000);
				map.get(i).setKey(cnt);
				map.get(i).setName(name);
				map.get(i).setAge(age);
				map.get(i).setAddress(address);
				map.get(i).setTel(tel);
				map.get(i).setSubject(temp5[rnd.nextInt(temp5.length)]);
				map.get(i).setGender(rnd.nextInt(2)+1);
				try {
					writer.write(map.get(i).getSeq() + "," + map.get(i).getName() + "," + map.get(i).getAge() + ","
							+ map.get(i).getSubject() + "," +map.get(i).getAddress() +"," + map.get(i).getTel() + "," + map.get(i).getGender() + "," + map.get(i).getKey()
							+ "\r\n");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				cnt++;
			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
			writer.close();

	}
	
	public void pause(Scanner scan) {
		
		System.out.println();
		System.out.println("완료되었습니다.");
		System.out.println("계속하려면 엔터를 입력하세요.");
		
		scan.nextLine();
		
	}//pause
	
}//Admin_Lecture