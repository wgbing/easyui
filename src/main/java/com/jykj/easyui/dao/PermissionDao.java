package com.jykj.easyui.dao;

import com.jykj.easyui.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * TODO: 用户权限数据操作层
 * @author wgbing
 * @date 2018/7/12 下午9:59
 */
public interface PermissionDao extends JpaRepository<Permission, Long> {

    @Query("select p.resKey from Permission p order by p.sortNo asc")
    List<String> findAllPermissionKeys();

    List<String> findPermissionKeysByUserId(Long id);
}
