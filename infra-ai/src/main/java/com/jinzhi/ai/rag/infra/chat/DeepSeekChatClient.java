package com.jinzhi.ai.rag.infra.chat;

import com.google.gson.JsonObject;
import com.jinzhi.ai.rag.framework.convention.ChatRequest;
import com.jinzhi.ai.rag.framework.trace.RagTraceNode;
import com.jinzhi.ai.rag.infra.enums.ModelProvider;
import com.jinzhi.ai.rag.infra.model.ModelTarget;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeepSeekChatClient extends AbstractOpenAIStyleChatClient {

    @Override
    public String provider() {
        return ModelProvider.DEEPSEEK.getId();
    }

    @Override
    @RagTraceNode(name = "deepseek-chat", type = "LLM_PROVIDER")
    public String chat(ChatRequest request, ModelTarget target) {
        return doChat(request, target);
    }

    @Override
    public StreamCancellationHandle streamChat(ChatRequest request, StreamCallback callback, ModelTarget target) {
        return doStreamChat(request, callback, target);
    }

    @Override
    protected void customizeRequestBody(JsonObject body, ChatRequest request) {
        // V4 默认可能开启思考；非思考场景须显式 disabled，避免静默变成 reasoner 行为
        JsonObject thinking = new JsonObject();
        if (Boolean.TRUE.equals(request.getThinking())) {
            thinking.addProperty("type", "enabled");
            body.addProperty("reasoning_effort", "high");
        } else {
            thinking.addProperty("type", "disabled");
        }
        body.add("thinking", thinking);
    }
}