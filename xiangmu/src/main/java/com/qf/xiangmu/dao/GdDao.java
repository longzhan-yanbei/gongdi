package com.qf.xiangmu.dao;

import com.qf.xiangmu.pojo.Gd;

import java.util.List;

public interface GdDao {

    /**
     * 删除一个工地by工地id
     * @param gdId
     * @return
     */
    int deleteByPrimaryKey(Integer gdId);

    int insert(Gd record);



    Gd selectByPrimaryKey(Integer gdId);

    int updateByPrimaryKeySelective(Gd record);

    int updateByPrimaryKey(Gd record);

    /**
     * 查询全部的工地
     * @return
     */
    List<Gd> selectAllGd();

    /**
     * 添加一个工地信息
     * @param record
     * @return
     */
    int insertSelective(Gd record);
}
