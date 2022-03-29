package com.vietgenstein.vietnamesenlp.handlers;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PosAnnotateHandler extends BaseAnnotateHandler {

    public PosAnnotateHandler() throws IOException {
        super("pos");
    }
    
}
