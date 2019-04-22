//进入公告详情页
function announceInfoClick(id){
    $("#couponListModal").modal({
        show: true
    });
//    $("#couponList").show = true;
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
}
