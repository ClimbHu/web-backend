package com.atguigu.schedule.test;

import com.atguigu.schedule.util.MD5Util;
import org.testng.annotations.Test;

/**
 * @author: ClimbHu
 * @date: 2023年12月10日 2:15
 */
public class TestMD5Util {

    @Test
    public void testEncrypt() {
        String encrypt = MD5Util.encrypt("123456");
        System.out.println("encrypt = " + encrypt);

    }
}
