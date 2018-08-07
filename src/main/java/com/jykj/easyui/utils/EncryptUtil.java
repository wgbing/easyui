package com.jykj.easyui.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

/**
 * TODO: 对数据进行加密操作
 * @author wgbing
 * @date 2018/7/13 9:53
 */
public class EncryptUtil {

    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    /**
     * TODO: 密码非可逆加密
     * @author wgbing
     * @date 2018/7/13 9:53
     */
    public static String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * TODO: 加密密码和非加密密码匹配
     * @author wgbing
     * @date 2018/7/13 9:54
     */
    public static Boolean match(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * TODO: 获取加密实体
     * @author wgbing
     * @date 2018/7/13 9:54
     */
    public static PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    /**
     * TODO: API账户密码加密算法（SHA256+Hex编码）
     * @author wgbing
     * @date 2018/7/13 9:54
     */
    public static String encodeAPI(String rawPassword){
        if(StringUtils.isEmpty(rawPassword)){
            return null;
        }
        return org.apache.commons.codec.digest.DigestUtils.sha256Hex(rawPassword);
    }

    /**
     * TODO: API账户密码匹配（SHA256+Hex编码）
     * @author wgbing
     * @date 2018/7/13 9:55
     */
    public static Boolean matchAPI(String rawPassword, String encodedPassword){
        if(StringUtils.isEmpty(rawPassword) || StringUtils.isEmpty(encodedPassword)){
            return false;
        }
        return encodedPassword.equalsIgnoreCase(rawPassword)||encodedPassword.equalsIgnoreCase(encodeAPI(rawPassword));
    }
}
