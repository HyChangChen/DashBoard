package com.hxqh.eam.common.util;

import com.hxqh.eam.model.SfOrganizationAccount;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by Ocean lin on 2017/6/30.
 */
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private final int hashIterations = 2;

    public void encryptPassword(SfOrganizationAccount user) {
        //TODO 获取随机salt
        //user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                //TODO  user.getCredentialsSalt()辅助方法返回username+salt。
                //ByteSource.Util.bytes(user.getCredentialsSalt()),
                ByteSource.Util.bytes("lab1107"),
                hashIterations).toHex();
        user.setPassword(newPassword);
    }
}
