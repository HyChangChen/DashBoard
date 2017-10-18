package com.hxqh.eam.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lh on 2017/4/20.
 */
public class Realm extends AuthorizingRealm {

    private static Map<String,String> userInfo = new HashMap<>();
    static {
        userInfo.put("zs","123");
        userInfo.put("ls","123");
        userInfo.put("ww","456");
    }

    @Override
    public void setName(String name) {
        super.setName("testRealm");

    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String usercode = (String)authenticationToken.getPrincipal();
        String pwd = null;

        for(Map.Entry<String,String> map :userInfo.entrySet())
        {
            if(usercode.equals(map.getKey()))
            {
                pwd= map.getValue();
                break;
            }
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(usercode,pwd,this.getName());

        return simpleAuthenticationInfo;
    }
}
