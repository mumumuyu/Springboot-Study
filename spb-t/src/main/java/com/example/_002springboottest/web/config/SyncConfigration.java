package com.example._002springboottest.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class SyncConfigration {
    //配置线程池
    @Bean(name = "scorePoolTaskExecutor")
    public ThreadPoolTaskExecutor getScorePoolTaskExecutor(){
        ThreadPoolTaskExecutor taskExcutor = new ThreadPoolTaskExecutor();
        taskExcutor.setCorePoolSize(10);//核心线程数
        taskExcutor.setMaxPoolSize(100);//最大线程数,缓存满了才会申请
        taskExcutor.setQueueCapacity(50);//缓存队列
        taskExcutor.setKeepAliveSeconds(200);//最大允许空闲时间
        taskExcutor.setThreadNamePrefix("异步线程--");
        taskExcutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExcutor.initialize();
        return taskExcutor;
    }
    @Bean(name = "scorePoolTaskExecutor2")
    public ThreadPoolTaskExecutor getScorePoolTaskExecutor2(){
        ThreadPoolTaskExecutor taskExcutor2 = new ThreadPoolTaskExecutor();
        taskExcutor2.setCorePoolSize(10);//核心线程数
        taskExcutor2.setMaxPoolSize(100);//最大线程数,缓存满了才会申请
        taskExcutor2.setQueueCapacity(50);//缓存队列
        taskExcutor2.setKeepAliveSeconds(200);//最大允许空闲时间
        taskExcutor2.setThreadNamePrefix("异步线程2--");
        taskExcutor2.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExcutor2.initialize();
        return taskExcutor2;
    }
}
