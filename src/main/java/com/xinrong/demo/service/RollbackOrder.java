package com.xinrong.demo.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author chengxinrong
 * @version 1.0
 * @date 2019/12/12 1:08 下午
 */

@AllArgsConstructor
@Getter
public enum RollbackOrder {


    A_C;

    private int priority;

    RollbackOrder() {

    }
}
