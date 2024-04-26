package com.example.demo.repository;

import com.example.demo.domain.UserRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DemoPhoneRepository extends CrudRepository<UserRequest, UUID> {}

