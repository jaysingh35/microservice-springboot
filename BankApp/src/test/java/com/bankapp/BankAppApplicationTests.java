package com.bankapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
class BankAppApplicationTests {
	
	private MockMvc mockMvc;

    @Test
     void testGetAccountInfo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/account/testAccount"))
                .andExpect(MockMvcResultMatchers.status().isOk());
               
    }

}
