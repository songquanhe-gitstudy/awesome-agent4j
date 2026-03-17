package com.awesome.agent4j.controller;

import com.awesome.agent4j.service.AdvancedAgentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Advanced Agent API", description = "进阶版 ReAct Agent，具备多工具决策、状态管理和追问能力")
@RestController
@RequestMapping("/api/advanced-agent")
public class AdvancedAgentController {

    private final AdvancedAgentService advancedAgentService;

    public AdvancedAgentController(AdvancedAgentService advancedAgentService) {
        this.advancedAgentService = advancedAgentService;
    }

    @Operation(
        summary = "与全能 Agent 对话", 
        description = "示例问题：\n" +
                      "1. 多工具决策：'帮我算下 12.5*8，然后看看上海的天气。'\n" +
                      "2. 状态管理：'帮我记一下，明天早上9点去体检。' 随后问 '我明天有什么事？'\n" +
                      "3. 边界测试：'帮我订一张去西藏的火车票。'\n" +
                      "4. 追问测试：'天气怎么样？'"
    )
    @GetMapping("/chat")
    public String chat(
            @Parameter(description = "发送给全能 Agent 的消息") 
            @RequestParam(defaultValue = "帮我算下 12.5*8，然后看看上海的天气。") String message) {
        
        return advancedAgentService.ask(message);
    }
}
