package com.nikisham2.nikisham.service;

import com.nikisham2.nikisham.BaseTest;
import com.nikisham2.nikisham.dto.BuyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BuyServiceTest extends BaseTest {


    @Test
    void create() throws Exception {
        var dto = new BuyDTO();
        dto.setId(UUID.randomUUID());
        dto.setName("Test1");
        dto.setPrice("121");
        dto.setDate("11/13/2021");
        dto.setNumber(111);
        dto.setLot("666");
        dto.setVolume("555");
        var result = mockMvc.perform(post("/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();

        var actual = mapper.readValue(result.getResponse().getContentAsString(), BuyDTO.class);

        assertEquals(actual.getName(),"Test1");


        dto.setName(null);
        mockMvc.perform(post("/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());

    }
    @Test
    void update() throws Exception {
        var dto = new BuyDTO();
        dto.setId(buyId_1);
        dto.setName("Test 2");
        dto.setPrice("111");
        dto.setDate("11/13/2021");
        dto.setNumber(null);
        dto.setLot("333");
        dto.setVolume("444");
        var result = mockMvc.perform(put("/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
        var actual = mapper.readValue(result.getResponse().getContentAsString(), BuyDTO.class);
        assertEquals(actual.getName(), "Test 2");


        mockMvc.perform(put("/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isBadRequest()).andReturn();
    }
}
