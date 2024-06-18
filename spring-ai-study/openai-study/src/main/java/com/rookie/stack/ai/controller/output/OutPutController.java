package com.rookie.stack.ai.controller.output;

import com.rookie.stack.ai.data.Movies;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.converter.MapOutputConverter;
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
@RequestMapping("/output")
public class OutPutController {
    private final ChatClient chatClient;

    public OutPutController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("bean_movie")
    public Movies getHistoryPopularMovieByBean(@RequestParam(value = "category",
            defaultValue = "悬疑") String category) {

        BeanOutputConverter<Movies> outputConverter = new BeanOutputConverter<>(Movies.class);
        String format = outputConverter.getFormat();

        String message = """
                列出你认为的世界上最好的 10部{category}电影，带上他们上映的年份；
                并给出推荐理由，以JSON格式以及中文内容返回，并且只返回结果，不返回任何无用的描述，如果返回其他信息会受到处罚;
                
                {format}
                """;
        PromptTemplate promptTemplate = new PromptTemplate(message, Map.of("category", category, "format" ,format));
        Prompt prompt = new Prompt(promptTemplate.createMessage());
        System.out.println(prompt.getContents());
        Generation generation = this.chatClient.prompt(prompt).call().chatResponse().getResult();
        return outputConverter.convert(generation.getOutput().getContent());
    }

}
