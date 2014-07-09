package com.demo.ibatis;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import com.demo.ibatis.dao.UserDao;
import com.demo.ibatis.model.User;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.*;
public class IBatisDemo {
	private static UserDao userDao = new UserDao();
    public static void main(String[] args) throws IOException, SQLException {
        List<User> list = userDao.getAllUsers();
        showList(list);
	}
	private static void showList(List<User> list){
		for (User user : list) {
			System.out.println(user);
		}
	}
}
