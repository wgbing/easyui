/**
 * 异步错误处理
 * @param xhr
 * @param textStatus
 * @param errorThrown
 */
function ajaxErrorHandler(xhr, textStatus, errorThrown) {
    // session失效
    if (xhr.status === 401) {
        toUrl("/login");
    } else if (xhr.status === 500) {
        toastr.error("HTTP Status: 500 服务器内部错误", "提示信息");
    } else {
        toastr.error("HTTP Status: " + xhr.status, "提示信息");
    }
}


