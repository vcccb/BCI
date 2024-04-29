package com.example.demo.controller;


import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponsesDTO;
import com.example.demo.exception.CustomErrorException;
import com.example.demo.services.DemoPhonesService;
import com.example.demo.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.demo.constant.Constants.*;
import static java.util.Calendar.DATE;

@RestController
@RequestMapping("/testBCI")
public class DemoController {

    @Autowired
    DemoService demoService;
    @Autowired
    private DemoPhonesService demoPhonesService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces= {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<UserRequestDTO> createComment(
            @Valid @RequestBody UserRequestDTO userRequestDTO) {

        try{
            System.out.println("userRequestDTO.getEMAIL() :: " + userRequestDTO.getEMAIL());
            if(validaCorreo(userRequestDTO.getEMAIL())) {
                if (!existEmail(userRequestDTO.getEMAIL())) {
                    userRequestDTO.setLASTMODIFIED(new Date());
                    userRequestDTO.setCREATED(new Date());
                    userRequestDTO.setISACTIVE(true);
                    userRequestDTO.setLASTLOGIN(new Date());
                    UUID aux = demoService.saveUser(userRequestDTO);
                    userRequestDTO.setUUIDUSER(aux);
                    for (int i = 0; i < userRequestDTO.getPHONES().size(); i++) {
                        System.out.println("aux :: " +aux );
                        demoPhonesService.savePhone(userRequestDTO.getPHONES().get(i), userRequestDTO,aux);
                    }
                } else {
                    throw new CustomErrorException(HttpStatus.NOT_FOUND, MSG_CORREO, 1);
                }
            }else{
                throw new CustomErrorException(HttpStatus.NOT_FOUND, MSG_CORREO_2, 1);
            }
        }catch(Exception e){
            throw new CustomErrorException(HttpStatus.BAD_REQUEST,e.getMessage(),1);
        }
        return new ResponseEntity<>(userRequestDTO, HttpStatus.CREATED);
    }

    private boolean validaCorreo(String email) {

        Pattern pattern = Pattern.compile(EXP_REGULAR);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean existEmail(String email) {
        boolean exit = false;
        List<UserRequestDTO> userRequestDTO = demoService.getAllUser();

        for(int x=0;x<userRequestDTO.size();x++){
            System.out.println("userRequestDTO.get(x).getEMAIL() :: " + userRequestDTO.get(x).getEMAIL() );
            System.out.println("Email :: " + email );
            if(userRequestDTO.get(x).getEMAIL().matches(email)){
                exit=true;
                break;
            }
        }

        return exit;
   }

//    private String getValue(String key) {
//
//        Properties appProps = new Properties();
//        String value = null;
//        try{
//            appProps.load(new FileInputStream("application.properties"));
//            value = appProps.getProperty(key);
//        }catch(IOException e){
//            throw new CustomErrorException(
//                    HttpStatus.NOT_FOUND,
//                    e.getMessage(),
//                    1
//            );
//        }
//        return value;
//    }

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
