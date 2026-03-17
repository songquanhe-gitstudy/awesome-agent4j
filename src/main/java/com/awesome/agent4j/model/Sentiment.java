package com.awesome.agent4j.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "情感分类枚举")
public enum Sentiment {
    @Schema(description = "正面情感")
    POSITIVE,
    
    @Schema(description = "中性情感")
    NEUTRAL,
    
    @Schema(description = "负面情感")
    NEGATIVE
}
