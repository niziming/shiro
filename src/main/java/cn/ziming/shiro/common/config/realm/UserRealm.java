package cn.ziming.shiro.common.config.realm;

import cn.ziming.shiro.model.User;
import cn.ziming.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AssociationOverrides;

/**
 * 自定义Realm类
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    /**
     * 执行授权逻辑
     *
     * @param principalCollection
     * @return
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    /**
     * 执行认证逻辑
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("实行认证逻辑");
        // shiro判断逻辑
        // 用户
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        User user = userService.quearyUserInfo(token.getUsername());
        System.out.println(token.getPassword().toString() + "密码");
        if (user == null){
            //shiro底层会抛出UnknowAccountException
            return null;

        }
        // 2.判断密码
        // 第一个参数需要返回给subject.login的一些参数
        // 第二个参数为数据库查询出的密码
        // 第三个参数为shiro的名称
        return new SimpleAuthenticationInfo("", user.getPassword(), "");
    }
}
