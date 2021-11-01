package com.qf.xiangmu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zzj
 * @version V1.0
 * @date 2021/10/30
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class All {

    private List<Gd> gdList;

    private List<Sb> sbList;


}
