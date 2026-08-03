package com.jinzhi.ai.rag.audit.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jinzhi.ai.rag.audit.controller.request.BizChangeLogPageRequest;
import com.jinzhi.ai.rag.audit.controller.vo.BizChangeLogVO;

public interface BizChangeLogService {

    IPage<BizChangeLogVO> page(BizChangeLogPageRequest requestParam);

    BizChangeLogVO get(String id);
}
