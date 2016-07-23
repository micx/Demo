package com.demo.ibatis.dao;

import com.demo.ibatis.model.User;
import com.demo.ibatis.model.UserAddress;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by chenxi.chen on 2014/07/09/下午12:59.
 */
@Repository
public class UserDao {
    private static UserDao userDao = new UserDao();
    private static SqlMapClient sqlMap = null;



    public static UserDao getInstance(){
        return userDao;
    }
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

    public boolean updateUser(User user) throws SQLException {
        sqlMap.update("updateUser", user);
        return true;
    }
    public boolean deleteUserByUserId(int id) throws SQLException {
        System.out.println("\ndelete the user where id = 5");
        sqlMap.delete("deleteUserById", id);
        return true;
    }
    public List<UserAddress> getUserAddress(String geoHash) throws SQLException {
        return sqlMap.queryForList("getAddressByGeoHash", geoHash);
    }
}
