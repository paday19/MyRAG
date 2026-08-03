package com.jinzhi.ai.rag.infra.enums;

import lombok.Getter;

/**
 *
 */
@Getter
public enum Tier {

    /**
     * 快速档：低延迟优先，用于高频或低风险任务（标题、歧义、改写、摘要、入库富化/增强）
     */
    FAST("fast"),

    /**
     * 标准档：质量与成本平衡，未显式指定档位时的默认档
     */
    STANDARD("standard"),

    /**
     * 深度档：高质量、高成本，用于深度思考回答（通常由 thinking=true 触发）
     */
    DEEP("deep");

    /**
     * -- GETTER --
     *  对应 ai.chat.tiers 下的档位键
     */
    private final String key;

    Tier(String key) {
        this.key = key;
    }
}
