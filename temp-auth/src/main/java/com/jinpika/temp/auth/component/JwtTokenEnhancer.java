package com.jinpika.temp.auth.component;

import com.jinpika.temp.auth.domain.SecurityUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// 定义JWT Token的增强器，用于在JWT Token中添加额外信息
@Component
public class JwtTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        // 获取认证信息
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        // 创建额外信息Map
        Map<String, Object> info = new HashMap<>();
        // 把用户ID设置到JWT中
        info.put("id", securityUser.getId());
        // 把额外信息添加到JWT Token中
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
