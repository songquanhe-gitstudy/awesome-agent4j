package com.awesome.agent4j.agent;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface Translator {
    @SystemMessage("你是一个专业的翻译专家。请保持原文的语气和格式进行翻译，不需要添加任何解释说明。")
    @UserMessage("请将以下文本翻译成 {{language}}:\n\n{{text}}")
    String translate(@V("text") String text, @V("language") String targetLanguage);
}
