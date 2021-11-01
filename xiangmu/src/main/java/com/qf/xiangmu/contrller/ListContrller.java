package com.qf.xiangmu.contrller;

import com.qf.xiangmu.pojo.All;
import com.qf.xiangmu.pojo.Gd;
import com.qf.xiangmu.pojo.Sb;
import com.qf.xiangmu.service.GdService;
import com.qf.xiangmu.service.SbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zzj
 * @version V1.0
 * @date 2021/10/30
 **/
@RestController
@RequestMapping("/list")
@CrossOrigin
public class ListContrller {

    @Autowired
    private SbService sbService;
    @Autowired
    private GdService gdService;

    @RequestMapping("/all")
    public All selectAll(){
        All all = new All();
        all.setGdList(gdService.selectAll());
        all.setSbList(sbService.selectAllSb());
        return all;
    }

}
