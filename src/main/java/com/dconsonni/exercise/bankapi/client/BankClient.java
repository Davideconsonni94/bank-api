package com.dconsonni.exercise.bankapi.client;


import com.dconsonni.exercise.bankapi.models.Balance;
import com.dconsonni.exercise.bankapi.models.BankTransfertInfo;
import com.dconsonni.exercise.bankapi.models.MoneyTransfertResponse;
import com.dconsonni.exercise.bankapi.models.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BankClient {

    @Value("${bank-client.timezone-header}")
    String timezone;

    @Value("${bank-client.host}")
    String bankHost;

    @Value("${bank-client.api-key}")
    String bankApiKey;

    final String ACCOUNTS_API = "/api/gbs/banking/v4.0/accounts/{accountId}";
    final String TRANSACTIONS_API = "/api/gbs/banking/v4.0/accounts/{accountId}/transactions?fromAccountingDate={fromAccountingDate}&toAccountingDate={toAccountingDate}";
    final String MONEY_TRANSFER_API = "/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers";

    Logger log = LoggerFactory.getLogger(BankClient.class);

    public Balance getAccountBalance(final Long accountId) throws Exception {
        final String url = bankHost + ACCOUNTS_API;
        final HttpHeaders headers = getHttpHeaders();
        final HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        Map<String, String> params = new HashMap<>();
        params.put("accountId", accountId.toString());

        RestTemplate restTemplate = new RestTemplate();
        Balance result = null;
        log.info("Calling {}", url);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, params);
        if (response.getStatusCode() != HttpStatus.OK) {
            log.error("Error calling {}, http status code: {}", url, response.getStatusCode());
            throw new Exception("Error calling bank api, http status code: " + response.getStatusCode());
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(response.getBody(), Balance.class);
        } catch (Exception e) {
            log.error("Error parsing response object {}", response.getBody().toString());
            throw new Exception("Error parsing response object from " + url);
        }
        return result;
    }

    public List<Transaction> getTransactions(final Long accountId, final String from, final String to) throws Exception {
        final String url = bankHost + TRANSACTIONS_API;
        final HttpHeaders headers = getHttpHeaders();
        final HttpEntity<Object> entity=new HttpEntity<Object>(headers);
        Map<String, String> params = new HashMap<>();
        params.put("accountId", accountId.toString());
        params.put("fromAccountingDate", from);
        params.put("toAccountingDate", to);

        RestTemplate restTemplate = new RestTemplate();
        List<Transaction> result = null;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, params);
        if(response.getStatusCode()!= HttpStatus.OK){
            log.error("Error calling {}, http status code: {}", url, response.getStatusCode());
            throw new Exception("Error calling bank api, http status code: " + response.getStatusCode());
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(response.getBody(), new TypeReference<List<Transaction>>(){});
        } catch (Exception e) {
            log.error("Error parsing response object {}", response.getBody().toString());
            throw new Exception("Error parsing response object from " + url);
        }

        return result;
    }

    public MoneyTransfertResponse executeMoneyTransfer(final BankTransfertInfo bankTransfertInfo) throws Exception {
        final String url = bankHost + MONEY_TRANSFER_API;
        final HttpHeaders headers = getHttpHeaders();
        final  HttpEntity<BankTransfertInfo> httpEntity = new HttpEntity<>(bankTransfertInfo, headers);
        Map<String, String> params = new HashMap<>();
        params.put("accountId", bankTransfertInfo.getAccountId().toString());

        RestTemplate restTemplate = new RestTemplate();
        MoneyTransfertResponse result = null;

        ResponseEntity<String> response = restTemplate.postForEntity(url, httpEntity, String.class);
        if(response.getStatusCode()!= HttpStatus.OK){
            log.error("Error calling {}, http status code: {}", url, response.getStatusCode());
            throw new Exception("Error calling bank api, http status code: " + response.getStatusCode());
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(response.getBody(), MoneyTransfertResponse.class);
        } catch (Exception e) {
            log.error("Error parsing response object {}", response.getBody().toString());
            throw new Exception("Error parsing response object from " + url);
        }

        return result;
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Api-Key", bankApiKey);
        headers.add("X-Time-Zone", timezone);
        return headers;
    }
}
