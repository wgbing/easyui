package com.jykj.easyui.service.sys;

import cn.hutool.core.date.DateUtil;
import com.jykj.easyui.common.DataTableOutput;
import com.jykj.easyui.common.PageInfo;
import com.jykj.easyui.common.R;
import com.jykj.easyui.dao.RoleDao;
import com.jykj.easyui.domain.Role;
import com.jykj.easyui.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * TODO: 角色管理业务逻辑处理层
 * @author wgbing
 * @date 2018/8/13 13:40
 */
@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public DataTableOutput<RoleVo> listRole(PageInfo pageInfo) {
        return this.roleDao.listRole(pageInfo);
    }

    public R saveRole(RoleVo roleVo) {
        Role role = new Role();
        Date currDate = new Date();
        if(roleVo.getId() != null){//更新
            role = this.roleDao.findOne(roleVo.getId());
            role.setUpdateTime(currDate);
        }else {
            role.setCreateTime(currDate);
            role.setUpdateTime(currDate);
        }
        role.setName(roleVo.getName());
        role.setDescription(roleVo.getDescription());
        role.setDeleted(false);
        this.roleDao.save(role);

        return R.success();
    }

    public RoleVo findOne(Long roleId) {
        RoleVo roleVo = new RoleVo();
        Role role = this.roleDao.findOne(roleId);
        roleVo.setId(role.getId());
        roleVo.setName(role.getName());
        roleVo.setDescription(role.getDescription());
        roleVo.setUpdateTime(DateUtil.formatDate(role.getUpdateTime()));
        return roleVo;
    }

    public R deleteRole(Long roleId) {
        Role role = this.roleDao.findOne(roleId);
        //todo:删除逻辑

        return R.success();
    }
}
