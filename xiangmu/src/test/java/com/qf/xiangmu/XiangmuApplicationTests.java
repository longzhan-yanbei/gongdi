package com.qf.xiangmu;

import com.qf.xiangmu.dao.GdDao;
import com.qf.xiangmu.dao.SbDao;
import com.qf.xiangmu.dao.UserDao;

import com.qf.xiangmu.pojo.Sb;
import com.qf.xiangmu.pojo.User;
import com.qf.xiangmu.service.SbService;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;


@SpringBootTest
class XiangmuApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private GdDao gdDao;

    @Autowired
    private SbDao sbDao;

    @Autowired
    private SbService sbService;


    @Test//通过-----User-----通过id查询一个用户
    void test01(){
        User users = userDao.selectByPrimaryKey(2);
        System.out.println(users);
    }

    @Test//通过-----User-----添加一个用户
    void test02(){
        val user = new User();
        user.setUsername("6666");
        user.setPassword("123");
        System.out.println(userDao.insertUser(user));
    }

    @Test//通过-----User-----删除一个用户
    void test03(){
        System.out.println(userDao.deletById(19));
    }

    @Test//通过-----User-----查询全部用户
    void test04(){
        System.out.println(userDao.selectAll());
    }

    @Test
    void test05(){
        val user = new User();
        user.setUsername("wwww");
        user.setPassword("wwww");
        user.setId(15);
        userDao.updateUser(user);
    }

    @Test//通过-----Sb-----删除一个设备
    void test11(){
        System.out.println(sbDao.deleteByPrimaryKey(4));
    }

    @Test
    void test12(){
        System.out.println(sbDao.selectAllSb());
    }

    @Test//通过-----Sb-----添加一个设备
    void test13(){
        val sb = new Sb();
        sb.setSbName("拖拉机");
        sb.setSbMod("大型");
        sbDao.insertSelective(sb);
    }

    @Test
    void test14(){
        int i = sbService.deletSbById(15);
        System.out.println(i);
    }

    @Test
    void test21(){
        System.out.println(gdDao.selectAllGd());
    }

}
