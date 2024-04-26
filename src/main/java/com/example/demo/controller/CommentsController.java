package com.example.demo.controller;


import com.example.demo.dto.CommentDTO;
import com.example.demo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    CommentService commentService;
    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE ,
                    MediaType.APPLICATION_XML_VALUE},
            produces= {
                    MediaType.APPLICATION_JSON_VALUE ,
                    MediaType.APPLICATION_XML_VALUE
            })
    public ResponseEntity<CommentDTO> createComment(
            @Valid @RequestBody CommentDTO commentDTO)
            throws Exception {

        commentDTO.setCreatedDate(new Date());
        commentDTO.setCreatedBy("vidisha.pal@myemail.com");

        commentService.saveComment(commentDTO);
        return new ResponseEntity<>(commentDTO, HttpStatus.CREATED);
    }
    @GetMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE ,
                    MediaType.APPLICATION_XML_VALUE},
            produces= {
                    MediaType.APPLICATION_JSON_VALUE ,
                    MediaType.APPLICATION_XML_VALUE
            })
    public ResponseEntity<List<CommentDTO>> getComments()
            throws Exception {

        List<CommentDTO> commentsDTO = commentService.getAllComments();
        return new ResponseEntity<>(commentsDTO, HttpStatus.CREATED);
    }
}