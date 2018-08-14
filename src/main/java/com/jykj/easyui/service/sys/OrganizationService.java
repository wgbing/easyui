package com.jykj.easyui.service.sys;

import cn.hutool.core.date.DateUtil;
import com.jykj.easyui.common.R;
import com.jykj.easyui.dao.OrganizationDao;
import com.jykj.easyui.domain.Organization;
import com.jykj.easyui.vo.OrganizationVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * TODO: 用户组织机构业务逻辑处理层
 * @author wgbing
 * @date 2018/7/25 16:26
 */
@Service
@Transactional
public class OrganizationService {
    private static final Logger log = LoggerFactory.getLogger(OrganizationService.class);

    @Autowired
    private OrganizationDao organizationDao;

    public List<OrganizationVo> listOrg() {
        List<OrganizationVo> orgVoList = new ArrayList<>();
        List<Organization> orgList = this.organizationDao.findAll();
        if(orgList != null && !orgList.isEmpty()){
            for(Organization org:orgList){
                OrganizationVo orgVo = new OrganizationVo();
                orgVoList.add(orgVo);
                orgVo.setId(org.getId());
                if(org.getParent() != null){
                    orgVo.setParentId(org.getParent().getId());
                    orgVo.setIconCls("glyphicon-wrench");
                }else {
                    orgVo.setParentId(null);
                    orgVo.setIconCls("glyphicon-lock");
                }
                orgVo.setOrgName(org.getOrgName());
                orgVo.setShortName(org.getShortName());
                orgVo.setRemark(org.getRemark());
                orgVo.setType(org.getType());
                orgVo.setSortNo(org.getSortNo());
                orgVo.setEnable(org.getEnable());
                orgVo.setDeleted(org.getDeleted());
                orgVo.setCreateTime(DateUtil.formatDate(org.getCreateTime()));
                orgVo.setUpdateTime(DateUtil.formatDate(org.getUpdateTime()));
            }
        }
        return orgVoList;
    }

    public OrganizationVo findOne(Long orgId) {
        OrganizationVo orgVo = new OrganizationVo();
        if(orgId != null){
            Organization org = this.organizationDao.findOne(orgId);
            orgVo.setId(org.getId());
            if(org.getParent() != null){
                orgVo.setParentId(org.getParent().getId());
            }else {
                orgVo.setParentId(null);
            }
            orgVo.setOrgName(org.getOrgName());
            orgVo.setShortName(org.getShortName());
            orgVo.setRemark(org.getRemark());
            orgVo.setType(org.getType());
            orgVo.setSortNo(org.getSortNo());
            orgVo.setEnable(org.getEnable());
            orgVo.setDeleted(org.getDeleted());
            orgVo.setCreateTime(DateUtil.formatDate(org.getCreateTime()));
            orgVo.setUpdateTime(DateUtil.formatDate(org.getUpdateTime()));
        }

        return orgVo;
    }

    public R saveOrg(OrganizationVo orgVo) {
        if(null == orgVo){
            return R.failure("参数校验失败，请刷新页面重新提交！");
        }
        Organization org = new Organization();
        Date currDate = new Date();

        if(orgVo.getId() != null){//更新
            org = this.organizationDao.findOne(orgVo.getId());
            org.setUpdateTime(currDate);
        }else {//新增
            org.setDeleted(false);
            org.setCreateTime(currDate);
            org.setUpdateTime(currDate);
            if(orgVo.getParentId() != null){
                Organization parentOrg = this.organizationDao.findOne(orgVo.getParentId());
                org.setParent(parentOrg);
            }else {
                org.setParent(null);
            }
        }
        org.setOrgName(orgVo.getOrgName());
        org.setShortName(orgVo.getShortName());
        org.setRemark(orgVo.getRemark());
        org.setSortNo(orgVo.getSortNo());
        org.setEnable(orgVo.getEnable());
        org.setType(orgVo.getType());

        this.organizationDao.save(org);

        return R.success();
    }

    public R deleteOrg(Long orgId) {
        Organization rootOrg = this.organizationDao.findOne(orgId);
        Set<Organization> childrenOrg = rootOrg.getChildren();
        //todo:删除逻辑
        return R.success();
    }

}
