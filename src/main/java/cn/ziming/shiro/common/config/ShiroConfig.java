package cn.ziming.shiro.common.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import cn.ziming.shiro.common.config.realm.UserRealm;
import org.apache.shiro.session.mgt.SessionManager;
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
         *  role: 该角色必须得到角色授权可访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        // filterMap.put("/user/add", "authc");
        // filterMap.put("/user/update", "authc");

        // exclude
        System.out.println("不拦截开始");
        filterMap.put("/user/info", "anon");
        filterMap.put("/user/testThymeleaf", "anon");
        filterMap.put("/user/doLogin", "anon");
        filterMap.put("/static/asset/**", "anon");
        // filterMap.put("/static/static.html", "anon");

        // 资源拦截器
        filterMap.put(   "/user/add", "perms[add]");
        filterMap.put("/user/delete", "perms[delete]");
        filterMap.put("/user/update", "perms[update]");
        filterMap.put("/user/selete", "perms[selete]");
        filterMap.put("/user/department", "perms[softDep]");

        // 资源拦截后跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/unAuthorized");

        // include
        System.out.println("拦截开始");
        filterMap.put("/user/*", "authc");
        filterMap.put("/static/**", "authc");
        // filterMap.put("/static/static.html", "authc");

        //登陆拦截前跳转
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

    /**
     * 配合ShiroDialect
     * 前端显示拦截
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

    //自定义sessionManager
    @Bean
    public SessionManager sessionManager() {
        MySessionManager mySessionManager = new MySessionManager();
        // mySessionManager.setSessionDAO(redisSessionDAO());
        return mySessionManager;
    }



}
