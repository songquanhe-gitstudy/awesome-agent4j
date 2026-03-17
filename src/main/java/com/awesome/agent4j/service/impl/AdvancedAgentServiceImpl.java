package com.awesome.agent4j.service.impl;

import com.awesome.agent4j.agent.AdvancedAssistant;
import com.awesome.agent4j.service.AdvancedAgentService;
import com.awesome.agent4j.tools.CalculatorTool;
import com.awesome.agent4j.tools.TaskTool;
import com.awesome.agent4j.tools.WeatherTool;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.springframework.stereotype.Service;

@Service
public class AdvancedAgentServiceImpl implements AdvancedAgentService {

    private final AdvancedAssistant assistant;

    public AdvancedAgentServiceImpl(
            ChatLanguageModel chatLanguageModel,
            CalculatorTool calculatorTool,
            WeatherTool weatherTool,
            TaskTool taskTool) {

        // 构造全能助手：注入三个工具，并赋予 10 条消息的短期记忆
        this.assistant = AiServices.builder(AdvancedAssistant.class)
                .chatLanguageModel(chatLanguageModel)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .tools(calculatorTool, weatherTool, taskTool)
                .build();
    }

    @Override
    public String ask(String userMessage) {
        return assistant.chat(userMessage);
    }
}
