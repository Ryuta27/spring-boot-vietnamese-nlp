package com.vietgenstein.vietnamesenlp.handlers;

import org.springframework.stereotype.Service;
import vn.pipeline.Annotation;
import vn.pipeline.Sentence;
import vn.pipeline.VnCoreNLP;

import java.io.IOException;
import java.util.List;

@Service
public class AnnotateHandler {

    public List<Sentence> handle(String text) throws IOException {
        // "wseg", "pos", "ner", and "parse" refer to as word segmentation, POS tagging, NER and dependency parsing, respectively.
        String[] annotators = {"wseg", "pos"};
        VnCoreNLP pipeline = new VnCoreNLP(annotators);



        Annotation annotation = new Annotation(text);
        pipeline.annotate(annotation);
        // You can also get a single sentence to analyze individually
        String firstSentence = annotation.getSentences().get(0).getRawSentence();

        return annotation.getSentences();
    }

}