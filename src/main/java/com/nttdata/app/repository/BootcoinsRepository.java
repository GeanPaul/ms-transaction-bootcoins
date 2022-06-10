package com.nttdata.app.repository;

import com.nttdata.app.redis.models.BootcoinsRateCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcoinsRepository extends CrudRepository<BootcoinsRateCache,String> {
}
