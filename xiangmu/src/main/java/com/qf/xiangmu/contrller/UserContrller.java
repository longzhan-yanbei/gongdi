package com.qf.xiangmu.contrller;

import com.github.pagehelper.PageInfo;
import com.qf.xiangmu.dao.UserDao;
import com.qf.xiangmu.pojo.ResultBean;
import com.qf.xiangmu.pojo.User;
import com.qf.xiangmu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zzj
 * @version V1.0
 * @date 2021/10/28
 **/
@RestController
@RequestMapping("/user")
@CrossOrigin("http://10.31.161.20:9528")
public class UserContrller {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @PostMapping("/login")
    @ResponseBody
    public ResultBean login(@RequestBody User user){
        ResultBean resultBean = new ResultBean();
        String username = user.getUsername();//用户名
        int i = userDao.selectByName(username);//判断是否有这个用户名，1的时候是有，0的时候没有
        if(i==1){
            String password = userDao.selectPassWordByName(username);//获取密码
            resultBean.setCode(20000);
            User user1 = new User();
            user1.setUsername(username);
            user1.setPassword(password);
            if (user1.getPassword().equals(user.getPassword())){
                resultBean.setData(user1);
                return resultBean;
            }else {
                resultBean.setCode(40000);
                return resultBean;
            }

        }else {
            resultBean.setCode(40000);
            return resultBean;
        }
    }
    /**
     * 分页查询使用
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/getUsersByPage/{page}/{limit}")
    public ResultBean getUsersByPage(@PathVariable Integer page, @PathVariable Integer limit){
        ResultBean resultBean = new ResultBean();
        PageInfo pageInfo = userService.selectAll(page, limit);
        resultBean.setCode(1000);
        resultBean.setMassage("查询成功");
        resultBean.setData(pageInfo);
        return resultBean;
    }

    /**
     * 查询user信息通过id
     * @param id
     * @return
     */
    @RequestMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.selectUserById(id);
    }

    /**
     * 通过id删除user
     * @param id
     * @return
     */
    @RequestMapping("/removeUser/{id}")
    public int deletUserById(@PathVariable Integer id){
        return userService.deletUserById(id);
    }

    /**
     * 添加一个user
     * @param user
     * @return
     */
    @PostMapping("/register")
    //@ResponseBody
    public ResultBean insertUser(@RequestBody User user){
        ResultBean resultBean = new ResultBean();

        Integer code = userService.insertUser(user);
        if(code==1){
            resultBean.setCode(1000);
            return resultBean;
        }
        return resultBean;
    }

    /**
     * 更新一个user
     * @param user
     * @return
     */
    @RequestMapping("/modifyUser")
    public ResultBean updateUser(@RequestBody User user){
        ResultBean resultBean = new ResultBean();
        Integer code = userService.updateUser(user);
        if(code==1){
            resultBean.setCode(1000);
            return resultBean;
        }
         return resultBean;
    }

    @RequestMapping("/selectAllName")
    public List<User> selectAllName(){
        return userService.selectAllName();
    }

}


