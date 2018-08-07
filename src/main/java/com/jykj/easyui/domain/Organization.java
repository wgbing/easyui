package com.jykj.easyui.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * TODO: 组织机构实体
 * @author wgbing
 * @date 2018/7/10 16:40
 */
@Entity
@Table(name = "sys_organization")
public class Organization {
    /* ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /* 父级组织 */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Organization parent;
    /* 组织名称 */
    @Column(name = "name")
    private String name;
    /* 组织简称 */
    @Column(name = "short_name")
    private String shortName;
    /* 组织所在行政区域代码 */
    @Column(name = "area_code")
    private String areaCode;
    /* 备注 */
    @Column(name = "remark")
    private String remark;
    /* 是否是虚拟组织 true=是；false=不是 */
    @Column(name = "is_fiction")
    private Boolean isFiction;
    /* 机构类型 */
    @Column(name = "type")
    private Integer type;
    /* 子级组织列表 */
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent",cascade={CascadeType.MERGE},targetEntity = Organization.class)
    @OrderBy("id asc")
    private Set<Organization> children;
    /* 创建时间 */
    @Column(name = "create_time")
    private Date createTime;
    /* 更新时间 */
    @Column(name = "update_time")
    private Date updateTime;
    /* 是否已删除：true=未删除；false=已删除 */
    @Column(name = "deleted")
    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organization getParent() {
        return parent;
    }

    public void setParent(Organization parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getFiction() {
        return isFiction;
    }

    public void setFiction(Boolean fiction) {
        isFiction = fiction;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Set<Organization> getChildren() {
        return children;
    }

    public void setChildren(Set<Organization> children) {
        this.children = children;
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
}
