package com.jykj.easyui.dao;

import com.jykj.easyui.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * TODO: 用户组织数据操作层
 * @author wgbing
 * @date 2018/7/12 下午11:17
 */
public interface OrganizationDao extends JpaRepository<Organization, Long> {

}
