package com.rookie.stack.ai.controller.stuff;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eumenides
 * @description
 * @date 2024/6/18
 */
@RestController
@RequestMapping("/stuff")
public class StuffController {

    @Value("classpath:/prompts/olympic-sports.st")
    private Resource olympicSportsResource;

    @Value("classpath:/docs/olympic-sports.txt")
    private Resource docsToStuffResource;

    private final ChatClient chatClient;

    public StuffController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/2024")
    public String getSports(
            @RequestParam(value = "message", defaultValue = "2024年夏季奥运会都包括哪些运动项目") String message,
            @RequestParam(value = "stuffit", defaultValue = "false") boolean stuffit
    ){

        PromptTemplate promptTemplate = new PromptTemplate(olympicSportsResource);

        Map<String,Object> map  = new HashMap<>();
        map.put("question",message);

        if(stuffit) {
            map.put("context", docsToStuffResource);
        } else {
            map.put("context", "");
        }

        Prompt prompt = promptTemplate.create(map);
        System.out.println(prompt.getContents());
        ChatResponse response = chatClient.prompt(prompt).call().chatResponse();

        return response.getResult().getOutput().getContent();

    }

}
