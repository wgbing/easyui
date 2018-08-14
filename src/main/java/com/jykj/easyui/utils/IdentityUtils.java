package com.jykj.easyui.utils;

import com.jykj.easyui.config.security.CustomUserDetail;
import com.jykj.easyui.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 功能描述：获取登录身份信息
 * <p/>
 * 作者：wangjh
 * 日期：2016/08/20 09:55
 */
public class IdentityUtils {

    /**
     * 功能描述：获取登录用户名，如果没有通过登录认证返回null值
     * @author wangjh
     * @date 2016-08-20 10:00:29
     **/
    public static String getLoginName(){
        if(!isAuthenticated()){
            return null;
        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loginName = null;
        if(principal instanceof UserDetails){
            CustomUserDetail userDetails = (CustomUserDetail) principal;
            loginName = userDetails.getUsername();
        }
        else{
            loginName = (String)principal;
        }
        return loginName;
    }

    /**
     * 功能描述：判断是否认证通过
     * @author wangjh
     * @date 2016-08-20 10:01:16
     **/
    public static Boolean isAuthenticated(){
        return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }

    /**
     * 功能描述：获取登录用户信息，如果未登录返回null
     * @author wangjh
     * @date 2016-08-20 10:37:45
     **/
    public static User getUser(){
        if(!isAuthenticated()){
            return null;
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if(principal instanceof UserDetails){
            CustomUserDetail userDetails = (CustomUserDetail) principal;
            user = userDetails.getUser();
        }

        return user;
    }

    /**
     * 功能描述：设置登录用户信息
     * @author liuyf
     * @date 2016-09-07 10:52:37
     **/
    public static void setUser(User user){
        if(!isAuthenticated()){
            return;
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            CustomUserDetail userDetails = (CustomUserDetail) principal;
            userDetails.setUser(user);
        }
    }

    /**
     * 功能描述：获取登录用户权限信息，如果未登录返回null值
     * @author wangjh
     * @date 2016-08-20 10:44:21
     **/
    public static List<GrantedAuthority> getAuthorities(){
        if(!isAuthenticated()){
            return null;
        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<GrantedAuthority> authorities = null;
        if(principal instanceof UserDetails){
            CustomUserDetail userDetails = (CustomUserDetail) principal;
            Collection<GrantedAuthority> tmpColl = (Collection<GrantedAuthority>)userDetails.getAuthorities();
            if(null != tmpColl&&!tmpColl.isEmpty()){
                authorities = new ArrayList<>();
                for(GrantedAuthority ga:tmpColl){
                    authorities.add(ga);
                }
            }
        }

        return authorities;
    }

    /**
     * 判断当前登录用户是否包含某个权限
     * @author westinyang
     * @date 2018/3/29 10:20
     * @param authority
     * @return boolean
     * @throws
     */
    public static boolean hasAuthority(String authority) {
        List<GrantedAuthority> authList = IdentityUtils.getAuthorities();
        if (authList == null || authList.isEmpty()) {
            return false;
        }
        for (GrantedAuthority item : authList) {
            if (item.getAuthority().equals(authority)) {
                return true;
            }
        }
        return false;
    }

}
