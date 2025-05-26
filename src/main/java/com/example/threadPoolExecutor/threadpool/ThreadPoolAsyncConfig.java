package com.example.threadPoolExecutor.threadpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * This pattern is repeated for other executors,
 * such as pullPricerRequestExecutor, commonEmailSendingExecutor, and uiRefreshNotificationExecutor,
 * each with similar configurations but different threadNamePrefix values to distinguish their purposes.
 * In summary, the ThreadPoolAsyncConfig class centralizes the configuration of multiple thread pools for handling asynchronous tasks in a Spring Boot application.
 * It provides flexibility by allowing different thread pools to be used for different types of tasks, improving the application's scalability and responsiveness.
 */
@Configuration
public class ThreadPoolAsyncConfig implements AsyncConfigurer {

    public static final String PRICER_REQUEST_EXECUTOR = "pricerRequestExecutor";

    public static final String PULL_PRICER_REQUEST_EXECUTOR = "pullPricerRequestExecutor";

    public static final String COMMON_EMAIL_SENDING_EXECUTOR = "commonEmailSendingExecutor";

    public static final String UI_REFRESH_NOTIFICATION_EXECUTOR = "uiRefreshNotificationExecutor";

    public static final String DEFAULT_DEFAULT_EXECUTOR = "systemDefaultExecutor";

    @Autowired
    @Lazy
    private ThreadPoolTaskExecutor systemDefaultExecutor;

    @Override
    public ThreadPoolTaskExecutor getAsyncExecutor() {
        return systemDefaultExecutor;
    }

    @Bean(name = PRICER_REQUEST_EXECUTOR)
    public ThreadPoolTaskExecutor priceRequestExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(13);
        executor.setMaxPoolSize(39);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix(PRICER_REQUEST_EXECUTOR);
        executor.initialize();
        return executor;
    }

    @Bean(name = PULL_PRICER_REQUEST_EXECUTOR)
    public ThreadPoolTaskExecutor pullPricerRequestExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(13);
        executor.setMaxPoolSize(39);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix(PULL_PRICER_REQUEST_EXECUTOR);
        executor.initialize();
        return executor;
    }

    @Bean(name = COMMON_EMAIL_SENDING_EXECUTOR)
    public ThreadPoolTaskExecutor commonEmailSendingExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(13);
        executor.setMaxPoolSize(39);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix(COMMON_EMAIL_SENDING_EXECUTOR);
        executor.initialize();
        return executor;
    }

    @Bean(name = UI_REFRESH_NOTIFICATION_EXECUTOR)
    public ThreadPoolTaskExecutor uiRefreshNotificationExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(13);
        executor.setMaxPoolSize(39);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix(UI_REFRESH_NOTIFICATION_EXECUTOR);
        executor.initialize();
        return executor;
    }

    @Bean(name = DEFAULT_DEFAULT_EXECUTOR)
    public ThreadPoolTaskExecutor systemDefaultExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(30);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix(DEFAULT_DEFAULT_EXECUTOR);
        executor.initialize();
        return executor;
    }


}
