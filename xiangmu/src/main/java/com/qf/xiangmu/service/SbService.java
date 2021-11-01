package com.qf.xiangmu.service;

import com.github.pagehelper.PageInfo;
import com.qf.xiangmu.pojo.Sb;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author zzj
 * @version V1.0
 * @date 2021/10/29
 **/

public interface SbService {

    /**
     * 通过id删除一个设备
     * @param sb_id
     * @return
     */
    int deletSbById(@PathVariable Integer sb_id);

    /**
     * 查询全部的设备(分页)
     * @return
     */
    PageInfo selectAll(Integer page, Integer limit);

    /**
     * 查询全部的设备
     * @return
     */
    List<Sb> selectAllSb();

    /**
     * 通过id查询设备
     * @param sb_id
     * @return
     */
    Sb selectSbById(@PathVariable Integer sb_id);

    /**
     * 添加一个设备
     * @param sb
     * @return
     */
    int insertSb(@PathVariable Sb sb);


    /**
     * 更新一个设备
     * @param sb
     * @return
     */
    int updateById(@PathVariable Sb sb);
}
