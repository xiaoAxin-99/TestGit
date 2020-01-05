package com.xinrong.demo.service;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author chengxinrong
 * @version 1.0
 * @date 2019/12/12 1:29 下午
 */

@Getter
@Setter
public class AceResponse<T> implements Serializable {


    public static final int FAILURE = 0;
    public static final int SUCCESS = 1;
}
