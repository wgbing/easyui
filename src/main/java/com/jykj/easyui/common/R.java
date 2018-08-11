package com.jykj.easyui.common;
/**
 * TODO: 页面响应
 * @author wgbing
 * @date 2018/7/30 10:43
 */
public class R {
    //提交后台后是否处理成功（例如Form表单提交）
    private Boolean success;
    //处理结果消息（例如错误消息）
    private String message;
    //处理完成后返回数据
    private Object data;

    public static R success() {
        R response = new R();
        response.setSuccess(true);
        response.setMessage("操作成功！");
        return response;
    }

    public static R success(String message) {
        R response = new R();
        response.setSuccess(true);
        response.setMessage(message);
        return response;
    }

    public static R success(Object data) {
        R response = new R();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static R failure() {
        R response = new R();
        response.setSuccess(false);
        response.setMessage("操作失败！");
        return response;
    }

    public static R failure(String message) {
        R response = new R();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }

    public static R failure(Object data) {
        R response = new R();
        response.setSuccess(false);
        response.setData(data);
        return response;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
