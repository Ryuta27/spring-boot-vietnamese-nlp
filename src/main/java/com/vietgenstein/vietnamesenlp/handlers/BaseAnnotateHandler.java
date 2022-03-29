package com.vietgenstein.vietnamesenlp.handlers;

import com.vietgenstein.vietnamesenlp.abstractions.AnnotateActionHandler;
import vn.pipeline.Annotation;
import vn.pipeline.Sentence;
import vn.pipeline.VnCoreNLP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseAnnotateHandler implements AnnotateActionHandler {

    private final VnCoreNLP pipeline;

    public BaseAnnotateHandler(String annotatorCode) throws IOException {
        String[] annotators = { annotatorCode };
        pipeline = new VnCoreNLP(annotators);
    }

    @Override
    public List<Sentence> Handle(String text) {
        Annotation annotation = new Annotation(text);
        try {
            pipeline.annotate(annotation);
            return annotation.getSentences();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // if we got here, we return an empty list
        return new ArrayList<Sentence>();
    }

}