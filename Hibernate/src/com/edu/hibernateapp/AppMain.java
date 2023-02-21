package com.edu.hibernateapp;

import com.edu.hibernateapp.model.NoticeDAO;

public class AppMain {
	
 public static void main(String[] args) {
	NoticeDAO dao = new NoticeDAO();
	dao.insert();
}

}
