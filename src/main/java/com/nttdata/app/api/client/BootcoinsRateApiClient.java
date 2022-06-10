package com.nttdata.app.api.client;

import com.nttdata.app.api.response.BootcoinsRateResponse;
import com.nttdata.app.config.BootcointsRateProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.scheduler.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@AllArgsConstructor
public class BootcoinsRateApiClient {
    private final WebClient webclient;
    private final BootcointsRateProperties bootcointsRateProperties;

    public List<BootcoinsRateResponse> getActiveBootcoinsRateList() throws InterruptedException {
        ExecutorService executor= Executors.newSingleThreadExecutor();
        List<BootcoinsRateResponse> result=new ArrayList<>();
        webclient.get().uri(bootcointsRateProperties.getBaseUrl() + "/rates/active")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(BootcoinsRateResponse.class)
                .publishOn(Schedulers.fromExecutor(executor))
                .subscribe(obj -> result.add(obj));
        executor.awaitTermination(1, TimeUnit.SECONDS);
        log.info("BootcoinsRate List: " + result);
        return result;
    }
}
