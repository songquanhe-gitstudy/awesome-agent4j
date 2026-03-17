package com.awesome.agent4j.controller;

import com.awesome.agent4j.service.AgentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Agent API", description = "带有工具调用能力的大语言模型(ReAct Agent)接口")
@RestController
@RequestMapping("/api/agent")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @Operation(summary = "与Agent对话", description = "发送消息，Agent可能会调用内部计算器工具来回答复杂问题，比如：'计算123加上456等于多少，再乘以2'")
    @GetMapping("/chat")
    public String chat(
            @Parameter(description = "要发送给Agent的消息内容") 
            @RequestParam(defaultValue = "计算123加上456等于多少，再乘以2") String message) {
        
        return agentService.chatWithAgent(message);
    }
}
