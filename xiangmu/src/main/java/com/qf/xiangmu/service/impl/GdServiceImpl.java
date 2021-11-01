package com.qf.xiangmu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.xiangmu.dao.GdDao;
import com.qf.xiangmu.dao.UserDao;
import com.qf.xiangmu.pojo.Gd;
import com.qf.xiangmu.pojo.Sb;
import com.qf.xiangmu.service.GdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zzj
 * @version V1.0
 * @date 2021/10/30
 **/
@Service
public class GdServiceImpl implements GdService {

    @Autowired
    private GdDao gdDao;

    @Autowired
    private UserDao userDao;

    /**
     * 查询所有的工地信息(分页)
     * @return
     */
    @Override
    public PageInfo selectAllGd(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Gd> users = gdDao.selectAllGd();
        PageInfo pageInfo = new PageInfo(users);
        return pageInfo;
    }

    /**
     *
     * @param gd
     * @return
     */
    @Override
    public int insertSelective(Gd gd) {
        return gdDao.insert(gd);
    }

    /**
     * 查询所有的工地信息
     * @return
     */
    @Override
    public List<Gd> selectAll() {
        return gdDao.selectAllGd();
    }

    /**
     * 通过id删除工地信息
     * @param id
     * @return
     */
    @Override
    public int deletGdById(Integer id) {
        int i = userDao.selectMany2(id);
        if(i==0){
            //返回一个i1   如果为1 那就删除成功  如果为0 就删除失败
            int i1 = gdDao.deleteByPrimaryKey(id);
            return i1;
        }
        if(i==1){
            return -1;
        }
        return i;
    }

    @Override
    public int updateGd(Gd gd) {
        return gdDao.updateByPrimaryKeySelective(gd);
    }

    @Override
    public Gd selectByPrimaryKey(Integer gdId) {
        return gdDao.selectByPrimaryKey(gdId);
    }


}
