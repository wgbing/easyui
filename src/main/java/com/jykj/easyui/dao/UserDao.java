package com.jykj.easyui.dao;


import com.jykj.easyui.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * TODO: 用户数据操作层
 * @author wgbing
 * @date 2018/7/12 下午9:59
 */
public interface UserDao extends JpaRepository<User, Long> {

    @Query(" select u from User u where u.deleted = false and u.loginName =?1 ")
    User findUserByUsername(String username);
}
