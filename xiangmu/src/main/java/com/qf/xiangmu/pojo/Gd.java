package com.qf.xiangmu.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * t_gd
 * @author 
 */
@Data
public class Gd implements Serializable {
    private Integer gdId;

    private String gdName;

    private String gdAddr;

    private String gdInfo;

    private static final long serialVersionUID = 1L;
}