package com.hmd.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: <a href="mailto:nonamelnl@126.com">NoNamelnl</a>
 * @version: 1.0
 * @create: 2018/6/25
 */
@Component
public class SchedulerTask {

    private AtomicInteger count = new AtomicInteger(0);

    /**
     * @Scheduled 参数支持两种方式
     * 1. cron表达式
     * 2.1 @Scheduled(fixedRate = 6000): 上一次开始执行时间点之后6秒再执行
     * 2.2 @Scheduled(fixedDelay = 6000): 上一次执行完毕时间点之后6秒再执行
     * 2.3 @Scheduled(initialDelay=1000, fixedRate=6000): 第一次延迟1秒后执行, 之后按 fixedRate 的规则每6秒执行一次
     */
    // @Scheduled(cron = "*/5 * * * * ?")// cron表达式
    @Scheduled(fixedRate = 5000)
    public void count() {
        System.out.println("time-->" + new Date() + ", count-->" + count.incrementAndGet());
    }
}
