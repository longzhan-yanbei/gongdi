package com.qf.xiangmu.dao;

import com.qf.xiangmu.pojo.Sb;
import com.qf.xiangmu.pojo.User;

import java.util.List;

public interface SbDao {
    /**
     * 通过id删除一个设备
     * @param sbId
     * @return
     */
    int deleteByPrimaryKey(Integer sbId);


    /**
     * 查询全部的设备
     * @return
     */
    List<Sb> selectAllSb();

    /**
     * 通过id查询设备信息
     * @param sbId
     * @return
     */
    Sb selectByPrimaryKey(Integer sbId);


    /**
     * 更新一个设备
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Sb record);



    int insert(Sb record);

    /**
     * 添加一个设备
     * @param record
     * @return
     */
    int insertSelective(Sb record);



    int updateByPrimaryKey(Sb record);
}
