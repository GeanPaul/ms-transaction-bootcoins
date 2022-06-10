package com.nttdata.app.service.impl;

import com.nttdata.app.api.client.BootcoinsRateApiClient;
import com.nttdata.app.config.Util;
import com.nttdata.app.redis.models.BootcoinsRateCache;
import com.nttdata.app.transactionmodels.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionServiceImpl  implements TransactionService{

    private final BootcoinsRateCacheService bootcoinsRateCacheService;
    private final BootcoinsRateApiClient bootcoinsRateApiClient;

    @Override
    public String processTransaction(Transaction transaction) throws InterruptedException {
        //Validamos la transaccion con el numero de transaccion y el tipo de transaccion
        if (transaction.getTransactionType().equals(Util.BUY) && transaction.getId().equals("6b38c350-a67c-4aca-81ac-63a5ae084ede"))
        {
            if (bootcoinsRateCacheService.getAll().isEmpty())
            {
                bootcoinsRateCacheService.storageBootcoinsRateList(
                        bootcoinsRateApiClient.getActiveBootcoinsRateList()
                                .stream()
                                .map(BootcoinsRateCache::fromBoorcoinsRateResponse)
                                .collect(Collectors.toList())
            );

            }
            log.info("From Redis Cache " + bootcoinsRateCacheService.getAll().toString());
            return  "Processing Buy...";


        }
        else {
            return "Processing..." + transaction.getTransactionType();
        }

    }

}
