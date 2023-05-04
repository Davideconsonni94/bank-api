package com.dconsonni.exercise.bankapi.client;


import com.dconsonni.exercise.bankapi.controller.BankApiController;
import com.dconsonni.exercise.bankapi.service.BankOperationService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BankClientTest {

    @InjectMocks
    BankApiController bankApiController;

    @Mock
    BankOperationService bankOperationService;


    void getBalanceTest(){

    }

    void getBalanceFailed(){

    }

    void getBalanceBadRequest(){

    }
}
