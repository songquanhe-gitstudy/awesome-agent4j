package com.awesome.agent4j.agent;

import com.awesome.agent4j.model.Sentiment;
import dev.langchain4j.service.UserMessage;

public interface SentimentAnalyzer {
    @UserMessage("分析以下文本的情感是正面(POSITIVE)、负面(NEGATIVE)还是中性(NEUTRAL)。请仅返回这三个枚举值之一，不要输出其他任何内容。\n文本: {{it}}")
    Sentiment analyzeSentimentOf(String text);
}
