package com.ecidi.springbootshiro.config;

import com.ecidi.springbootshiro.realm.AccoutRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //认证和授权
        Map<String, String> map = new HashMap<>();
        map.put("/main","authc");
        map.put("/manage","perms[manage]");
        map.put("/administator","roles[administator]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("accoutRealm") AccoutRealm accoutRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(accoutRealm);
        return manager;
    }

    @Bean
    public AccoutRealm accoutRealm() {
        return new AccoutRealm();
    }
}
