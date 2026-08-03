package com.jinzhi.ai.rag.rag.controller;

import com.jinzhi.ai.rag.framework.context.UserContext;
import com.jinzhi.ai.rag.framework.convention.Result;
import com.jinzhi.ai.rag.framework.web.Results;
import com.jinzhi.ai.rag.rag.dto.RecommendedQuestionsPayload;
import com.jinzhi.ai.rag.rag.service.RecommendedQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 推荐追问问题控制器
 * <p>
 * GET 只读缓存，POST 幂等生成并落库
 */
@RestController
@RequiredArgsConstructor
public class RecommendedQuestionController {

    private final RecommendedQuestionService recommendedQuestionService;

    /**
     * 获取已缓存的推荐追问问题
     */
    @GetMapping("/conversations/messages/{messageId}/recommended-questions")
    public Result<RecommendedQuestionsPayload> getCached(@PathVariable String messageId) {
        return Results.success(recommendedQuestionService.getCached(messageId, UserContext.getUserId()));
    }

    /**
     * 生成推荐追问问题
     */
    @PostMapping("/conversations/messages/{messageId}/recommended-questions")
    public Result<RecommendedQuestionsPayload> generate(@PathVariable String messageId) {
        return Results.success(recommendedQuestionService.generate(messageId, UserContext.getUserId()));
    }
}

