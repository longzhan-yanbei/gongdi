package com.qf.xiangmu.contrller;

import com.github.pagehelper.PageInfo;
import com.qf.xiangmu.pojo.ResultBean;
import com.qf.xiangmu.pojo.Sb;
import com.qf.xiangmu.pojo.User;
import com.qf.xiangmu.service.SbService;
import com.qf.xiangmu.service.UserService;
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
 * @date 2021/10/29
 **/
@RestController
@RequestMapping("/sb")
@CrossOrigin
public class SbContrller {

    @Autowired
    private SbService sbService;


    /**
     * 通过id删除一个设备
     * @param id
     * @return
     */
    @RequestMapping("/delet/{id}")
    public ResultBean deletSbById(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        Integer code = sbService.deletSbById(id);
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

    /**
     *
     * @param sb
     * @return
     */
    @RequestMapping("/update")
    public ResultBean updateSb(@RequestBody Sb sb){
        ResultBean resultBean = new ResultBean();
        Integer code = sbService.updateById(sb);
        if(code==1){
            resultBean.setCode(1000);
            return resultBean;
        }
        return resultBean;
    }

    /**
     * 添加一个设备
     * @param sb
     * @return
     */
    @RequestMapping("/addSb")
    public ResultBean insertSb(@RequestBody Sb sb){
        ResultBean resultBean = new ResultBean();
        Integer code = sbService.insertSb(sb);
        if(code==1){
            resultBean.setCode(1000);
            return resultBean;
        }
        return resultBean;
    }



    /**
     * 获取全部设备列表(分页)
     * @return
     */
    @RequestMapping("/getUsersByPage/{page}/{limit}")
    public ResultBean getUsersByPage(@PathVariable Integer page, @PathVariable Integer limit){
        ResultBean resultBean = new ResultBean();
        PageInfo pageInfo = sbService.selectAll(page, limit);
        resultBean.setCode(1000);
        resultBean.setMassage("查询成功");
        resultBean.setData(pageInfo);
        return resultBean;
    }

    /**
     * 获取全部设备列表
     * @return
     */
    @RequestMapping("/getSb")
    public List<Sb> getSbByPage(){
        return sbService.selectAllSb();
    }

    /**
     * 通过设备id查询设备信息
     * @param id
     * @return
     */
    @RequestMapping("/getSbById/{id}")
    public Sb selectSbById(@PathVariable Integer id){
        return sbService.selectSbById(id);
    }
}
