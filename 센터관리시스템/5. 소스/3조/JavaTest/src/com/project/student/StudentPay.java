package com.project.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentPay { //수강생 모드 > 6.결재 안내
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Guest> list = new ArrayList<Guest>();
	ArrayList<Student> list2 = new ArrayList<Student>();
	
	public void studentPay() throws Exception {
		
		//교육과정, 수강생 데이터 호출
		BufferedReader reader = new BufferedReader(new FileReader("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\교과과정.txt"));
		BufferedReader reader2 = new BufferedReader(new FileReader("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\수강생.txt"));
		File file = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\교과과정.txt");
		File file2 = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\수강생.txt");
		String line = null;
		
		if (file.exists() && file2.exists()) { //파일 체크 & 배열에 담기
			
			while ((line = reader.readLine()) != null) {
				
				Guest g = new Guest();
				String[] temp = line.split(",");
				
				int seq = Integer.parseInt(temp[0]);
				int money = Integer.parseInt(temp[12]);
				
				g.setSeq(seq);
				g.setName(temp[1]);
				g.setC(temp[3]);
				g.setC_1(temp[4]);
				g.setMoney(money);
				
				list.add(g);			
				
			}
			
			while ((line = reader2.readLine()) != null) {
				
				Student s = new Student();
				String[] temp = line.split(",");
				
				int seq = Integer.parseInt(temp[0]);
				int age = Integer.parseInt(temp[2]);
				int gender = Integer.parseInt(temp[3]);
				int score = Integer.parseInt(temp[6]);
				int room = Integer.parseInt(temp[10]);
				
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
				s.setRoom_num(room);
				s.setMemo(temp[11]);
				
				list2.add(s);			
				
			}
			
		}
		reader.close();
		reader2.close();
		
		Output.title(Title.STUDENTPAY);
		
		System.out.println("[번호]\t[교과목]\t\t\t\t\t\t[교육기간]\t\t\t[금액]");
		
		for (Guest g : list) {
			
			System.out.printf("%4d\t%s\t%s ~ %s\t\t%,d원\n"
								, g.getSeq()
								, g.getName()
								, g.getC_1()
								, g.getC()
								, g.getMoney());			
			
		}		
		
		boolean loop = true;
		
		while (loop) {
		
			Output.studentPay();
			String sel = scan.nextLine();
			
			if (sel.equals("1")) { //번호별 입력값 & 유효성 검사
				
				System.out.println("결재 페이지입니다.");
				System.out.println("□□□□□□□□□□□□□□□");
				System.out.print("과목 번호(숫자) : ");
				int num = scan.nextInt();
				scan.skip("\r\n");
				if (num > 10 || num < 0) {
					System.out.println("올바른 과목 번호가 아닙니다.");
					break;
				} else {
					loop = true;
				}
				
				System.out.print("결재 카드(은행명) : ");
				String bank = scan.nextLine();
				for (int i = 0; i < bank.length(); i++) {
					char c = bank.charAt(i);
					if ((c < '가' || c > '힣') && (c == ' ')) {
						System.out.println("올바른 카드사가 아닙니다.");
						StudentPay p = new StudentPay();
						p.studentPay();
					} else {
						loop = true;
					}
				}
				
				System.out.print("결재 금액 : ");
				int money = scan.nextInt();
				scan.skip("\r\n");
				if (!(list.get(num-1).getMoney() == money)) {
					System.out.println("올바른 금액이 아닙니다.");
					break;
				} else {
					loop = true;
				}		
	
				System.out.print("결재 확인(확인 : 1, 취소 : 2) : ");
				int check = scan.nextInt();
				scan.skip("\r\n");
				if (check == 1) {
					System.out.println("결재가 완료되었습니다.");
					
					filewrite();
					
					Output.pause(scan);
					
				} else if (check == 2) {
					System.out.println("결재가 취소되었습니다.");
					Output.pause(scan);
				}
				
			} else {
				loop = false;
			}
		
		}
		
	}

	private void filewrite() {
		Login ro = new Login();
		int a = ro.stdNum;
		
		String path = "C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\수강생.txt";
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path, false));
			
			list2.get(a).setPay("O");
			
			for (int i=0; i<list2.size(); i++) {
			
				writer.write(list2.get(Student.mainTemp).getSeq() + "," + list2.get(Student.mainTemp).getName() + "," 
				+ list2.get(Student.mainTemp).getAge() + "," + list2.get(Student.mainTemp).getGender() + "," 
						+ list2.get(Student.mainTemp).getTel() + "," + list2.get(Student.mainTemp).getAddress() + "," 
					+ list2.get(Student.mainTemp).getScore() + "," + list2.get(Student.mainTemp).getGrade() + "," 
						+ list2.get(Student.mainTemp).getJob() + "," + list2.get(Student.mainTemp).getPay() + "," 
					+ list2.get(Student.mainTemp).getRoom_num() + "," + list2.get(Student.mainTemp).getMemo() + "\r\n");
				Student.mainTemp++;
			
			}
			
			writer.close();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
