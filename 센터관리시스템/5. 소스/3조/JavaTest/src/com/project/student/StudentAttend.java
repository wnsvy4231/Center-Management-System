package com.project.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentAttend { //수강생 모드 > 3.출결 확인
	
	Scanner scan = new Scanner(System.in);

	ArrayList<Attend> list2 = new ArrayList<Attend>();
	
	public void studentAttend() throws Exception {
		
		//출결 데이터 호출
		BufferedReader reader2 = new BufferedReader(new FileReader("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\출결.txt"));

		File file2 = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\출결.txt");
		String line = null;
		
		if (file2.exists()) { //파일 체크 & 배열에 담기
			
			while ((line = reader2.readLine()) != null) {
					
					Attend a = new Attend();
					String[] temp = line.split(",");
					
					int seq = Integer.parseInt(temp[0]);
					
					a.setSeq(seq);
					a.setDate(temp[1]);
					a.setStart(temp[2]);
					a.setEnd(temp[3]);
					
					list2.add(a); 
									
			}
		}
		
		reader2.close();
		
		Output.title(Title.STUDENTINFO);
		
		System.out.println("[일자]\t\t[출석]\t[지각]\t[결석]\t[조퇴]");
		
		for (Attend a : list2) {
			
			int start = Integer.parseInt(a.getStart().substring(1,2));
			int start1 = Integer.parseInt(a.getStart().substring(3));
			int end = Integer.parseInt(a.getEnd().substring(0,2));
			int end1 = Integer.parseInt(a.getEnd().substring(3));
			
			System.out.printf("%10s\t%3s\t%3s\t  -\t%3s\n"
								, a.getDate()
								, !(start >= 9 && start1 > 0) ? "O" : "-"
								, (start >= 9 && start1 > 0) ? "O" : "-"
								, !(end >= 18 && end1 >= 0) ? "O" : "-");
		}
		
		Output.pause(scan);		
		
		
	}

}