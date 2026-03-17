package com.awesome.agent4j.service.impl;

import com.awesome.agent4j.agent.Assistant;
import com.awesome.agent4j.service.AgentService;
import com.awesome.agent4j.tools.CalculatorTool;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl implements AgentService {

    private final Assistant assistant;

    public AgentServiceImpl(ChatLanguageModel chatLanguageModel, CalculatorTool calculatorTool) {
        // 创建带有工具调用和记忆能力的Agent
        this.assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(chatLanguageModel)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .tools(calculatorTool)
                .build();
    }

    @Override
    public String chatWithAgent(String message) {
        return assistant.chat(message);
    }
}
