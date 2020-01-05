package com.xinrong.demo.service;

import java.lang.annotation.*;

/**
 * @author chengxinrong
 * @version 1.0
 * @date 2019/12/12 1:12 下午
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RollbackConfig {
    /**
     * 回滚事件优先级
     */
    RollbackOrder value();

}
