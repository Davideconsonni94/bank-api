package com.dconsonni.exercise.bankapi.controller;

import com.dconsonni.exercise.bankapi.models.Balance;
import com.dconsonni.exercise.bankapi.models.BankTransfertInfo;
import com.dconsonni.exercise.bankapi.models.MoneyTransfertResponse;
import com.dconsonni.exercise.bankapi.models.Transaction;
import com.dconsonni.exercise.bankapi.service.BankOperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bank")
public class BankApiController {

    @Autowired
    BankOperationService bankOperationService;

    Logger log = LoggerFactory.getLogger(BankApiController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/balance/{accountId}")
    ResponseEntity<Balance> getBalance(@PathVariable("accountId") Long accountId) {
        log.debug("Start getBalance operation");
        Balance result = null;
        try {
            result = bankOperationService.getBalance(accountId);
        } catch (Exception e) {
            log.error("Error during getBalance operation, cause: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        log.debug("End getBalance operation");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/transactions/{accountId}")
    ResponseEntity<List<Transaction>>  getTransactions(@PathVariable("accountId") Long accountId, @RequestParam("from") String from, @RequestParam("to") String to) {
        log.debug("Start getTransactions operation");
        List<Transaction> result= null;
        try{
            result = bankOperationService.getTransactions(accountId, from, to);
        } catch (Exception e) {
            log.error("Error during getTransactions operation, cause: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        log.debug("End getTransactions operation");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/bank-transfer")
    ResponseEntity<MoneyTransfertResponse> executeBankTransfer(@RequestBody BankTransfertInfo bankTransfertInfo) {
        log.debug("Start executeBankTransfer operation");
        MoneyTransfertResponse result= null;
        try {
            result = bankOperationService.executeBankTransfer(bankTransfertInfo);
        } catch (Exception e){
            log.error("Error during executeBankTransfer operation, cause: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        log.debug("End executeBankTransfer operation");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
