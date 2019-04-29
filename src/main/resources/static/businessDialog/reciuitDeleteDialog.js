//商家删除发布的招聘信息弹窗
function deleteReciuitJob(id){
    debugger
    //弹框显示
    $("#reciuitDeleteList")[0].style="display:true";
    $("#reciuitDeleteList").show();
    $("#reciuitDeleteModal").modal({
        show: true
    });
    $("#deleteRecuirId").val(id);
};
function deleteReciuitThis(){
    var id = $("#deleteRecuirId").val();

    //处理数据
    $.ajax({
        type: "GET",
        contentType: 'application/json',
        dataType: "json",
        url: "http://localhost:8088/recruitinfo/deleteRecruitinfo?recruitId=" + id,
        success: function (data){
            debugger
            if(data.code == 000001){
                window.location.href="/public/util/jump?html_url=businessIndex/businessIndex";
                toastr.success("删除成功！");
            }else{
                window.location.href="/public/util/jump?html_url=businessIndex/businessIndex";
                toastr.success(data.message);
            }
        },
    });
}
