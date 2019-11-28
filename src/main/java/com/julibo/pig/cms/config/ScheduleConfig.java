package com.julibo.pig.cms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

/**
 * @author carson
 * @date 2019-11-28
 */
@Configuration
public class ScheduleConfig  implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        // 开启一个固定10个大小的线程池，也使用Executors下其他的线程池
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(3));
    }
}
