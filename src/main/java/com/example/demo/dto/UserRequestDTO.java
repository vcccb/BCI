package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class UserRequestDTO {

    private UUID UUIDUSER;
    private String NAME;
    @NotNull(message = "comment cannot be empty")
    private String EMAIL;
    private String PASSWORD;
    private boolean ISACTIVE;
    private Date CREATED;
    private Date LASTMODIFIED;
    private Date LASTLOGIN;
    private List<UserPhonesDTO> PHONES;

}
