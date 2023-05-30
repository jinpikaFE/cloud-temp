package com.jinpika.common.constant;

public class AuthConstant {

    public static final String AUTHORITY_PREFIX = "ROLE_";

    public static final String AUTHORITY_CLAIM_NAME = "authorities";

    /**
     * 后台管理接口路径匹配
     */
    public static final String ADMIN_URL_PATTERN = "/mall-admin/**";

    /**
     * Redis缓存权限规则key
     */
    public static final String RESOURCE_ROLES_MAP_KEY = "auth:resourceRolesMap";

    /**
     * 认证信息Http请求头
     */
    public static final String JWT_TOKEN_HEADER = "Authorization";

    /**
     * JWT令牌前缀
     */
    public static final String JWT_TOKEN_PREFIX = "Bearer ";

    /**
     * 用户信息Http请求头
     */
    public static final String USER_TOKEN_HEADER = "user";

}