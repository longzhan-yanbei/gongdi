package com.qf.xiangmu.service;

import com.github.pagehelper.PageInfo;
import com.qf.xiangmu.dao.UserDao;
import com.qf.xiangmu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zzj
 * @version V1.0
 * @date 2021/10/28
 **/
public interface UserService {

    /**
     * 分页查询:查询全部用户：  用户id  用户名  用户身份  所处工地  所用设备
     * @param page
     * @param limit
     * @return
     */
    PageInfo selectAll(Integer page, Integer limit);

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    User selectUserById(int id);

    /**
     * 通过id删除用户
     * @param id
     * @return
     */
    int deletUserById(int id);

    /**
     * 添加一个User
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 更新一个用户
     * @param user
     * @return
     */
    int updateUser(User user);


    /**
     * 查询全部的用户名
     * @return
     */
    List<User> selectAllName();

}
