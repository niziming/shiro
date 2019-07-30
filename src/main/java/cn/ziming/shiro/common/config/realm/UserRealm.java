package cn.ziming.shiro.common.config.realm;

import cn.ziming.shiro.model.User;
import cn.ziming.shiro.service.RoleService;
import cn.ziming.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义Realm类
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    /**
     * 执行授权逻辑
     *
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) throws AuthenticationException {
        System.out.println("执行授权逻辑");
        // 给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 添加资源授权字符
        // info.addStringPermission("add");

        Subject subject = SecurityUtils.getSubject();

        // 用户输入的信息
        User user = (User) subject.getPrincipal();

        // 查询
        List<String> privileges = userService.selectPrivilegeByUid(user.getId());
        List<String> Roles = roleService.selectNameByUid(user.getId());

        // 授权
        info.addStringPermissions(privileges);
        info.addStringPermissions(Roles);

        return info;
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
        // 第一个参数需要返回给subject.login的一些参数也就是principal
        // 第二个参数为数据库查询出的密码
        // 第三个参数为shiro的名称
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), "");

        return info;
    }
}
