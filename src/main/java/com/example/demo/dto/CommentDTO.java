package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.NotNull;
@Data
@Builder
public class CommentDTO {
    private UUID id;
    private String userId;
    @NotNull(message = "comment cannot be empty")
    private String description;
    private Date createdDate;
    private Date updatedDate;
    private String createdBy;
}