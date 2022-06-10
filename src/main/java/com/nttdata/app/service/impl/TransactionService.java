package com.nttdata.app.service.impl;

import com.nttdata.app.transactionmodels.Transaction;

public interface TransactionService {
    String processTransaction(Transaction transaction) throws InterruptedException;
}
