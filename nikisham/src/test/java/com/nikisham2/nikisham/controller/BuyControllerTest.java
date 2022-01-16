package com.nikisham2.nikisham.controller;

import com.nikisham2.nikisham.BaseTest;
import com.nikisham2.nikisham.dto.BuyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BuyControllerTest extends BaseTest {
    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/buy/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getOne() throws Exception {
        mockMvc.perform(get("/buy/one?id=" + buyId_1))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(get("/buy/one?id=" + UUID.randomUUID()))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void create() throws Exception {
        BuyDTO dto = new BuyDTO();
        dto.setId(UUID.randomUUID());
        dto.setName("Test");
        dto.setPrice("888");
        dto.setDate("11/13/2021");
        dto.setNumber(777);
        dto.setLot("666");
        dto.setVolume("555");
        MvcResult result = mockMvc.perform(post("/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();

        BuyDTO actual = mapper.readValue(result.getResponse().getContentAsString(), BuyDTO.class);
        assertEquals(actual.getName(), "Test");

        mockMvc.perform(post("/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(actual)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void update() throws Exception {
        BuyDTO dto = new BuyDTO();
        dto.setId(buyId_1);
        dto.setName("Test 2");
        dto.setPrice("111");
        dto.setDate("11/13/2021");
        dto.setNumber(222);
        dto.setLot("333");
        dto.setVolume("444");
        MvcResult result = mockMvc.perform(put("/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();

        BuyDTO actual = mapper.readValue(result.getResponse().getContentAsString(), BuyDTO.class);
        assertEquals(actual.getId(), buyId_1);
        assertEquals(actual.getName(), "Test 2");

        dto.setId(UUID.randomUUID());
        mockMvc.perform(put("/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isBadRequest()).andReturn();
    }

    @Test
    void _delete() throws Exception {
        mockMvc.perform(delete("/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(List.of(buyId_1, buyId_2))))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
