package com.jinzhi.ai.rag.infra.chat;

import com.jinzhi.ai.rag.framework.trace.RagStreamTraceSupport;

/**
 * 把 StreamSpan 的 finish 桥接到 StreamCallback 的终态事件，
 * 让 *-stream-chat trace 节点记录从开始到 onComplete / onError 的真实耗时
 */
public final class StreamSpanCallback extends ForwardingStreamCallback {

    private final RagStreamTraceSupport.StreamSpan span;

    public StreamSpanCallback(StreamCallback delegate, RagStreamTraceSupport.StreamSpan span) {
        super(delegate);
        this.span = span;
    }

    @Override
    protected void onFinish(boolean success, Throwable error) {
        if (success) {
            span.finishSuccess();
        } else {
            span.finishError(error);
        }
    }

    /**
     * 取消时由调用方触发：若 span 仍 RUNNING，按取消语义结束，避免 trace 行悬挂
     */
    public void onCancel() {
        span.finishCancelledIfRunning();
        finishExternally(false, null);
    }
}
