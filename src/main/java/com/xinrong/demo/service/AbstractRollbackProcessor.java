package com.xinrong.demo.service;

import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Resource;

/**
 * @author chengxinrong
 * @version 1.0
 * @date 2019/12/12 1:03 下午
 */
@Getter
public abstract class AbstractRollbackProcessor<T> implements InitializingBean {
    @Resource
    private RollbackProcessorManager rollbackProcessorManager;

    private RollbackOrder  order;

    public  AbstractRollbackProcessor(){
        RollbackConfig config = getClass().getAnnotation(RollbackConfig.class);

        if (config == null){
            throw  new RuntimeException("Not find RollbackConfig for processor "+ getClass().getName());
        }
        order = config.value();
    }


    @Override
    @SneakyThrows
    public void afterPropertiesSet() throws Exception {
      rollbackProcessorManager.register(this);
    }

    /**
     * 根据AceRollbackEvent 获取每个 processor 需要处理的对象
     *
     * @param rollbackEvent 回滚事件
     * @return  每个 processor 需要处理的实体对象
     */
    public  abstract  T supply(AceRollbackEvent rollbackEvent);

    /**
     * 是否处理回滚事件
     *
     * @param event 回滚事件
     * @return 是否处理
     */
    public abstract  boolean accept(T event);

    /**
     *
     */
    public abstract AceResponse<Void> doProcessor(String entryId, T event);

}
