package com.vietgenstein.vietnamesenlp.controllers;

import com.vietgenstein.vietnamesenlp.handlers.AnnotateHandler;
import com.vietgenstein.vietnamesenlp.handlers.PosAnnotateHandler;
import com.vietgenstein.vietnamesenlp.handlers.WsegAnnotateHandler;
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
    private final WsegAnnotateHandler wsegHandler;
    private final PosAnnotateHandler posHandler;


    @Autowired
    public AnnotateController(WsegAnnotateHandler wsegHandler, PosAnnotateHandler posHandler, AnnotateHandler annotateHandler) {
        this.wsegHandler = wsegHandler;
        this.posHandler = posHandler;
        this.annotateHandler = annotateHandler;

    }

    @PostMapping("/annotate")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Sentence> annotate(@RequestBody AnnotateRequest request) throws IOException {
        return annotateHandler.handle(request.getText());
    }

    @GetMapping("/annotate/wseg")
    public List<Sentence> annotateWseg(@RequestBody AnnotateRequest request) {
        return wsegHandler.Handle(request.getText());
    }

    @GetMapping("/annotate/pos")
    public List<Sentence> annotatePos(@RequestBody AnnotateRequest request) {
        return posHandler.Handle(request.getText());
    }



}
