package com.nikisham2.nikisham;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nikisham2.nikisham.entity.Buy;
import com.nikisham2.nikisham.repository.BuyRepository;
import com.nikisham2.nikisham.service.BuyService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.fail;

@DirtiesContext
@SpringBootTest
public abstract class BaseTest extends BaseContainer {
    protected final ObjectMapper mapper = new ObjectMapper();
    protected Integer buyId_1;
    protected Integer buyId_2;
    protected MockMvc mockMvc;
    @Autowired
    private BuyRepository repository;
    @Autowired
    protected WebApplicationContext context;

    @BeforeEach
    void setUp() {
        try (var is = BuyService.class.getClassLoader().getResourceAsStream("data/buy.json")) {
            List<Buy> list = mapper.readValue(is, new TypeReference<>() {});
            repository.saveAll(list);
        } catch (Exception e) {
            fail(e.getMessage());
        }

        buyId_1 = repository.findAll().stream().findFirst().orElseThrow().getId();
        buyId_2 = repository.findAll().stream().filter(buy -> buy.getId().equals(5)).findFirst().orElseThrow().getId();

        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilter((request, response, chain) -> {
                    response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
                    chain.doFilter(request, response);
                })
                .build();
    }
}
