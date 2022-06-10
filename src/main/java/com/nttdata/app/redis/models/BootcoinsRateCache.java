package com.nttdata.app.redis.models;


import com.nttdata.app.api.response.BootcoinsRateResponse;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;

@RedisHash("bootcoins")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BootcoinsRateCache implements Serializable {
    private String id;
    private String typeOprations;
    private int minimumCoins;
    private int maximumCoins;
    private BigDecimal cost;

    public static BootcoinsRateCache fromBoorcoinsRateResponse(BootcoinsRateResponse bootcoinsRateResponse){

        return BootcoinsRateCache.builder()
                .id(bootcoinsRateResponse.getId())
                .typeOprations(bootcoinsRateResponse.getTypeOprations())
                .minimumCoins(bootcoinsRateResponse.getMinimumCoins())
                .maximumCoins(bootcoinsRateResponse.getMaximumCoins())
                .cost(bootcoinsRateResponse.getCost())
                .build();
    }

}
