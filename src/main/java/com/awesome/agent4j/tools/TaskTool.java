package com.awesome.agent4j.tools;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskTool {

    private final List<String> tasks = new ArrayList<>();

    @Tool("添加一个待办事项或日程任务")
    public String addTask(String content) {
        System.out.println("调用工具: addTask(" + content + ")");
        tasks.add(content);
        return "成功添加待办事项: " + content;
    }

    @Tool("列出所有当前的待办事项或日程安排")
    public List<String> listTasks() {
        System.out.println("调用工具: listTasks()");
        return tasks;
    }

    @Tool("删除一个指定的待办事项")
    public String deleteTask(String content) {
        System.out.println("调用工具: deleteTask(" + content + ")");
        if (tasks.removeIf(task -> task.contains(content))) {
            return "成功删除包含 '" + content + "' 的待办事项";
        }
        return "未找到匹配的待办事项";
    }
}
