package com.jinzhi.ai.rag;

import com.mzt.logapi.starter.annotation.EnableLogRecord;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Ragent 核心应用启动类
 */
@SpringBootApplication
@EnableScheduling
@EnableLogRecord(tenant = "ragent", proxyTargetClass = true)
@MapperScan(basePackages = {
        "com.jinzhi.ai.rag.rag.dao.mapper",
        "com.jinzhi.ai.rag.ingestion.dao.mapper",
        "com.jinzhi.ai.rag.knowledge.dao.mapper",
        "com.jinzhi.ai.rag.user.dao.mapper",
        "com.jinzhi.ai.rag.audit.dao.mapper"
})
public class RagentApplication {

    public static void main(String[] args) {
        SpringApplication.run(RagentApplication.class, args);
    }
}

