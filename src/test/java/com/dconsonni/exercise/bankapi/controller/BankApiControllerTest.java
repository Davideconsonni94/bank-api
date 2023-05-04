package com.dconsonni.exercise.bankapi.controller;

import com.dconsonni.exercise.bankapi.models.Balance;
import com.dconsonni.exercise.bankapi.service.BankOperationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BankApiControllerTest {

    private MockMvc mvc;

    @Mock
    BankOperationService bankOperationService;

    @InjectMocks
    BankApiController bankApiController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mvc = MockMvcBuilders.standaloneSetup(bankApiController).build();
    }

    @Test
    public void testGetBalance() throws Exception {
        Long accountId = 1l;
        Balance balance = new Balance();
        balance.setAccountId(accountId.toString());
        when(bankOperationService.getBalance(accountId)).thenReturn(balance);
        mvc.perform(MockMvcRequestBuilders
                        .get("/balance/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetBalanceFailed() throws Exception {
        Long accountId = 1l;
        Balance balance = new Balance();
        balance.setAccountId(accountId.toString());
        when(bankOperationService.getBalance(accountId)).thenThrow(new Exception());
        mvc.perform(MockMvcRequestBuilders
                        .get("/balance/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
    @Test
    public void testGetBalanceBadRequest() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/balance/test")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
