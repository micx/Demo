package com.demo.ibatis.dao;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.demo.ibatis.model.User;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by chenxi.chen on 2014/07/09/下午12:59.
 */
public class UserDao {
    private static SqlMapClient sqlMap = null;
    static {
        String config = "config/sqlmap/SqlMapConfig.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
    }
    public List<User> getAllUsers() throws SQLException {
    System.out.println("\nUse ResultMap:");
    List<User> list = sqlMap.queryForList("getnewAllUsers");

    return list;
    }

    public boolean insertUser(User user) throws SQLException {
        System.out.println("insert id=" + sqlMap.insert("insertUser", user));
		return true;//sqlMap.insert("insertUser",user);
    }

//    iuser.setUserId(6);
//    iuser.setUserName("micx0124");
//    iuser.setPassword("987654321");
    public boolean updateUser(User user) throws SQLException {
        sqlMap.update("updateUser", user);
        return true;
    }
    public boolean deleteUserByUserId(int id) throws SQLException {
        System.out.println("\ndelete the user where id = 5");
        sqlMap.delete("deleteUserById", id);
        return true;
    }
}
