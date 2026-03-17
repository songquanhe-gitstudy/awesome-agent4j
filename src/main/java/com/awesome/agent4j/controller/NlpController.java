package com.awesome.agent4j.controller;

import com.awesome.agent4j.model.Person;
import com.awesome.agent4j.model.Sentiment;
import com.awesome.agent4j.service.NlpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "NLP API", description = "自然语言处理及信息提取接口 (文本总结、翻译、情感分析、实体提取)")
@RestController
@RequestMapping("/api/nlp")
public class NlpController {

    private final NlpService nlpService;

    public NlpController(NlpService nlpService) {
        this.nlpService = nlpService;
    }

    @Operation(summary = "结构化数据提取", description = "从自然语言文本中提取出明确的 Java 对象(Person实体)")
    @GetMapping("/extract-person")
    public Person extractPerson(
            @Parameter(description = "包含人物信息的自然语言文本") 
            @RequestParam(defaultValue = "我昨天认识了一个新朋友叫李雷，他今年28岁，目前在一家大厂做软件工程师。") String text) {
        
        return nlpService.extractPersonInfo(text);
    }

    @Operation(summary = "文本分类(情感分析)", description = "分析给出文本的情感偏向，并直接将其映射为 Java 枚举")
    @GetMapping("/analyze-sentiment")
    public Sentiment analyzeSentiment(
            @Parameter(description = "要分析情感的自然语言文本") 
            @RequestParam(defaultValue = "这个产品的质量真的太差了，我用了半天就坏了，客服态度也很敷衍！") String text) {
        
        return nlpService.analyzeSentiment(text);
    }

    @Operation(summary = "多语言翻译", description = "使用 AI 代理进行高质量的文本翻译，通过变量 (@V) 动态传入目标语言")
    @GetMapping("/translate")
    public String translate(
            @Parameter(description = "要翻译的文本") 
            @RequestParam(defaultValue = "LangChain4j is an amazing framework for building LLM-powered applications in Java.") String text,
            @Parameter(description = "目标语言") 
            @RequestParam(defaultValue = "中文") String targetLanguage) {
        
        return nlpService.translateText(text, targetLanguage);
    }

    @Operation(summary = "文本总结", description = "使用 AI 对长文本进行简明扼要的总结概括，运用 @SystemMessage 设置人格")
    @GetMapping("/summarize")
    public String summarize(
            @Parameter(description = "长文本内容") 
            @RequestParam(defaultValue = "人工智能（Artificial Intelligence，缩写为AI）亦称智械、机器智能，指由人制造出来的机器所表现出来的智能。通常人工智能是指通过普通计算机程序来呈现人类智能的技术。该词也指出研究这样的智能系统是否能够实现，以及如何实现。人工智能的研究是高度技术性和专业的，各分支领域都是深入且各不相通的，因而涉及范围极广。") String text) {
        
        return nlpService.summarizeText(text);
    }
}
