package com.example.demo.services;

import com.example.demo.domain.UserRequest;
import com.example.demo.dto.UserRequestDTO;

import com.example.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DemoService {

    @Autowired
    DemoRepository demoRepository;
    public void saveUser(UserRequestDTO userRequestDTO) {
        UserRequest userRequest = UserRequest
                .builder()
                .NAME(userRequestDTO.getNAME())
                .EMAIL(userRequestDTO.getEMAIL())
                .ISACTIVE(true)
                .CREATED(new Date())
                .LASTLOGIN(new Date())
                .LASTMODIFIED(new Date())
                .PASSWORD(userRequestDTO.getPASSWORD())
                .build();
        demoRepository.save(userRequest);
    }

    public List<UserRequestDTO> getAllUser(){
        Iterable<UserRequest> userRequests = demoRepository.findAll();
        List<UserRequestDTO> userRequestDTO = new ArrayList<>();

        userRequests.forEach( userRequest -> {
            userRequestDTO.add(UserRequestDTO
                    .builder()
                    .NAME(userRequest.getNAME())
                    .EMAIL(userRequest.getEMAIL())
                    .PASSWORD(userRequest.getPASSWORD())
                    .CREATED(userRequest.getCREATED())
                    .UUIDUSER(userRequest.getUUIDUSER())
                    .LASTMODIFIED(userRequest.getLASTMODIFIED())
                    .ISACTIVE(userRequest.getISACTIVE())
                    .LASTLOGIN(userRequest.getLASTLOGIN())
                    .build());
        });
        return userRequestDTO;
    }

}
