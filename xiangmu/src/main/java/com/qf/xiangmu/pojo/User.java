package com.qf.xiangmu.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * t_user
 * @author
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private Integer admin;

    private Integer gdId;

    private Integer sbId;

    private Gd gd;
    private Sb sb;

    private static final long serialVersionUID = 1L;
}
