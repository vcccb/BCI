package com.example.demo.repository;

import com.example.demo.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface CommentRepository extends CrudRepository<Comment, UUID> {
}