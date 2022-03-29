package com.vietgenstein.vietnamesenlp.handlers;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class NerAnnotateHandler extends BaseAnnotateHandler {

    public NerAnnotateHandler() throws IOException {
        super("ner");
    }
    
}
