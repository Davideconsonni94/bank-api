package com.dconsonni.exercise.bankapi.service;

import com.dconsonni.exercise.bankapi.client.BankClient;
import com.dconsonni.exercise.bankapi.models.Balance;
import com.dconsonni.exercise.bankapi.models.BankTransfertInfo;
import com.dconsonni.exercise.bankapi.models.MoneyTransfertResponse;
import com.dconsonni.exercise.bankapi.models.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankOperationService {

    @Autowired
    BankClient bankClient;

    public Balance getBalance(Long accountId) throws Exception {
        return bankClient.getAccountBalance(accountId);
    }

    public List<Transaction> getTransactions(Long accountId, String from, String to) throws Exception {
        return bankClient.getTransactions(accountId, from, to);
    }

    public MoneyTransfertResponse executeBankTransfer(BankTransfertInfo bankTransfertInfo) throws Exception {
        return bankClient.executeMoneyTransfer(bankTransfertInfo);
    }
}
