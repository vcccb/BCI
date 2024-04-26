package com.example.demo.repository;

import com.example.demo.domain.UserRequest;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface DemoRepository extends CrudRepository<UserRequest, UUID> {
}
