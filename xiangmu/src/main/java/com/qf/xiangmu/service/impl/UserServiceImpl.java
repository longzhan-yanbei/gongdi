package com.qf.xiangmu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.xiangmu.dao.UserDao;
import com.qf.xiangmu.pojo.User;
import com.qf.xiangmu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.tree.VariableHeightLayoutCache;
import java.util.List;

/**
 * @author zzj
 * @version V1.0
 * @date 2021/10/28
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 分页查询:查询全部用户：  用户id  用户名  用户身份  所处工地  所用设备
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo selectAll(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<User> users = userDao.selectAll();
        PageInfo pageInfo = new PageInfo(users);
        return pageInfo;
    }


    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    @Override
    public User selectUserById(int id) {
        return userDao.selectByPrimaryKey(id);
    }

    /**
     * 通过id删除用户
     * @param id
     * @return
     */
    @Override
    public int deletUserById(int id) {
        return userDao.deletById(id);
    }

    /**
     * 增加一个用户
     * @param user
     * @return
     */
    @Override
    public int insertUser(User user) {
        System.out.println(user);
        return userDao.insertUser(user);
    }

    /**
     * 更新一个用户
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    /**
     * 查询全部的用户名
     * @return
     */
    @Override
    public List<User> selectAllName() {
        return userDao.selectAllName();
    }

}
