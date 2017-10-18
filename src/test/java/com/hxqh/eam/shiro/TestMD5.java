package com.hxqh.eam.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lh on 2017/4/20.
 */
public class TestMD5 {

    @Test
    public void testMD5() {
        String passwd = "8515";
        String salt = "lab1107++";
        int hashCounter = 5;
        String s = new Md5Hash(passwd).toString();
        //System.out.println("不加盐");
        Assert.assertEquals(s, "c39e1a03859f9ee215bc49131d0caf33");


        String s_salt_hashCounter = new Md5Hash(passwd, salt, hashCounter).toString();
        //System.out.println("加盐加Hash");
        Assert.assertEquals(s_salt_hashCounter, "febed28f3be9cab9e7b85bbd8e7a9b8e");

        //选择算法
        String md5 = new SimpleHash("MD5", passwd, salt, hashCounter).toString();
        Assert.assertEquals(s_salt_hashCounter, "febed28f3be9cab9e7b85bbd8e7a9b8e");
        //System.out.println(md5);


    }

}
