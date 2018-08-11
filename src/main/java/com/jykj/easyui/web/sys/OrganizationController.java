package com.jykj.easyui.web.sys;

import com.jykj.easyui.common.R;
import com.jykj.easyui.service.sys.OrganizationService;
import com.jykj.easyui.vo.OrganizationVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * TODO: 用户组织机构控制层
 * @author wgbing
 * @date 2018/7/20 18:49
 */
@Controller
@RequestMapping("/sys/org")
public class OrganizationController {
    private static final Logger log = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private OrganizationService organizationService;

    /**
     * TODO: 系统管理 | 组织管理页面
     * @author wgbing
     * @date 2018/7/26 下午11:23
     */
    @GetMapping("/index")
    public String orgIndex(){
        return "/base/org/list";
    }

    /**
     * TODO: 组织列表
     * @author wgbing
     * @date 2018/7/26 下午11:24
     */
    @ResponseBody
    @GetMapping("/list")
    public List<OrganizationVo> list(){
        return organizationService.listOrg();
    }

    /**
     * TODO: 新增机构
     * @author wgbing
     * @date 2018/7/27 16:01
     * @param orgId 父级机构Id
     */
    @GetMapping("/add")
    public String add(@RequestParam(value = "orgId",required = false) Long orgId,
                      Map<String,Object> map){
        map.put("parentId",orgId);
        return "/base/org/add";
    }

    /**
     * TODO: 保存机构
     * @author wgbing
     * @date 2018/7/30 10:02
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(OrganizationVo organizationVo){
        return this.organizationService.saveOrg(organizationVo);
    }

    /**
     * TODO: 编辑机构
     * @author wgbing
     * @date 2018/7/27 16:01
     */
    @GetMapping("/edit")
    public String edit(@RequestParam(value = "orgId",required = true) Long orgId){
        OrganizationVo orgVo = organizationService.findOne(orgId);
        return "/base/org/edit";
    }

    /**
     * TODO: 停用机构
     * @author wgbing
     * @date 2018/7/30 14:56
     * @param orgId 机构Id
     */
    @ResponseBody
    @GetMapping("/disable")
    public R disable(@RequestParam(value = "orgId",required = true) Long orgId){
        return organizationService.disableOrg(orgId);
    }

    /**
     * TODO: 启用机构
     * @author wgbing
     * @date 2018/7/30 14:56
     * @param orgId 机构Id
     */
    @ResponseBody
    @GetMapping("/enable")
    public R enable(@RequestParam(value = "orgId",required = true) Long orgId){
        return organizationService.enableOrg(orgId);
    }

    /**
     * TODO: 删除机构
     * @author wgbing
     * @date 2018/7/30 14:56
     * @param orgId 机构Id
     */
    @ResponseBody
    @GetMapping("/delete")
    public R delete(@RequestParam(value = "orgId",required = true) Long orgId){
        return organizationService.deleteOrg(orgId);
    }

    @ResponseBody
    @GetMapping("/tree")
    public List<OrganizationVo> createOrgTree(@RequestParam(value = "orgId",required = false) Long parentId){
        return organizationService.createOrgTree(parentId);
    }
}
