package com.xinrong.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chengxinrong
 * @version 1.0
 * @date 2019/12/12 1:00 下午
 */
@Service
@Slf4j
public class RollbackProcessorManager {


    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private List<AbstractRollbackProcessor> processors = new LinkedList();

    public void register(AbstractRollbackProcessor processor) {

        try {
            lock.writeLock().lock();
            RollbackConfig config = processor.getClass().getAnnotation(RollbackConfig.class);
            if (config == null) {
                throw new RuntimeException("Not find RollbackConfig for processor " + getClass().getName());
            }
            int i = 0;
            for (; i < processors.size(); i++) {
                if (config.value().getPriority() < processors.get(i).getOrder().getPriority()) {
                    break;
                }
            }
            processors.add(i, processor);
        } finally {
            if (lock != null) {
                lock.writeLock().unlock();
            }
        }

    }

}
