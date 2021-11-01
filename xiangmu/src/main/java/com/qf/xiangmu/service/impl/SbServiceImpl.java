package com.qf.xiangmu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.xiangmu.dao.SbDao;
import com.qf.xiangmu.dao.UserDao;
import com.qf.xiangmu.pojo.Sb;
import com.qf.xiangmu.pojo.User;
import com.qf.xiangmu.service.SbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zzj
 * @version V1.0
 * @date 2021/10/29
 **/
@Service
public class SbServiceImpl implements SbService {

    @Autowired
    private SbDao sbDao;

    @Autowired
    private UserDao userDao;
    /**
     * 通过id删除一个设备
     * @param sb_id
     * @return
     */
    @Override
    public int deletSbById(Integer sb_id){
        int i = userDao.selectMany(sb_id);
        if(i==0){
            //返回一个i1   如果为1 那就删除成功  如果为0 就删除失败
            int i1 = sbDao.deleteByPrimaryKey(sb_id);
            return i1;
        }
        if(i==1){
            return -1;
        }
        return i;
    }


    /**
     * 查询全部的设备(分页)
     * @return
     */
    @Override
    public PageInfo selectAll(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Sb> users = sbDao.selectAllSb();
        PageInfo pageInfo = new PageInfo(users);
        return pageInfo;
    }

    /**
     * 查询全部的设备
     * @return
     */
    @Override
    public List<Sb> selectAllSb() {
        return sbDao.selectAllSb();
    }


    /**
     * 通过id查询设备
     * @param sb_id
     * @return
     */
    @Override
    public Sb selectSbById(Integer sb_id) {
        return sbDao.selectByPrimaryKey(sb_id);
    }

    /**
     * 添加一个设备
     * @param sb
     * @return
     */
    @Override
    public int insertSb(Sb sb) {
        return sbDao.insertSelective(sb);
    }

    @Override
    public int updateById(Sb sb) {
        return sbDao.updateByPrimaryKeySelective(sb);
    }


}
