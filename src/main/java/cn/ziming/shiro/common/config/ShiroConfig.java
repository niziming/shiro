package cn.ziming.shiro.common.config;

import cn.ziming.shiro.common.config.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro的配置类
 */

@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /**
         * 添加shiro内置过滤器
         * Shiro内置过滤实现权限相关拦截
         * 常用过滤:
         *  anon:无需认证(登录)可访问
         *  authc 必须认证才可以访问
         *  user: remember ME的功能可访问
         *  permse:该资源必须得到资源权限才可以访问
         *  role: 该资源必须得到资源授权可访问
         */
        Map<String, String> filterMap = new LinkedHashMap<String, String>();
        // filterMap.put("/user/add", "authc");
        // filterMap.put("/user/update", "authc");

        // exclude
        filterMap.put("/user/info", "anon");
        filterMap.put("/user/testThymeleaf", "anon");
        filterMap.put("/user/doLogin", "anon");

        // include
        filterMap.put("/user/*", "authc");




        //修改跳转登录页面
        shiroFilterFactoryBean.setLoginUrl("/user/login");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }


    /**
     * 创建DefaultWebSecurityManager
     * 也就是SecurityManager
     * 参数中的@Qualifier注解代表获取Spring环境的Bean类
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     * 放入spring环境@Bean
     */
    @Bean(name="userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }
}
