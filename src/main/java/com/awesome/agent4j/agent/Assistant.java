package com.awesome.agent4j.agent;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface Assistant {
    
    @SystemMessage("你是一个有用的计算助手。当用户询问数学计算相关的问题时，你必须使用提供的计算器工具来计算答案，而不要自己猜测。")
    String chat(@UserMessage String userMessage);
}
