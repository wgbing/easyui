package com.jykj.easyui.dao.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: 用户数据权限数据操作层
 * @author wgbing
 * @date 2018/7/12 下午11:12
 */
public class PermissionDaoImpl extends BaseDao {

    public List<String> findPermissionKeysByUserId(Long userId) {
        if(null == userId) {
            return new ArrayList<>();
        }
        String sql = "select res_key from ec_permission where id in (select permission_id from ec_user_permission where user_id = "+userId+" union select permission_id from ec_role_permission where role_id in (select role_id from ec_user_role where user_id = "+userId+")) order by sort asc";

        List<String> result = entityManager.createNativeQuery(sql).getResultList();

        return result;
    }

}
