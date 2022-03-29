package com.vietgenstein.vietnamesenlp.abstractions;

import vn.pipeline.Sentence;

import java.io.IOException;
import java.util.List;

public interface AnnotateActionHandler {

    public List<Sentence> Handle(String text) throws IOException;
}