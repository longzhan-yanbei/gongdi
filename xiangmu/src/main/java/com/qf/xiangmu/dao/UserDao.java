package com.qf.xiangmu.dao;

import com.qf.xiangmu.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    //通过id查询用户信息
    User selectByPrimaryKey(Integer id);

    //查询全部用户：  用户id  用户名  用户身份  所处工地  所用设备
    List<User> selectAll();

    //通过id去删除用户
    int deletById(Integer id);

    //添加一个用户
    int insertUser(User user);

    //更新一个用户
    int updateUser(User user);

    int selectMany(Integer id);

    int selectMany2(Integer id);

    //查询全部用户的账号
    List<User> selectAllName();

    int selectByName(String username);

    String selectPassWordByName(String username);
}
