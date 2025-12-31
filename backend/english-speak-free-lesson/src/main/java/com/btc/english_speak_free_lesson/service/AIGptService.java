package com.btc.english_speak_free_lesson.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.ResponseOutputMessage;
import com.openai.models.responses.ResponseOutputMessage.Content;

@Service
public class AIGptService {
	
	public String getAnswers(String question) {
		
		StringBuilder rs = new StringBuilder();
		
		OpenAIClient client = OpenAIOkHttpClient.builder()
			    .apiKey("###")
			    .build();
		
		ResponseCreateParams params = ResponseCreateParams.builder()
				.input(question)
				.model("gpt-4.1-mini")
				.maxOutputTokens(350)
				.build();
		 Response response = client.responses().create(params);
		 
		 ResponseOutputMessage res =  response.output().get(0).message().get();
		 List<Content> contents = res.content();
		 for(Content content: contents) {
			 rs.append(content.asOutputText().text());
		 }
		 
		 return rs.toString();
	}
}
