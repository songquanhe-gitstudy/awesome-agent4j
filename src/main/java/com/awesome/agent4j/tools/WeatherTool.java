package com.awesome.agent4j.tools;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class WeatherTool {

    @Tool("查询指定城市的天气信息")
    public String getWeather(String city) {
        System.out.println("调用工具: getWeather(" + city + ")");
        if (city.contains("北京")) {
            return "北京天气晴朗，气温 15°C，北风 3 级。";
        } else if (city.contains("上海")) {
            return "上海阴转小雨，气温 12°C，南风 2 级。建议携带雨具。";
        } else if (city.contains("广州")) {
            return "广州多云，气温 22°C，微风。";
        } else {
            return city + "的天气信息暂时无法获取。";
        }
    }
}
