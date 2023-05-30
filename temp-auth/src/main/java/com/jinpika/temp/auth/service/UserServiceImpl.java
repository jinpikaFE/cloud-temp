package com.jinpika.temp.auth.service;

import com.jinpika.common.domain.UserDto;
import com.jinpika.temp.auth.constant.MessageConstant;
import com.jinpika.temp.auth.domain.SecurityUser;
import com.jinpika.temp.auth.feign.UmsFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户管理业务类
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UmsFeignService umsFeignService;

    @Autowired
    private HttpServletRequest request;

    @Value("${auth-info.client-id}")
    private String CLIENT_ID;

    @Value("${auth-info.client-secret}")
    private String CLIENT_SECRET;

    @Value("${auth-info.grant-type}")
    private String GRANT_TYPE;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String clientId = request.getParameter("client_id");
        UserDto userDto;
//        if(CLIENT_ID.equals(clientId)){
//            userDto = umsFeignService.loadUserByUsername(username);
//        } // 其他client_id 在此处扩展
        userDto = umsFeignService.loadUserByUsername(username);
        if (userDto == null) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        userDto.setClientId(clientId);
        SecurityUser securityUser = new SecurityUser(userDto);
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return securityUser;
    }

}