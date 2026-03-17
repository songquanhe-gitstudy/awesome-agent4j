package com.awesome.agent4j.agent;

import com.awesome.agent4j.model.Person;
import dev.langchain4j.service.UserMessage;

public interface PersonExtractor {
    @UserMessage("请从以下文本中提取出人物信息(包含：name:姓名，age:年龄，job:职业)。如果没有提到请留空。\n文本: {{it}}")
    Person extractPersonFrom(String text);
}
