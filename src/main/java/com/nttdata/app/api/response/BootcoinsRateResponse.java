package com.nttdata.app.api.response;

import lombok.*;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BootcoinsRateResponse {

    private String id;
    private String typeOprations;
    private int minimumCoins;
    private int maximumCoins;
    private BigDecimal cost;
}
