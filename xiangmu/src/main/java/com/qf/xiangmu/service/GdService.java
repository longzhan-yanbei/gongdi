package com.qf.xiangmu.service;

import com.github.pagehelper.PageInfo;
import com.qf.xiangmu.pojo.Gd;
import com.qf.xiangmu.pojo.User;

import java.util.List;

/**
 * @author zzj
 * @version V1.0
 * @date 2021/10/30
 **/
public interface GdService {

    /**
     * 查询全部的工地信息(分页)
     * @return
     */
    PageInfo selectAllGd(Integer page, Integer limit);
    /**
     * 添加一个工地信息
     * @param gd
     * @return
     */
    int insertSelective(Gd gd);

    /**
     * 查询全部的工地信息
     * @return
     */
    List<Gd> selectAll();

    /**
     * 通过id删除工地信息
     * @param id
     * @return
     */
    int deletGdById(Integer id);

    int updateGd(Gd gd);

    Gd selectByPrimaryKey(Integer gdId);


}
