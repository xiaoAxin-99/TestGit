package com.xinrong.demo.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author chengxinrong
 * @version 1.0
 * @date 2019/12/11 1:17 下午
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AceBaoBean {

    public static final String DATA_SOURCE="DataSource";
    public static final String SQL_SESSION_FACTORY="SqlSessionFactory";
    public static final String SQL_SESSION_TEMPLATE="SqlSessionTemplate";
    public static final String TRANSACTION_MANAGER="TM";

    public static final String ENTRY ="ENTRY";
    public static final String ENTRY_FACTORY = ENTRY + SQL_SESSION_FACTORY;
    public static final String ENTRY_TEMPLATE = ENTRY + SQL_SESSION_TEMPLATE;
    public static final String ENTRY_TRANSACTION_MANAGE = ENTRY + TRANSACTION_MANAGER;
    public static final String ENTRY_DATASOURCE = ENTRY + DATA_SOURCE;
}
