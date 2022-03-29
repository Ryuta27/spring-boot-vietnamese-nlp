package com.vietgenstein.vietnamesenlp.controllers;

import com.vietgenstein.vietnamesenlp.handlers.AnnotateHandler;
import com.vietgenstein.vietnamesenlp.models.AnnotateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.pipeline.Sentence;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/test")
public class AnnotateController {

    private final AnnotateHandler annotateHandler;


    @Autowired
    public AnnotateController(AnnotateHandler annotateHandler) {
        this.annotateHandler = annotateHandler;

    }

    @PostMapping("/annotate")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Sentence> annotate(@RequestBody AnnotateRequest request) throws IOException {
        return annotateHandler.handle(request.getText());
    }



}
