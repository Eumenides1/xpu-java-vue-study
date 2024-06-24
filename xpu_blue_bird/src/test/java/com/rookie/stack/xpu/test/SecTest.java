package com.rookie.stack.xpu.test;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

/**
 * @author eumenides
 * @description
 * @date 2024/6/24
 */
public class SecTest {

    public static void main(String[] args) {
        String content = "xpujavavuestudy";
        // 获取密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        // 构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
        // 加密
        byte[] encrypt = aes.encrypt(content);
        // 将加密后的字节数组转换为16进制字符串
        String encryptHex = aes.encryptHex(content);
        System.out.println("加密后的内容（16进制表示）: " + encryptHex);
        // 解密
        byte[] decrypt = aes.decrypt(encrypt);
        // 解密为字符串
        String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println("解密后的内容: " + decryptStr);
    }
}
