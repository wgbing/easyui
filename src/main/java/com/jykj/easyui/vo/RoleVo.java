package com.jykj.easyui.vo;

import java.util.Date;

public class RoleVo {
    /* ID */
    private Long id;
    /* 角色名称 */
    private String name;
    /* 角色描述 */
    private String description;
    /* 创建时间 */
    private String createTime;
    /* 更新时间 */
    private String updateTime;
    /* 是否删除：true=已删除；false=未删除*/
    private Boolean deleted;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
