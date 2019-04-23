//进入公告详情页
function announceInfoClick(id){
    //弹框显示
    $("#couponList")[0].style="display:true";
    $("#couponList").show();
    $("#couponListModal").modal({
        show: true
    });
    loadAnnounceDetail(id);
};
function loadAnnounceDetail(id){
    //处理数据
    $.ajax({
        type: "GET",
        contentType: 'application/json',
        dataType: "json",
        url: "http://localhost:8088/announcementinfo/getByIdAnnouncementinfo?id=" + id,
        success: function (data){
            $("#announcementName").val(data.announcementName);
            $("#announcementInfo").val(data.announcementInfo);
            $("#createdBy").val(data.createdBy);
            debugger
            $("#createDate").val(formatTime(data.createDate));
        },
    });
};
// 加载公告信息
function loadAnnouncement(){
    //处理数据
    $.ajax({
        type: "GET",
        contentType: 'application/json',
        dataType: "json",
        url: "http://localhost:8088/announcementinfo/getall?flag=true&pageNum=0&pageSize=15",
        success: function (data){
            debugger
            if(data.list.length > 0) {
                $("#articles").html("");
                for (var i = 0; i < data.list.length; i++) {//默认显示第一页10个记录
                    var id = data.list[i].id == null ? "" : data.list[i].id;
                    var announcementName = data.list[i].announcementName == null ? "" : data.list[i].announcementName;
                    var html = $("#articles").html();
                    html = '<a onclick="announceInfoClick(@id)">'+
                        '<span class="label-bullet">&nbsp;</span>@announcementName'+
                        '</a>'
                    html = html.replace(/@id/g, id);
                    html = html.replace(/@announcementName/g, announcementName);
                    $("#articles").append(html);
                }
            }else{
                $("#articles").html("");
                var html = "<h5 style='text-align: center'>当前没有公告！</h5>";
                $("#articles").append(html);
            }
        },
    });
};
