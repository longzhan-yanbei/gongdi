package com.qf.xiangmu.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * t_sb
 * @author 
 */
@Data
public class Sb implements Serializable {
    private Integer sbId;

    private String sbName;

    private String sbMod;

    private String sbFac;

    private static final long serialVersionUID = 1L;
}