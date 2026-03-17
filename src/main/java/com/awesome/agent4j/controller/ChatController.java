package com.awesome.agent4j.controller;

import dev.langchain4j.model.chat.ChatLanguageModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Chat API", description = "与大语言模型交互的接口")
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatLanguageModel chatLanguageModel;

    public ChatController(ChatLanguageModel chatLanguageModel) {
        this.chatLanguageModel = chatLanguageModel;
    }

    @Operation(summary = "发送消息", description = "向大语言模型发送一条消息并获取回复")
    @GetMapping("/send")
    public String chat(
            @Parameter(description = "要发送给模型的消息内容") 
            @RequestParam(defaultValue = "你好，请用一句话介绍自己") String message) {
        
        return chatLanguageModel.generate(message);
    }
}
