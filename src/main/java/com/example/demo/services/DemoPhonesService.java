package com.example.demo.services;

import com.example.demo.domain.UserPhones;
import com.example.demo.dto.UserPhonesDTO;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.repository.DemoPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DemoPhonesService {


    @Autowired
    DemoPhoneRepository demoPhoneRepository;
    public void savePhone(UserPhonesDTO userPhonesDTO, UserRequestDTO userRequestDTO, UUID aux) {
        UserPhones userPhones = UserPhones
                .builder()
                .ID(userPhonesDTO.getID())
                .IDUSER(userPhonesDTO.getUUIDUSER())
                .COUNTRYCODE(userPhonesDTO.getCOUNTRYCODE())
                .CITYCODE(userPhonesDTO.getCITYCODE())
                .NUMBER(userPhonesDTO.getNUMBER())
                .build();
        demoPhoneRepository.save(userPhones);
    }

//    public List<UserPhonesDTO> getAllPhone(){
//        Iterable<UserPhones> userPhones = demoPhoneRepository.findAll();
//        List<UserPhonesDTO> userPhonesDTO = new ArrayList<>();
//
//        userPhones.forEach( userPhones -> {
//            userPhonesDTO.add(UserPhonesDTO
//                    .builder()
//                    .ID(userPhones.getID())
//                    .NUMBER(userPhones.getNUMBER())
//                    .COUNTRYCODE(userPhones.getCOUNTRYCODE())
//                    .CITYCODE(userPhones.getCITYCODE())
//                    .build());
//        });
//        return userPhonesDTO;
//    }


}
