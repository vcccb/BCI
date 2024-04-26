package com.example.demo.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="TESTBCIPHONES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPhones {

    @Id
    @GeneratedValue()
    private int ID;
    private UUID IDUSER;
    @Column(nullable = false)
    private String NUMBER;
    @Column(nullable = false)
    private String CITYCODE;
    @Column(nullable = false)
    private String COUNTRYCODE;

}
