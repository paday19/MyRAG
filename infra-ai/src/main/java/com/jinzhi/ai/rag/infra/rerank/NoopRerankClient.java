package com.jinzhi.ai.rag.infra.rerank;

import com.jinzhi.ai.rag.framework.convention.RetrievedChunk;
import com.jinzhi.ai.rag.infra.enums.ModelProvider;
import com.jinzhi.ai.rag.infra.model.ModelTarget;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoopRerankClient implements RerankClient {

    @Override
    public String provider() {
        return ModelProvider.NOOP.getId();
    }

    @Override
    public List<RetrievedChunk> rerank(String query, List<RetrievedChunk> candidates, int topN, ModelTarget target) {
        if (candidates == null || candidates.isEmpty()) {
            return List.of();
        }
        if (topN <= 0 || candidates.size() <= topN) {
            return candidates;
        }
        return candidates.stream()
                .limit(topN)
                .collect(Collectors.toList());
    }
}
