package org.anson.mis.dao.system;

import org.anson.mis.entity.system.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuDaoTest {
    @Autowired
    private MenuDao menuDao;

    private Menu menu = new Menu();

    private Menu parentMenu = new Menu();

    @Test
    public void save(){

        menu.setId(1L);
        menu.setContent(false);
        menu.setDescription("");
        menu.setDisplay(false);
        menu.setIcon("");
        menu.setLevel(0);
        menu.setName("");
        menu.setNo("");
        menu.setLastUpdateTime(new Date());

        parentMenu.setId(0L);
        //menu.setParentMenu(parentMenu);

        menuDao.save(menu);
    }
}
