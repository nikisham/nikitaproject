package com.nikisham2.nikisham.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class TelegramDTO {
    @NotNull
    private Integer chatId;
    @NotBlank
    private Boolean active;
    private String tool;
    private String price;
    private String lot;
    private String volume;

}
