package com.nttdata.app.service.impl;

import com.nttdata.app.redis.models.BootcoinsRateCache;
import com.nttdata.app.repository.BootcoinsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BootcoinsRateServiceImpl implements BootcoinsRateCacheService{

    private final BootcoinsRepository bootcoinsRepository;

    @Override
    public List<BootcoinsRateCache> getAll() {

        try {
        List<BootcoinsRateCache> bootcoinsRateCacheList=new ArrayList<>();
        bootcoinsRepository.findAll().forEach(bootcoinsRateCacheList::add);
        return bootcoinsRateCacheList;
        }
        catch (Exception e) {
            log.error("Error while tyrying to bootcoinsRate from Redis cache" + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public String storageBootcoinsRateList(List<BootcoinsRateCache> bootcoinsRateCachesList) {
        try {
            Iterable<BootcoinsRateCache> bootcoinsRateCacheIterable = bootcoinsRateCachesList;
             bootcoinsRepository.saveAll(bootcoinsRateCacheIterable);
             return "BootcoinsRate list create successfyllu";
        }catch (Exception e)
        {
        return "Error saving BootcoinsRate cache List " + e.getMessage();
        }
    }
}
