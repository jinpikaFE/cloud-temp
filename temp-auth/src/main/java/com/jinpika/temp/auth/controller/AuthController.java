package com.jinpika.temp.auth.controller;

import com.jinpika.common.api.CommonResult;
import com.jinpika.temp.auth.domain.Oauth2TokenDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "AuthController")
@Tag(name = "AuthController", description = "权限")
@RestController
@RequestMapping("/auth/oauth")
public class AuthController {

    @Autowired
    private TokenEndpoint tokenEndpoint;

    /**
     * Oauth2登录认证
     */
    @ApiOperation("Oauth2登录认证")
    @PostMapping("/token")
    public ResponseEntity<CommonResult<Oauth2TokenDto>> postAccessToken(HttpServletRequest request,
                                                                        @ApiParam("授权模式") @RequestParam String grant_type,
                                                                        @ApiParam("Oauth2客户端ID") @RequestParam String client_id,
                                                                        @ApiParam("Oauth2客户端秘钥") @RequestParam String client_secret,
                                                                        @ApiParam("刷新token") @RequestParam(required = false) String refresh_token,
                                                                        @ApiParam("登录用户名") @RequestParam(required = false) String username,
                                                                        @ApiParam("登录密码") @RequestParam(required = false) String password) throws HttpRequestMethodNotSupportedException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("grant_type", grant_type);
        parameters.put("client_id", client_id);
        parameters.put("client_secret", client_secret);
        parameters.putIfAbsent("refresh_token", refresh_token);
        parameters.putIfAbsent("username", username);
        parameters.putIfAbsent("password", password);
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(request.getUserPrincipal(), parameters).getBody();
        Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .tokenHead("Bearer ").build();

        return CommonResult.success(oauth2TokenDto);
    }

    /**
     * Oauth2登录认证
     */
    @ApiOperation("test")
    @GetMapping("/test")
    public ResponseEntity<CommonResult<String>> test() {

        return CommonResult.success("test");
    }
}