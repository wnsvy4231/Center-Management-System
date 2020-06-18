package com.project.admin;

public class ItemList {

private String num;  	// 번호
private String item;    // 품목
private String sum; 	// 수량
private String day; 	// 날짜
private String price;  	// 가격
private String cheak; 	// 불량, 양호
private String made; 	// 제조사
private String data; 	// 비고
Itemthis a = new Itemthis();


public ItemList(String num, String item, String sum, String day, String price, String cheak, String made, String data) {
	super();
	this.num = num;
	this.item = item;
	this.sum = sum;
	this.day = day;
	this.price = price;
	this.cheak = cheak;
	this.made = made;
	this.data = data;
}

public String getSum() {
	return sum;
	
}

public void setSum(String sum) {
	this.sum = sum;
}

public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}






//출력 부분 양식 수5
@Override
public String toString() {
	return String.format("%3s   %7s      \t%-7s %1s %3s %7s %8s %3s\r\n", a.numf
			,item,sum,day,price,cheak,made,data);
}
public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
public String getItem() {
	return item;
}
public void setItem(String item) {
	this.item = item;
}
public String getDay() {
	return day;
}
public void setDay(String day) {
	this.day = day;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getCheak() {
	return cheak;
}
public void setCheak(String cheak) {
	this.cheak = cheak;
}
public String getMade() {
	return made;
}
public void setMade(String made) {
	this.made = made;
}

}
