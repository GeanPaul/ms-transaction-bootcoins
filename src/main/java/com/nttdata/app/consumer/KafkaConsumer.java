package com.nttdata.app.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nttdata.app.config.Util;
import com.nttdata.app.service.impl.TransactionService;
import com.nttdata.app.transactionmodels.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @Autowired
    private TransactionService transactionService;

    @KafkaListener(topics = "${kafka.subscribed-topic.name}")
    public void consumerEvent(String message) throws JsonProcessingException, InterruptedException {
        //Transformamos el String mensaje que recibimos a objeto
    Transaction transaction= Util.objectMapper.readValue(message,Transaction.class);
    log.info("Message recevid " + message);
    log.info(transactionService.processTransaction(transaction));



    }
}
