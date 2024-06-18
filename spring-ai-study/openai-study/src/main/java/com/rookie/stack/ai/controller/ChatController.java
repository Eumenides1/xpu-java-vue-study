package com.rookie.stack.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author eumenides
 * @description
 * @date 2024/6/18
 */
@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }
    @GetMapping("/hello")
    public String chat(@RequestParam(value = "message",
            defaultValue = "Hello Openai, How are you?")
                       String message) {
        return chatClient.prompt().user(message).call().content();
    }

    @GetMapping("/prompt")
    public String prompt(@RequestParam(value = "message",
            defaultValue = "Hello Openai, How are you?")
                       String message) {
        return chatClient.prompt(new Prompt(new UserMessage(message))).call().content();
    }

    @GetMapping("popular")
    public String getHistoryPopularMovie(@RequestParam(value = "category",
            defaultValue = "悬疑") String category) {

        String message = """
                列出你认为的世界上最好的 10部{category}电影，带上他们上映的年份；
                并给出推荐理由，以JSON格式以及中文内容返回，并且只返回结果，不返回任何无用的描述，如果返回其他信息会受到处罚
                """;

        PromptTemplate promptTemplate = new PromptTemplate(message);
        Prompt prompt = promptTemplate.create(Map.of("category", category));

        return this.chatClient.prompt(prompt).call().content();
    }



}
