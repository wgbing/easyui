package com.jykj.easyui.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO: 角色实体
 * @author wgbing
 * @date 2018/7/10 16:32
 */
@Entity
@Table(name = "sys_role")
public class Role {
    /* ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /* 角色名称 */
    @Column(name = "name", nullable = false)
    private String name;
    /* 角色描述 */
    @Column(name = "description")
    private String description;
    /* 创建时间 */
    @Column (name = "createTime")
    private Date createTime;
    /* 更新时间 */
    @Column (name = "updateTime")
    private Date updateTime;
    /* 是否删除：true=已删除；false=未删除*/
    @Column (name = "deleted", nullable = false)
    private Boolean deleted;
    /* 角色对应的权限列表 */
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "sys_role_permission", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions = new HashSet<>();
    /* 角色对应的管理员列表 */
    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
