package com.dconsonni.exercise.bankapi.service;

import com.dconsonni.exercise.bankapi.client.BankClient;
import com.dconsonni.exercise.bankapi.models.Balance;
import com.dconsonni.exercise.bankapi.models.BankTransfertInfo;
import com.dconsonni.exercise.bankapi.models.MoneyTransfertResponse;
import com.dconsonni.exercise.bankapi.models.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
@RunWith(MockitoJUnitRunner.class)
public class BankOperationServiceTest {

    @InjectMocks
    BankOperationService bankOperationService;

    @Mock
    BankClient bankClient;

    @Test
    public void getBalanceTest() throws Exception {
        Long accountId = 1000l;
        Balance balance = new Balance();
        balance.setAccountId(accountId.toString());
        when(bankClient.getAccountBalance(accountId)).thenReturn(balance);
        Balance result = bankClient.getAccountBalance(accountId);
        assertEquals(balance.getAccountId(), result.getAccountId());
    }

    @Test
    public void getTransactionsTest() throws Exception {
        Long accountId = 1000l;
        String from = "2023-05-04";
        String to = "2023-05-04";
        List<Transaction> transactions = Arrays.asList(new Transaction());
        when(bankClient.getTransactions(accountId, from, to)).thenReturn(transactions);
        List<Transaction> result = bankClient.getTransactions(accountId, from, to);
        assertEquals(result.size(), transactions.size());
    }

    @Test
    public void executeBankTransferTest() throws Exception {
        BankTransfertInfo bankTransfertInfo = new BankTransfertInfo();
        MoneyTransfertResponse moneyTransfertResponse = new MoneyTransfertResponse();
        moneyTransfertResponse.setStatus("SUCCESS");
        when(bankClient.executeMoneyTransfer(bankTransfertInfo)).thenReturn(moneyTransfertResponse);
        MoneyTransfertResponse result = bankClient.executeMoneyTransfer(bankTransfertInfo);
        assertEquals(result.getStatus(), moneyTransfertResponse.getStatus());
    }
}
