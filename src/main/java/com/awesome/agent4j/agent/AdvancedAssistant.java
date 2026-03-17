package com.awesome.agent4j.agent;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface AdvancedAssistant {

    @SystemMessage({
        "你是一个全能的私人智能助手。",
        "你可以帮用户进行复杂的数学计算、查询城市天气，以及管理日常的待办事项。",
        "如果用户查询天气但没有指明城市，请务必追问用户想查询哪个城市。",
        "如果用户询问超出你能力范围的事情（例如订票、外卖等），请礼貌地告知用户你目前无法执行这些物理操作。",
        "请尽量保持回复简洁专业。"
    })
    String chat(@UserMessage String userMessage);
}
