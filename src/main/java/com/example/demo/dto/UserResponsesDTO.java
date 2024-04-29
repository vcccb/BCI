package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class UserResponsesDTO {

    private UUID UUIDUSER;
    private String NAME;
    @NotNull(message = "comment cannot be empty")
    private String EMAIL;
    private Date CREATED;
    private Date LASTMODIFIED;
    private Date LASTLOGIN;
    private List<UserPhonesResponsesDTO> PHONES;

}
