package com.awesome.agent4j.tools;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTool {

    @Tool("计算两个数字的和")
    public double add(double a, double b) {
        System.out.println("调用工具: add(" + a + ", " + b + ")");
        return a + b;
    }

    @Tool("计算两个数字的乘积")
    public double multiply(double a, double b) {
        System.out.println("调用工具: multiply(" + a + ", " + b + ")");
        return a * b;
    }
}
