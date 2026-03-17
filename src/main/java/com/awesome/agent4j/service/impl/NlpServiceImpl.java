package com.awesome.agent4j.service.impl;

import com.awesome.agent4j.agent.PersonExtractor;
import com.awesome.agent4j.agent.SentimentAnalyzer;
import com.awesome.agent4j.agent.TextSummarizer;
import com.awesome.agent4j.agent.Translator;
import com.awesome.agent4j.model.Person;
import com.awesome.agent4j.model.Sentiment;
import com.awesome.agent4j.service.NlpService;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.springframework.stereotype.Service;

@Service
public class NlpServiceImpl implements NlpService {

    private final PersonExtractor personExtractor;
    private final SentimentAnalyzer sentimentAnalyzer;
    private final Translator translator;
    private final TextSummarizer textSummarizer;

    public NlpServiceImpl(ChatLanguageModel chatLanguageModel) {
        // 创建提取结构化数据的 AI 服务
        this.personExtractor = AiServices.create(PersonExtractor.class, chatLanguageModel);
        
        // 创建用于情感分析的 AI 服务
        this.sentimentAnalyzer = AiServices.create(SentimentAnalyzer.class, chatLanguageModel);

        // 创建翻译 AI 服务
        this.translator = AiServices.create(Translator.class, chatLanguageModel);

        // 创建文本总结 AI 服务
        this.textSummarizer = AiServices.create(TextSummarizer.class, chatLanguageModel);
    }

    @Override
    public Person extractPersonInfo(String text) {
        return personExtractor.extractPersonFrom(text);
    }

    @Override
    public Sentiment analyzeSentiment(String text) {
        return sentimentAnalyzer.analyzeSentimentOf(text);
    }

    @Override
    public String translateText(String text, String targetLanguage) {
        return translator.translate(text, targetLanguage);
    }

    @Override
    public String summarizeText(String text) {
        return textSummarizer.summarize(text);
    }
}
