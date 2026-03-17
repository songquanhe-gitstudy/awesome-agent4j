package com.awesome.agent4j.agent;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface TextSummarizer {
    @SystemMessage("你是一个擅长总结提炼的高级编辑。")
    @UserMessage("请将以下长文本总结为一段不超过50字的简短摘要:\n\n{{it}}")
    String summarize(String text);
}
