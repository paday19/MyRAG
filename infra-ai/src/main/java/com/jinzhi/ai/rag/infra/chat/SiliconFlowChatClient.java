package com.jinzhi.ai.rag.infra.chat;

import com.jinzhi.ai.rag.framework.convention.ChatRequest;
import com.jinzhi.ai.rag.framework.trace.RagTraceNode;
import com.jinzhi.ai.rag.infra.enums.ModelProvider;
import com.jinzhi.ai.rag.infra.model.ModelTarget;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SiliconFlowChatClient extends AbstractOpenAIStyleChatClient {

    @Override
    public String provider() {
        return ModelProvider.SILICON_FLOW.getId();
    }

    @Override
    @RagTraceNode(name = "siliconflow-chat", type = "LLM_PROVIDER")
    public String chat(ChatRequest request, ModelTarget target) {
        return doChat(request, target);
    }

    @Override
    public StreamCancellationHandle streamChat(ChatRequest request, StreamCallback callback, ModelTarget target) {
        return doStreamChat(request, callback, target);
    }
}
