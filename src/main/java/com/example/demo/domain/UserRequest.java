package com.example.demo.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;
@Entity
@Table(name="TESTBCIUSER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @Id
    @GeneratedValue()
    private UUID UUIDUSER;
    @Column(nullable = false)
    private String NAME;
    @Column(nullable = false)
    private String EMAIL;
    @Column(nullable = false)
    private String PASSWORD;
    private Boolean ISACTIVE;
    private Date CREATED;
    private Date LASTMODIFIED;
    private Date LASTLOGIN;
}
