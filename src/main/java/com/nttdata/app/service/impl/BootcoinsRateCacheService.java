package com.nttdata.app.service.impl;

import com.nttdata.app.redis.models.BootcoinsRateCache;

import java.util.List;

public interface BootcoinsRateCacheService {

    List<BootcoinsRateCache> getAll();
    String storageBootcoinsRateList(List<BootcoinsRateCache> bootcoinsRateCachesList);

}
