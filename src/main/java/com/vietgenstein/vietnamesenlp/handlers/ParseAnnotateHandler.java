package com.vietgenstein.vietnamesenlp.handlers;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ParseAnnotateHandler extends BaseAnnotateHandler {

    public ParseAnnotateHandler() throws IOException {
        super("parse");
    }
    
}
