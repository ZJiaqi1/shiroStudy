package com.ecidi.springbootshiro.realm;

import com.ecidi.springbootshiro.entity.Account;
import com.ecidi.springbootshiro.service.IAccountService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class AccoutRealm extends AuthorizingRealm {
    @Autowired
    private IAccountService accountService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        Account account = accountService.findByUsername(usernamePasswordToken.getUsername());
        if(StringUtils.isEmpty(account)){
            return new SimpleAuthenticationInfo(account,account.getPassword(),getName());
        }
        return null;
    }
}
