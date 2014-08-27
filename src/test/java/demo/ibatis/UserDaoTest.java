package demo.ibatis;
import com.demo.annotation.apt.Person;
import com.demo.ibatis.dao.UserDao;
import com.demo.ibatis.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by chenxi.chen on 2014/07/09/下午3:25.
 */
public class UserDaoTest extends demo.ibatis.AbstractTestObject{
    @Autowired
    private UserDao userDao;
    @Test
    public void testQuery() throws SQLException {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
//        userDao = (UserDao) ctx.getBean("userDao");
        Person person = new Person();
        List<User> list = userDao.getAllUsers();
        showList(list);
    }

    private static void showList(List<User> list){
    for (User user : list) {
        System.out.println(user);
    }
}
}
