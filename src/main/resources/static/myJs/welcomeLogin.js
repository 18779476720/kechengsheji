function welcomeLogin() {
    //处理数据
    $.ajax({
        type: "GET",
        contentType: 'application/json',
        dataType: "json",
        url: "http://localhost:8088/account/welcomeLogin",
        success: function (data) {
            if (data.datas == null) {
                toastr.error("登录超时，请重新登录！");
                setTimeout(function () {
                    window.location.href = "http://localhost:8088/welcome";
                }, 2000);
            }
            if (data.code == 000001 && data.datas != null) {
                $("#welcomeSpan").html("");
                var html = $("#welcomeSpan").html();
                html = '<button class="btn btn-primary">欢迎@welcomeName</button>'
                html = html.replace(/@welcomeName/g, data.datas.accountname);
                $("#welcomeSpan").append(html);
                return false;
            }
        }
    });
};

function logoutClick() {
    window.location.href = "/welcome";
};

function editPersonInfoClick() {
    //查询后台看当前用户类型是学生还是商家
    $.ajax({
        type: "GET",
        contentType: 'application/json',
        dataType: "json",
        url: "http://localhost:8088/account/welcomeLogin",
        success: function (data) {
            debugger
            if (data.code == 000001 && data.datas != null) {
                if(data.datas.role == 1){
                    window.location.href = "/public/util/jump?html_url=register&loadData=true";
                }else{
                    window.location.href = "/public/util/jump?html_url=businessRegister&loadData=true";
                }
            }
        }
    });
};




