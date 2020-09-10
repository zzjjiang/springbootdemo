layui.use(['element', 'layer', 'jquery'], function () {
    var $ = layui.jquery, layer = layui.layer;
    $('#loginBt').click(function () {
        return submitForm();
    });

    function show_wait() {
        return layer.load(1, {shade: [0.5, '#000']});
    }

    function close_wait(index) {
        layer.close(index);
    }

    submitForm = function () {
        var username = $('#username').val();
        var password = $('#password').val();
        if (!username) {
            layer.msg('请输入用户名！', {icon: 5, time: 1000});
            return false;
        } else if (!password) {
            layer.msg('请输入密码！', {icon: 5, time: 1000});
            return false;
        } else {
            var i;
            $.ajax({
                type: "post",
                url: "/user/login",
                data: {
                    username: username,
                    password: password
                },
                beforeSend: function () {
                    i = show_wait();
                },
                success: function (result) {
                    if (result == "1") {
                        window.location.href = '/user/main';
                    } else if (result == "-2") {
                        layer.msg('用户名或密码错误', {icon: 5, time: 1000});
                    } else {
                        layer.msg('非法操作！', {icon: 5, time: 1000});
                    }
                    close_wait(i);
                },
                error: function () {
                    layer.msg("操作失败，请稍后再试！", {icon: 2, time: 1000});
                    close_wait(i);
                }
            });
            return false;
        }
    };

    enterkey = function (et) {
        var isSbm = false;
        if (et.keyCode) {
            if (et.keyCode == 13) {
                isSbm = true;
            }
        } else {
            if (et.which == 13) {
                isSbm = true;
            }
        }
        if (isSbm) {
            submitForm();
        }
    }

});

