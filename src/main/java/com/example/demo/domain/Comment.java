package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;



import java.util.Date;
import java.util.UUID;
@Entity
@Table(name="comment")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue()
    private UUID id;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private String description;
    private Date createdDate;
    @Column(nullable = false)
    private String createdBy;
    private Date updatedDate;
}