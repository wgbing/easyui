package com.jykj.easyui.web.sys;

import com.jykj.easyui.common.PageInfo;
import com.jykj.easyui.common.R;
import com.jykj.easyui.service.sys.RoleService;
import com.jykj.easyui.vo.RoleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * TODO: 角色管理控制层
 * @author wgbing
 * @date 2018/8/13 13:39
 */
@Controller
@RequestMapping("/sys/role")
public class RoleController {
    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    /**
     * TODO: 系统管理 | 角色管理页面
     * @author wgbing
     * @date 2018/8/13 下午13:23
     */
    @GetMapping("/index")
    public String roleIndex(){
        return "/base/role/list";
    }

    /**
     * TODO: 角色列表
     * @author wgbing
     * @date 2018/8/13 16:02
     * @param pageInfo 分页信息
     */
    @ResponseBody
    @GetMapping("/list")
    public Object list(PageInfo pageInfo){
        return roleService.listRole(pageInfo);
    }

    /**
     * TODO: 新增角色
     * @author wgbing
     * @date 2018/8/13 14:35
     */
    @GetMapping("/add")
    public String add(){
        return "/base/role/add";
    }

    /**
     * TODO: 保存更新角色
     * @author wgbing
     * @date 2018/8/14 10:58
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(RoleVo RoleVo){
        return this.roleService.saveRole(RoleVo);
    }

    /**
     * TODO: 编辑角色
     * @author wgbing
     * @date 2018/8/14 10:24
     * @param roleId 角色ID
     */
    @GetMapping("/edit")
    public String edit(@RequestParam(value = "roleId",required = true) Long roleId,
                       Map<String,Object> map){
        RoleVo roleVo = this.roleService.findOne(roleId);
        map.put("role",roleVo);
        return "/base/role/edit";
    }

    /**
     * TODO: 删除角色
     * @author wgbing
     * @date 2018/8/14 11:00
     * @param roleId 角色ID
     */
    @ResponseBody
    @GetMapping("/delete")
    public R delete(@RequestParam(value = "roleId",required = true) Long roleId){
        return roleService.deleteRole(roleId);
    }
}
