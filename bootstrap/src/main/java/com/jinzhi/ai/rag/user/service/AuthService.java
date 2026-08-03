package com.jinzhi.ai.rag.user.service;

import com.jinzhi.ai.rag.user.controller.request.LoginRequest;
import com.jinzhi.ai.rag.user.controller.vo.LoginVO;

public interface AuthService {

    LoginVO login(LoginRequest requestParam);

    void logout();
}
