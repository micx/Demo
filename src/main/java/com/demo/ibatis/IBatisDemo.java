package com.demo.ibatis;

import com.demo.ibatis.dao.UserDao;
import com.demo.ibatis.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class IBatisDemo {

    public static void main(String[] args) throws IOException, SQLException {
		UserDao userDao = UserDao.getInstance();
		List<User> list = userDao.getAllUsers();
        showList(list);
	}
	private static void showList(List<User> list){
		for (User user : list) {
			System.out.println(user);
		}
	}
}
