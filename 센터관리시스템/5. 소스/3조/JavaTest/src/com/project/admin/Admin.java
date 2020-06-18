package com.project.admin;

public class Admin {

	public void main() throws Exception {
		
		Admin_menu menu = new Admin_menu();
		Admin_Lecture lec = new Admin_Lecture();
	
		lec.leacherDummy();
		
		menu.menu();
		
	}//main
	
}//Admin_main