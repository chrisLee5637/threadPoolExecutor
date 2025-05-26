package com.example.threadPoolExecutor;

import org.springframework.scheduling.annotation.Async;
import po.PriceReqDTO;

import static com.example.threadPoolExecutor.threadpool.ThreadPoolAsyncConfig.PRICER_REQUEST_EXECUTOR;

public class ThreadPoolTest {

    @Async(PRICER_REQUEST_EXECUTOR)
    public void processPriceRequest(PriceReqDTO priceReqDTO){

    }
    public static final String PULL_PRICER_REQUEST_EXECUTOR = "pullPricerRequestExecutor";

    public static final String COMMON_EMAIL_SENDING_EXECUTOR = "commonEmailSendingExecutor";

    public static final String UI_REFRESH_NOTIFICATION_EXECUTOR = "uiRefreshNotificationExecutor";

    public static final String DEFAULT_DEFAULT_EXECUTOR = "systemDefaultExecutor";
    @Async(PULL_PRICER_REQUEST_EXECUTOR)
    public void pullPricerRequest(PriceReqDTO priceReqDTO){

    }

    @Async(COMMON_EMAIL_SENDING_EXECUTOR)
    public void sendEmail(PriceReqDTO priceReqDTO){

    }

    @Async(COMMON_EMAIL_SENDING_EXECUTOR)
    public void deleteEmail(PriceReqDTO priceReqDTO){

    }

    @Async(UI_REFRESH_NOTIFICATION_EXECUTOR)
    public void refreshUISocket(PriceReqDTO priceReqDTO){

    }

    @Async(DEFAULT_DEFAULT_EXECUTOR)
    public void updateDocStatus(PriceReqDTO priceReqDTO){

    }

    @Async(DEFAULT_DEFAULT_EXECUTOR)
    public void updateOrder(PriceReqDTO priceReqDTO){

    }
}
