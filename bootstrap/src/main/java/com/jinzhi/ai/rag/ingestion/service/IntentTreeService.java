package com.jinzhi.ai.rag.ingestion.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jinzhi.ai.rag.rag.controller.request.IntentNodeCreateRequest;
import com.jinzhi.ai.rag.rag.controller.request.IntentNodeUpdateRequest;
import com.jinzhi.ai.rag.rag.controller.vo.IntentNodeTreeVO;
import com.jinzhi.ai.rag.rag.dao.entity.IntentNodeDO;

import java.util.List;

public interface IntentTreeService extends IService<IntentNodeDO> {

    /**
     * 查询整棵意图树（包含 RAG + SYSTEM）
     */
    List<IntentNodeTreeVO> getFullTree();

    /**
     * 新增节点
     */
    String createNode(IntentNodeCreateRequest requestParam);

    /**
     * 更新节点
     */
    void updateNode(String id, IntentNodeUpdateRequest requestParam);

    /**
     * 删除节点（逻辑删除）
     */
    void deleteNode(String id);

    /**
     * 批量启用节点
     */
    void batchEnableNodes(List<String> ids);

    /**
     * 批量停用节点
     */
    void batchDisableNodes(List<String> ids);

    /**
     * 批量删除节点（逻辑删除）
     */
    void batchDeleteNodes(List<String> ids);

    /**
     * 从 IntentTreeFactory 初始化全量 Tree 到数据库
     */
    int initFromFactory();
}