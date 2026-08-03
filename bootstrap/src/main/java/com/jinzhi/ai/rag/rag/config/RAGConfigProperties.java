package com.jinzhi.ai.rag.rag.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * RAG 系统功能配置
 *
 * <p>
 * 用于管理 RAG 系统的各项功能开关，例如查询重写等
 * </p>
 *
 * <pre>
 * 示例配置：
 *
 * rag:
 *   query-rewrite:
 *     enabled: true
 * </pre>
 */
@Data
@Configuration
public class RAGConfigProperties {

    /**
     * 查询重写功能开关
     * <p>
     * 控制是否启用查询重写功能，查询重写可以将用户的查询语句优化为更适合检索的形式
     * 默认值：{@code true}
     */
    @Value("${rag.query-rewrite.enabled:true}")
    private Boolean queryRewriteEnabled;

    /**
     * Rerank 重排序功能开关
     * <p>
     * 控制是否启用 Rerank 后置处理器对召回结果进行重排序
     * 默认值：{@code true}
     */
    @Value("${rag.rerank.enabled:true}")
    private Boolean rerankEnabled;

    /**
     * 上下文元数据富化开关
     * <p>
     * 控制是否在检索末端回表补齐 chunk 的文档归属信息（文档ID/序号/标题），
     * 并在组装上下文时按文档聚合、组内按序号排列、带上文档标题作为内部锚点
     * 关闭后组装退回按检索相关性平铺、不带来源
     * 默认值：{@code true}
     */
    @Value("${rag.context.enrich.enabled:true}")
    private Boolean contextEnrichEnabled;
}
