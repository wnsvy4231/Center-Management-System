package com.project.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StudentTimetable { //수강생 모드 > 7.시간표 확인
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Timetable> list = new ArrayList<Timetable>();	
	
	public void studentTimetable() throws Exception {
	
		BufferedReader reader = new BufferedReader(new FileReader("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\시간표.txt"));
		File file = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\시간표.txt");
		String line = null;
		
		if (file.exists()) {
			while ((line = reader.readLine()) != null) {
				
				Timetable t = new Timetable();
				String[] temp = line.split(",");
				Random rnd = new Random();
				
				t.setTimetable1(temp[rnd.nextInt(14)]);
				t.setTimetable2(temp[rnd.nextInt(14)]);
				t.setTimetable3(temp[rnd.nextInt(14)]);
				t.setTimetable4(temp[rnd.nextInt(14)]);
				t.setTimetable5(temp[rnd.nextInt(14)]);
				
				list.add(t);
				
			}
		}
		
		reader.close();
		
		Output.title(Title.TIMETABLE);
		
		System.out.println("   월\t\t화\t\t수\t\t목\t\t금");
		
		for (Timetable t : list) {
			
			System.out.printf("%s\t%s\t%s\t%s\t%s\n"
								, t.getTimetable1()
								, t.getTimetable2()
								, t.getTimetable3()
								, t.getTimetable4()
								, t.getTimetable5());
						
		}		
		
		Output.pause(scan);
	
	}

}
