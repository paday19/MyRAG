package com.jinzhi.ai.rag.rag.dto;

import java.util.List;

/**
 * 推荐追问生成结果
 */
public record RecommendedQuestionsPayload(Status status, List<String> questions) {

    public RecommendedQuestionsPayload {
        questions = questions == null ? List.of() : List.copyOf(questions);
    }

    public static RecommendedQuestionsPayload success(List<String> questions) {
        return questions == null || questions.isEmpty()
                ? empty()
                : new RecommendedQuestionsPayload(Status.SUCCESS, questions);
    }

    public static RecommendedQuestionsPayload empty() {
        return new RecommendedQuestionsPayload(Status.EMPTY, List.of());
    }

    public static RecommendedQuestionsPayload failed() {
        return new RecommendedQuestionsPayload(Status.FAILED, List.of());
    }

    public enum Status {
        SUCCESS,
        EMPTY,
        FAILED
    }
}

