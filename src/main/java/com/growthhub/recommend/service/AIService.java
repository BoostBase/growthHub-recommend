package com.growthhub.recommend.service;

import com.growthhub.recommend.dto.ResponseTemplate;
import com.growthhub.recommend.feign.LoadMapFeign;
import com.growthhub.recommend.feign.UserFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AIService {
    private final ChatModel chatModel;
    private final UserFeign userFeign;
    private final LoadMapFeign loadMapFeign;

    public ResponseEntity<ResponseTemplate<Object>> getResponse(String message) {
        Message userMessage = getMessage(message);
        ResponseEntity<List<Long>> recommendedUsers = userFeign.getRecommendedUsers(chatModel.call(userMessage));
        return loadMapFeign.getRoadmapByUsers(recommendedUsers.getBody());
    }

    private Message getMessage(String message) {
        String command = "내가 문장을 줄테니까 너는 답변을 문자열로 딱 떨어지게 주면된다\n" +
                "예를 들어 \"나는 스프링 관련 공부를 하고 있어\" 라고 하면 스프링 이렇게 주면 되는거고\n" +
                "\"나는 문자열 처리 좀 관심 있어\"라고 하면 파이썬 이런식으로 주면 되는거야\n" +
                "참고로 무조건 프로그래밍 관련으로만 대답해줘야해"+
                "\"\" << 이거 사이에 문자를 넣어줄거고 지금부터 시작할거야\n" +
                "\"" + message + "\"";

        PromptTemplate template = new PromptTemplate(command);
        template.add("message", message);

        String templateMessage = template.render();
        return new UserMessage(templateMessage);
    }
}