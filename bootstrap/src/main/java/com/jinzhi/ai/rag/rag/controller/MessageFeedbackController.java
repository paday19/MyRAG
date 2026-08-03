package com.jinzhi.ai.rag.rag.controller;

import com.jinzhi.ai.rag.framework.convention.Result;
import com.jinzhi.ai.rag.framework.web.Results;
import com.jinzhi.ai.rag.rag.controller.request.MessageFeedbackRequest;
import com.jinzhi.ai.rag.rag.service.MessageFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 会话消息反馈控制器
 */
@RestController
@RequiredArgsConstructor
public class MessageFeedbackController {

    private final MessageFeedbackService feedbackService;

    /**
     * 提交点赞/踩反馈（异步，通过 MQ 持久化）
     */
    @PostMapping("/conversations/messages/{messageId}/feedback")
    public Result<Void> submitFeedback(@PathVariable String messageId,
                                       @RequestBody MessageFeedbackRequest request) {
        feedbackService.submitFeedbackAsync(messageId, request);
        return Results.success();
    }

    /**
     * 取消点赞/踩反馈（异步，通过 MQ 持久化）
     */
    @DeleteMapping("/conversations/messages/{messageId}/feedback")
    public Result<Void> cancelFeedback(@PathVariable String messageId) {
        feedbackService.cancelFeedbackAsync(messageId);
        return Results.success();
    }
}

