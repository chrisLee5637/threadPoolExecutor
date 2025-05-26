package com.example.threadPoolExecutor.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * In summary, the ExecutorUsageLogger class provides a centralized mechanism to monitor and log the performance of multiple thread pool executors in the application.
 * This helps in understanding the resource utilization and identifying potential bottlenecks in asynchronous task execution.
 */
@Slf4j
@Component
public class ExecutorUsageLogger {

    @Autowired
    private ThreadPoolTaskExecutor pricerRequestExecutor;

    @Autowired
    private ThreadPoolTaskExecutor pullPricerRequestExecutor;

    @Autowired
    private ThreadPoolTaskExecutor commonEmailSendingExecutor;

    @Autowired
    private ThreadPoolTaskExecutor uiRefreshNotificationExecutor;

    @Autowired
    private ThreadPoolTaskExecutor systemDefaultExecutor;

    @Scheduled(fixedRate = 10 * 1000)
    public void logExecutorUsage() {
        log.info("Executor Usage Metrics: {}", getAllExecutorMetrics());
    }

    public Map<String, Map<String, Integer>> getAllExecutorMetrics(){
        return Map.of(
                "pricerRequestExecutor", getExecutorMetrics(pricerRequestExecutor),
                "pullPricerRequestExecutor", getExecutorMetrics(pullPricerRequestExecutor),
                "commonEmailSendingExecutor", getExecutorMetrics(commonEmailSendingExecutor),
                "uiRefreshNotificationExecutor", getExecutorMetrics(uiRefreshNotificationExecutor),
                "systemDefaultExecutor", getExecutorMetrics(systemDefaultExecutor)
        );
    }

    private Map<String, Integer> getExecutorMetrics(ThreadPoolTaskExecutor executor) {
        return Map.of(
                "activeCount", executor.getActiveCount(),
                "poolSize", executor.getPoolSize(),
                "queueSize", executor.getThreadPoolExecutor().getQueue().size(),
                "coreSize", executor.getThreadPoolExecutor().getCorePoolSize(),
                "maxSize", executor.getThreadPoolExecutor().getMaximumPoolSize()
        );
    }

}
