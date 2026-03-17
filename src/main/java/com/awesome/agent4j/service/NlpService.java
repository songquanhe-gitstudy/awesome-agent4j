package com.awesome.agent4j.service;

import com.awesome.agent4j.model.Person;
import com.awesome.agent4j.model.Sentiment;

public interface NlpService {
    Person extractPersonInfo(String text);
    
    Sentiment analyzeSentiment(String text);

    String translateText(String text, String targetLanguage);

    String summarizeText(String text);
}
