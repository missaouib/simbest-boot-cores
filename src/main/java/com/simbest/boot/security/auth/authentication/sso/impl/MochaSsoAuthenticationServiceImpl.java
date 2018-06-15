/*
 * 版权所有 © 北京晟壁科技有限公司 2008-2027。保留一切权利!
 */
package com.simbest.boot.security.auth.authentication.sso.impl;

import com.mochasoft.portal.encrypt.EncryptorUtil;
import com.simbest.boot.security.IAuthService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 用途：门户Portal单点登录验证服务
 * 作者: lishuyi 
 * 时间: 2018/1/20  15:06 
 */
@Component
@Slf4j
public class MochaSsoAuthenticationServiceImpl extends AbstractSsoAuthenticationService {

    private final static Integer TIMEOUT = 1800;

    @Value("${app.oa.portal.token}")
    private String portalToken;

    @Autowired
    private IAuthService authService;

    @Autowired
    public MochaSsoAuthenticationServiceImpl(IAuthService authService) {
        super(authService);
        this.authService = authService;
    }

    @Override
    public String decryptUsername(String username) {
        if(StringUtils.isNotEmpty(username)){
            try {
                username = EncryptorUtil.decode(portalToken, username, TIMEOUT);
                log.debug("Actually get username from request with: {}", username);
                return username;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
        }
    }


}
