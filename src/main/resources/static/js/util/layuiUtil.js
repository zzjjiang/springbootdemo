/**
 *  可用于编辑和新增等页面
 * @param title 标题
 * @param urls 请求链接
 * @param pstUrl save链接
 * @param width 宽
 * @param height 高
 * @param grid grid对象
 */
function openWin(title, urls, pstUrl, width, height, grid) {
    //最外层 弹出框
    top.layui.layer.open({
        title: title,
        type: 2,
        content: urls,
        area: [width, height],
        btn: ['确定', '关闭'],
        yes: function (index, layero) {
            // 调用子页面的方法
            layero.find('iframe')[0].contentWindow.childSave(grid,pstUrl);
        },
        btn2: function (index, layero) {
            top.layui.layer.close(index);
            return false;
        }
    });
}

/**
 * 列表数据删除
 * @param urls 请求链接
 * @param grid table对象，通过table.render()获取
 * @param jquery jquery对象
 */
function deleteGridRow(urls, grid, jquery) {
    top.layui.layer.confirm('确认删除吗？', function (index) {
        jquery.post(urls, function (data) {
            if (data == "1") {
                grid.reload();
            } else {
                layer.msg("删除失败！", {
                    icon: 2, time: 1500
                });
            }
            top.layui.layer.close(index);
        });
    });
}

/**
 * 页面查询
 * @param grid table对象，通过table.render()获取
 * @param obj 查询参数对象
 */
function doSearch(grid, obj) {
    var bgtime = obj.bgtime;
    var edtime = obj.edtime;
    if (bgtime && edtime) {
        var compare = compareDatetime(bgtime,edtime);
        if (!compare) {
            layer.msg("开始日期应小于结束日期！", {
                icon: 5
            });
            return;
        }
    }
    grid.reload({
        page: {
            curr: 1
        },
        where: obj
    });
}

/**
 * 名称唯一判断
 * @param urls 跳转链接
 * @param modelId id-可根据具体业务修改   非必传参数
 * @param name 名称-可根据具体业务修改
 * @param jquery jquery对象
 * @returns {boolean} true表示唯一
 */
function nameUnique(urls, modelId, name, jquery) {
    var flag = false;
    jquery.ajax({
        type: "post",
        url: urls,
        dataType: 'json',
        async: false,
        data: {
            modelId: modelId,
            name: name
        }, success: function (data) {
            if (data == "1") {
                flag = true;
            } else if (data == "-1") {
                layer.msg("名称不可重复", {time: 1500, icon: 5, anim: 6});
                flag = false;
            } else if (data == "-2") {
                layer.msg("名称不可为空", {time: 1500, icon: 5, anim: 6});
                flag = false;
            } else {
                flag = false;
            }
        }, error: function () {
            layer.msg("操作异常,请稍后再试...", {time: 1500, icon: 2});
        }
    });
    return flag;
}

/**
 * 表单提交
 * @param url 请求链接
 * @param data 表单数据
 * @param jquery jquery对象
 * @param grid grid对象
 */
function save(url, data, jquery, grid) {
    var loading = parent.layer.msg('保存中...', {
        icon: 16,
        shade: 0.01,
        time: 0
    });
    jquery.ajax({
        type: "post",
        url: url,
        async: false,
        data: data,
        dataType: "json",
        success: function (res) {
            if (res == "1") {
                parent.layer.closeAll();
                grid.reload();
                parent.layer.msg("操作成功！", {
                    icon: 1,
                    time: 1500
                });
            } else {
                parent.layer.close(loading);
                layer.msg("操作失败,请检查数据!", {icon: 2, time: 1500});
            }
        },
        error: function () {
            parent.layer.close(loading);
            layer.msg("网络异常,请稍候！", {icon: 2, time: 1500});
        }
    });
}

/**
 *  用于EXCEL上传
 * @param urls 请求链接
 * @param grid grid对象
 */
function commonImport(urls, grid) {
    //最外层 弹出框
    top.layui.layer.open({
        title: "数据导入",
        type: 2,
        content: urls,
        area: ['520px', '350px'],
        btn: ['确定', '关闭'],
        yes: function (index, layero) {
            // 调用子页面的方法
            layero.find('iframe')[0].contentWindow.childSave(grid);
        },
        btn2: function (index, layero) {
            top.layui.layer.close(index);
            return false;
        }
    });
}

/**
 * 用于比较开始时间和结束时间
 * @param bgTime
 * @param edTime
 */
function compareDatetime(bgTime,edTime) {
    var beginTimestamp = new Date(Date.parse(bgTime.replace(/-/g,"/"))).getTime();
    var endTimestamp = new Date(Date.parse(edTime.replace(/-/g,"/"))).getTime();
    return beginTimestamp <= endTimestamp;
}