package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Builder
public class UserPhonesResponsesDTO {

    private String NUMBER;
    @NotNull(message = "comment cannot be empty")
    private String CITYCODE;
    private String COUNTRYCODE;

}
