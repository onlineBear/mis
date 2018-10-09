package org.anson.mis.dao.system;

import org.anson.mis.entity.system.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    private User user = new User();

    @Test
    public void getOne(){
        userDao.getOne(1L);
    }

    @Test
    public void save(){
        user.setId(1L);
        user.setEmail("email");
        user.setMobile("13480947232");
        user.setName("name");
        user.setNo("no");
        user.setPassword("password");
        user.setPersonalStatement("个性签名");
        user.setProfilePhoto("");
        user.setPersonalStatement("");
        user.setLastUpdateTime(new Date());
        userDao.save(user);
    }
}
