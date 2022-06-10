package com.nttdata.app.transactionmodels;

import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
public class Transaction implements Serializable {
   private String id;
   private String transactionType;
   private String paymode;
   private String token;
   private int mount;
   private String celular;
   private String numberAccount;

}
