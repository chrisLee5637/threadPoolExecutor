package com.example.threadPoolExecutor.threadpool;

import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;

import java.util.Map;

/**
 * A TaskDecorator that copies the MDC context from the current thread to the new thread.
 * This is useful for preserving logging context across asynchronous tasks.
 */
public class MdcTaskDecorator  implements TaskDecorator {

    /**
     * Decorates a Runnable by copying the MDC context from the current thread.
     * This ensures that the logging context is preserved in the new thread.
     *
     * @param runnable the Runnable to be decorated
     * @return a new Runnable that sets the MDC context before running
     */
    @Override
    public Runnable decorate(Runnable runnable) {
        Map<String, String> contextMap = MDC.getCopyOfContextMap();
        return () -> {
            if (contextMap != null) {
                MDC.setContextMap(contextMap);
            }
            try {
                runnable.run();
            } finally {
                MDC.clear();
            }
        };
    }
}
