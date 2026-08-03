package com.jinzhi.ai.rag.user.controller;

import com.jinzhi.ai.rag.framework.convention.Result;
import com.jinzhi.ai.rag.framework.web.Results;
import com.jinzhi.ai.rag.user.controller.request.LoginRequest;
import com.jinzhi.ai.rag.user.controller.vo.LoginVO;
import com.jinzhi.ai.rag.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证控制器
 * 处理用户登录和登出相关的请求
 */
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * 用户登录接口
     */
    @PostMapping("/auth/login")
    public Result<LoginVO> login(@RequestBody LoginRequest requestParam) {
        return Results.success(authService.login(requestParam));
    }

    /**
     * 用户登出接口，清除用户的认证信息和会话
     */
    @PostMapping("/auth/logout")
    public Result<Void> logout() {
        authService.logout();
        return Results.success();
    }
}
