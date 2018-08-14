package com.jykj.easyui.common;

import java.util.List;
import java.util.Map;

public class DataTableOutput<T> {
    private Integer status;
    private Integer draw;

    private Integer total;
    /**
     * DataTable中需要显示的数据
     */
    private List<T> rows;

    /**
     * 可选，定义一个错误来描述服务器出了问题后的提示
     */
    private String error;

    private Map<String, Object> addInfo;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Map<String, Object> getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(Map<String, Object> addInfo) {
        this.addInfo = addInfo;
    }
}
