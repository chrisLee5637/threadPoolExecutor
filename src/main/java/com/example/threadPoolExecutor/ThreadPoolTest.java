package com.example.threadPoolExecutor;

import org.springframework.scheduling.annotation.Async;
import po.PriceReqDTO;

import static com.example.threadPoolExecutor.threadpool.ThreadPoolAsyncConfig.PRICER_REQUEST_EXECUTOR;

public class ThreadPoolTest {

    @Async(PRICER_REQUEST_EXECUTOR)
    public void processPriceRequest(PriceReqDTO priceReqDTO){

    }
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
