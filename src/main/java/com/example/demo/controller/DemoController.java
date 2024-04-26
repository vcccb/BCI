package com.example.demo.controller;


import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/testBCI")
public class DemoController {

    @Autowired
    DemoService demoService;
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces= {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<UserRequestDTO> createComment(
            @Valid @RequestBody UserRequestDTO userRequestDTO)
            throws Exception {

        userRequestDTO.setLASTMODIFIED(new Date());
        userRequestDTO.setEMAIL("vidisha.pal@myemail.com");

        demoService.saveUser(userRequestDTO);
        return new ResponseEntity<>(userRequestDTO, HttpStatus.CREATED);
    }
    @GetMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces= {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<List<UserRequestDTO>> getUser()
            throws Exception {

        List<UserRequestDTO> userRequestDTO = demoService.getAllUser();
        return new ResponseEntity<>(userRequestDTO, HttpStatus.CREATED);
    }


}
