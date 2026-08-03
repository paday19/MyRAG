package com.jinzhi.ai.rag.admin.service;

import com.jinzhi.ai.rag.admin.controller.vo.DashboardOverviewVO;
import com.jinzhi.ai.rag.admin.controller.vo.DashboardPerformanceVO;
import com.jinzhi.ai.rag.admin.controller.vo.DashboardTrendsVO;

public interface DashboardService {

    DashboardOverviewVO loadOverview(String window);

    DashboardPerformanceVO loadPerformance(String window);

    DashboardTrendsVO loadTrends(String metric, String window, String granularity);
}
