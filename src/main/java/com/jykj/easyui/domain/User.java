package com.jykj.easyui.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO: 用户实体
 * @author wgbing
 * @date 2018/7/10 16:22
 */
@Entity
@Table(name = "sys_user")
public class User {
    /* ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /* 登录名 */
    @Column(name = "login_name")
    private String loginName;
    /* 姓名 */
    @Column(name = "real_name")
    private String realName;
    /* 密码 */
    @Column(name = "password")
    private String password;
    /* 账户类型：1=管理员；2=普通用户*/
    @Column(name = "type")
    private Integer type;
    /* 性别 0=女；1=男 */
    @Column(name = "sex")
    private Integer sex;
    /* 手机号 */
    @Column(name = "mobile")
    private String mobile;
    /* 邮箱 */
    @Column(name = "email")
    private String email;
    /* 备注 */
    @Column(name = "remark")
    private String remark;
    /* 排序序号 */
    @Column(name = "sort_no")
    private Integer sortNo;
    /* 是否启用 true=启用；false=禁用 */
    @Column(name = "enable")
    private Boolean enable;
    /* 是否删除 true=已删除；false=未删除 */
    @Column(name = "deleted")
    private Boolean deleted;
    /* 创建时间 */
    @Column(name = "create_time")
    private Date createTime;
    /* 更新时间 */
    @Column(name = "update_time")
    private Date updateTime;
    /* 上次登陆时间 */
    @Column(name = "last_login_time")
    private Date lastLoginTime;
    /* 上次登陆所用ip */
    @Column(name = "last_login_ip")
    private String lastLoginIp;

    /* 所属组织 */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "organization_id")
    private Organization organization;
    /* 所属角色 */
    @ManyToMany
    @JoinTable(name = "sys_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    /* 拥有权限 */
    @ManyToMany
    @JoinTable(name = "sys_user_permission", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions = new HashSet<>();
    /* 当前用户的领导 */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_id")
    private User leader;
    /* 当前用户的下属人员 */
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "leader",cascade={CascadeType.MERGE},targetEntity = User.class)
    @OrderBy("id asc")
    private Set<User> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public Set<User> getChildren() {
        return children;
    }

    public void setChildren(Set<User> children) {
        this.children = children;
    }
}
