package com.jykj.easyui.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO: 权限实体
 * @author wgbing
 * @date 2018/7/10 16:34
 */
@Entity
@Table(name = "sys_permission")
public class Permission {
    /* ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /* 权限名称 */
    @Column(name = "name", nullable = false)
    private String name;
    /* 父级权限ID */
    @Column(name = "parent_id")
    private Long parentId; //父类Id
    /* 父级权限名称 */
    @Column(name = "parent_name")
    private String parentName;
    /* 权限KEY值：这个权限KEY是唯一的，新增时要注意 */
    @Column(name = "res_key", nullable = false)
    private String resKey;
    /* 权限对应的请求资源URL（暂时不用）：例如：/videoType/query　　不需要项目名和http://xxx:8080 */
    @Column(name = "res_url")
    private String resUrl;
    /* 权限级别 位于权限树种的几级节点，例如根节点就是1级 */
    @Column(name = "level")
    private Integer level;
    /* 权限类型（暂时仅用菜单分类） 1=菜单  2=按扭．．在spring security安全权限中，涉及精确到按扭控制*/
    @Column(name = "type")
    private Integer type;
    /* 权限描述 */
    @Column(name = "description")
    private String description;
    /* 权限可见性（是否对管理员可见， 暂时不用）*/
    @Column(name = "visible", nullable = false)
    private boolean visible;
    /* 排序 */
    @Column(name = "sort_no")
    private Integer sortNo;
    /* 权限对应角色列表 */
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();
    /* 权限对应管理员列表 */
    @ManyToMany(mappedBy = "permissions")
    private Set<User> users = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getResKey() {
        return resKey;
    }

    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
