package com.vietgenstein.vietnamesenlp.handlers;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WsegAnnotateHandler extends BaseAnnotateHandler {

    public WsegAnnotateHandler() throws IOException {
        super("wseg");
    }

}