package com.project.teacher;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.project.teacher.Teacher_Login;

public class Data_Test {

	private static Data_Output output;
	private static Scanner scan;
	private static ArrayList<File> list;

	static {
		output = new Data_Output();
		scan = new Scanner(System.in);
		list = new ArrayList<File>();
	}

	public static void Teacher_Data_Check(String id) {
	
		try {
			String path = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\수업자료";
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
			} 
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		boolean loop1 = true;

		while (loop1) {

			output.menu();

			String sel = scan.nextLine();

			if (sel.equals("1")) {
				upload();
			} else if (sel.equals("2")) {
				list();
			} else if (sel.equals("3")) {
				delete();
			} else if (sel.equals("4")) {
				correct();
			} else if (sel.equals("5")) {
				// 수업자료 검색(이름)
				search();
			} else if (sel.equals("6")) {
				// 수업자료 검색(년)
				search2();
			} else if (sel.equals("7")) {
				System.out.println("이전 페이지로 돌아갑니다.");
				loop1 = false;
			}

		}
		
		Teacher_Login.teacher(id);
	} // main
	


	private static void correct() {
		output.title(Data_Title.CORRECT);

		list();
		
		System.out.print("수정할 수업자료 번호: ");
		int num = scan.nextInt();
		scan.nextLine();

		read();
		
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("1. 이름");
		System.out.println("2. 내용 수정");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.print("수정할 번호: ");
		int num1 = scan.nextInt();
		scan.nextLine();
		boolean loop = true;
		while (loop) {
			switch (num1) {
			case 1:
				//System.out.println(num);
				String path = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\수업자료";
				System.out.print("이름(확장자 파일명까지 입력): ");
				String name = scan.nextLine();
				File file = new File(path + "\\" + name);
				Boolean loop1 = list.get(num-1).renameTo(file);
				if (loop1) {
					System.out.println("이름 수정에 성공했습니다.");
					System.out.println(file.getName());
					list.set(num-1, file);
			
				} else {
					System.out.println("이름 수정에 실패했습니다.");
				}
				loop = false;
				break;
			case 2:
				BufferedWriter writer = null;
				String txt = "";
				try {
					writer = new BufferedWriter(new FileWriter(list.get(num-1), true));
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.print("내용(q를 입력하면 종료): ");
				while (true) {
					try {
						String context = scan.nextLine();
						if (context.equals("q")) {
							writer.write(txt);
							writer.close();
							break;
						}
						txt += context + "\r\n";
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				
				loop = false;
				break;

			default:
				System.out.println("잘못된 숫자를 입력하셨습니다.");
			}
		}
		list.clear();
		
	}

	private static void search2() {

		output.title(Data_Title.SEARCH);
		read();
		System.out.print("검색(년): "); // 홍길동 > 길동 검색률을 높임
		String year = scan.nextLine();
		int j=1;
		for (int i=0;i<list.size();i++) {
			if (String.format("%tF",list.get(i).lastModified()).substring(0, 4).equals(year)) {
				System.out.printf("%5d\t%s\t%s\t%s\n",j, list.get(i).getName(),
						length(list.get(i).length()), String.format("%tF",list.get(i).lastModified()));
				j++;
			}

		}
		
		
		list.clear();
		Data.temp=0;
		output.pause(scan);

	}

	private static void search() {

		output.title(Data_Title.SEARCH);
		read();

		System.out.print("검색(파일명): "); // 홍길동 > 길동 검색률을 높임
		String word = scan.nextLine();

		System.out.println("[번호]\t[파일이름]\t[크기]\t[수정한 날짜]");
		int j=1;
		for (int i=0;i<list.size();i++) {
			if (list.get(i).getName().toUpperCase().indexOf(word.toUpperCase()) > -1) {
				System.out.printf("%5d\t%s\t%s\t%s\n", j, list.get(i).getName(),
						length(list.get(i).length()), String.format("%tF",list.get(i).lastModified()));
				j++;
			}

		}
		
		list.clear();
		output.pause(scan);

	}

	private static void delete() {

		output.title(Data_Title.DELETE);

		list();
		read();
		System.out.print("삭제할 번호: ");
		int seq = scan.nextInt();
		scan.skip("\r\n");

		while(true) {
			if (seq >0 && seq<list.size()) {
				list.get(seq-1).delete();
				list.remove(seq-1);
				break;
			} else {
				System.out.println("잘못된 번호를 입력했습니다.");
			}
		}
		list.clear();
		
		output.pause(scan);
	}

	private static void list() {
		System.out.println("[번호]\t[파일이름]\t[크기]\t[수정한 날짜]");
		
		list.clear();
		
		File dir = new File("C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\수업자료");
		for (File sub : dir.listFiles()) {
			if (sub.isFile()) {
				list.add(sub);
			} else {
				System.out.println("파일이 아닙니다.");
			}
		}
		
		for (int i=0;i<list.size();i++) {
			System.out.printf("%5d\t%s\t%s\t%s\n",i+1, list.get(i).getName(),
					length(list.get(i).length()), String.format("%tF",list.get(i).lastModified()));

		}
		list.clear();

	}
	
	private static void read() {
		list.clear();
		Data.temp=0;
		String path = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\수업자료";
		File dir = new File("C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\수업자료");
		if(dir.exists()) {
		for (File sub : dir.listFiles()) {
			if (sub.isFile()) {
				list.add(sub);
			} else {
				System.out.println("파일이 아닙니다.");
			}
			}
		} else {
			System.out.println("폴더가 존재하지 않음");
		}
		
	}

	private static String length(double c) {
		String len = "";
		if (c < 1024) {
			len = String.format("%.1fB", c);
		} else if (c >= 1024 && c < 1024 * 1024) {
			len = String.format("%.1fKB", c / 1024);
		} else if (c >= 1024 * 1024 && c < 1024 * 1024 * 1024) {
			len = String.format("%.1fMB", c / (1024 * 1024));
		} else if (c >= 1024 * 1024 * 1024 && c < 1024 * 1024 * 1024 * 1024) {
			len = String.format("%.1fGB", c / (1024 * 1024 * 1024));
		} else if (c >= 1024 * 1024 * 1024 * 1024 && c < 1024 * 1024 * 1024 * 1024) {
			len = String.format("%.1fTB", c / (1024 * 1024 * 1024 * 1024));
		}
		return len;
	}

	private static void upload() {
		String path = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\수업자료";
		output.title(Data_Title.UPLOAD);
		read();
		System.out.print("이름: ");
		String name = scan.nextLine();
		boolean loop = false;
		int find = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				System.out.println("파일을 새로 다시 작성하겠습니까?");
				System.out.print("y/n :");
				find = i;
				String answer = scan.nextLine();
				if (answer.equals("y")) {
					loop = true;
				}
			}
		}
		if (loop) {
			System.out.print("내용(q를 입력하면 종료): ");
			BufferedWriter writer = null;
			File file = new File(path + "\\" + name);
			String txt = "";
			while (true) {
				try {
					String context = scan.nextLine();
					writer = new BufferedWriter(new FileWriter(file));
					if (context.equals("q")) {
						writer.write(txt);
						writer.close();
						list.set(find,file);
						//map.get(find).setDate(String.format("%tF",file.lastModified()));
						break;
					}
					txt += context + "\r\n";

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		}
		if (find == 0) {
			System.out.print("내용(q를 입력하면 종료): ");
			BufferedWriter writer = null;
			File file = new File(path + "\\" + name);
			String txt = "";
			list.add(file);
			while (true) {
				try {
					String context = scan.nextLine();
					writer = new BufferedWriter(new FileWriter(file));
					if (context.equals("q")) {
						writer.write(txt);
						writer.close();
						list.add(file);
						break;
					}
					txt += context + "\r\n";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		list.clear();
		Data.temp=0;
		// 잠시 멈춤
		output.pause(scan); 

	}

	public static void dummy() throws Exception {

		int length = 10;

		String path = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\수업자료";
		File dir = new File("C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\수업자료");

		// BufferedWriter writer = null;
		String[] context = { "안녕하세요?\r\n", "반가워요\r\n", "열심히 공부해라\r\n", "문제 잘 풀어\r\n" };
		String[] context1 = { "안녕하세요?\r\n", "반가워요\r\n", "열심히 공부해라\r\n", "문제 잘 풀어\r\n", "응응\r\n", "핳핳핳핳핳핳핳핳핳핳\r\n" };
		String[] context3 = { "안녕하세요?\r\n", "반가워요\r\n", "열심히 공부해라\r\n", "문제 잘 풀어\r\n", "응응\r\n", "핳핳핳핳핳핳핳핳핳핳\r\n" };
		Random rnd = new Random();

		// if문 전에 열어야 돼~
		int cnt = 1;
		if (dir.exists()) {
			for (int i = 0; i < length; i++) {
				String path1 = String.format("C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\수업자료\\수업자료%d.txt", cnt);
				File file = new File(path1);
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				if (file.exists()) {
					writer.write(context[rnd.nextInt(context.length)] + context1[rnd.nextInt(context1.length)]
							+ context3[rnd.nextInt(context3.length)]);
					writer.close();

				} else {
					System.out.println("파일이 존재하지 않습니다.");
				}
				cnt++;
			}
		} else {
			System.out.println("폴더가 존재하지 않습니다.");
		}


	}

}
