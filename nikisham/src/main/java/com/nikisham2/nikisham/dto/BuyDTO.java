package com.nikisham2.nikisham.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuyDTO {
    @NotNull
    private UUID id;
    @NotBlank
    private String name;
    private String price;
    private String date;
    private Integer number;
    private String lot;
    private String volume;
}
