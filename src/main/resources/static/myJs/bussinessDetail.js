//进入企业详情页
function businessDetailInfo(id){
    //弹框显示
    $("#bussinessDetailList")[0].style="display:true";
    $("#bussinessDetailList").show();
    $("#bussinessDetailModal").modal({
        show: true
    });
    loadBusinessDetail(id);
};
function loadBusinessDetail(id){
    //处理数据
    $.ajax({
        type: "GET",
        contentType: 'application/json',
        dataType: "json",
        url: "http://localhost:8088/businessinfo/getByIdBusinessinfo?id=" + id,
        success: function (data){
            $("#businessName").val(data.businessName);
            $("#businessDescription").val(data.businessDescription);
        },
    });
}
