package com.project.teacher;

import java.io.File;

public class Data {
	private int seq;
	private String date;
	private File file;
	public static int temp;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		if(seq>0)
		this.seq = seq;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}

}
