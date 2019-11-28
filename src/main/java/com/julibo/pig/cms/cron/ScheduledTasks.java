package com.julibo.pig.cms.cron;


import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author carson
 * @date 2019-11-28
 */
@Component
@Log4j2
public class ScheduledTasks {

    /**
     * 一般用法详解
     *
     * initialDelay表示一个初始延迟时间，第一次被调用前延迟的时间
     * fixedDelay表示一个固定延迟时间执行，上个任务完成后,延迟多久执行
     */

    /**
     * 启动立即执行
     * 每5秒执行一次
      */
    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
    public void test1() {
        log.info("test1这里，每5秒执行一次。");
    }

    /**
     * 每5秒执行一次
     */
    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
    public void test2() {
        log.info("test2这里，每5秒执行一次");
    }


    /**
     * 固定时间才执行，即为10秒的整数倍执行，比如20秒，30秒，40秒时，会执行
     * 每10秒执行一次
     */
    @Scheduled(cron = "*/10 * * * * *")
    public void test3() {
        log.info("test3这里，每10秒执行一次");
    }
}
