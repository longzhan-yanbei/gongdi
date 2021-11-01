package com.qf.xiangmu.contrller;

import com.github.pagehelper.PageInfo;
import com.qf.xiangmu.pojo.Gd;
import com.qf.xiangmu.pojo.ResultBean;
import com.qf.xiangmu.service.GdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zzj
 * @version V1.0
 * @date 2021/10/30
 **/
@RestController
@RequestMapping("/gd")
@CrossOrigin
public class GdContrller {

    @Autowired
    private GdService gdService;

    /**
     * 查询全部的工地列表
     * @return
     */
    @RequestMapping("/selectAll")
    public List<Gd> selectAllGd(){
        return gdService.selectAll();
    }

    @RequestMapping("/addGd")
    public ResultBean insertSelective(@RequestBody Gd gd){
        ResultBean resultBean = new ResultBean();
        Integer code = gdService.insertSelective(gd);
        if(code==1){
            resultBean.setMassage("成功");
            resultBean.setCode(1000);
            return resultBean;
        }
        return resultBean;
    }

    /**
     * 查询全部的工地列表(分页)
     * @return
     */
    @RequestMapping("/getGdByPage/{page}/{limit}")
    public ResultBean getUsersByPage(@PathVariable Integer page, @PathVariable Integer limit){
        ResultBean resultBean = new ResultBean();
        PageInfo pageInfo = gdService.selectAllGd(page, limit);
        resultBean.setCode(1000);
        resultBean.setMassage("查询成功");
        resultBean.setData(pageInfo);
        return resultBean;
    }

    @RequestMapping("/getGdById")
    public Gd getGdById(Integer id){
        return gdService.selectByPrimaryKey(id);
    }
    /**
     * 通过id删除一个设备
     * @param id
     * @return
     */
    @RequestMapping("/delet/{id}")
    public ResultBean deletSbById(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        Integer code = gdService.deletGdById(id);
        if(code==1){
            resultBean.setCode(1000);
            resultBean.setMassage("成功");
            System.out.println("成功-------------"+resultBean);
            return resultBean;
        }else if(code==-1){
            resultBean.setCode(1);
            resultBean.setMassage("失败");
            System.out.println("失败-------------"+resultBean);
            return resultBean;
        }else {
            resultBean.setCode(code);
            resultBean.setMassage("失败");
            System.out.println("失败-------------"+resultBean);
            return resultBean;
        }
    }

    @RequestMapping("/update")
    public ResultBean updateGd(@RequestBody Gd gd){
        ResultBean resultBean = new ResultBean();
        Integer code = gdService.updateGd(gd);
        if(code==1){
            resultBean.setCode(1000);
            return resultBean;
        }
        return resultBean;
    }


}
