//投递弹窗
function deliverJob(id){
    //弹框显示
    $("#deliveryDetailList")[0].style="display:true";
    $("#deliveryDetailList").show();
    $("#deliveryDetailModal").modal({
        show: true
    });
    $("#deliveryDialogId").val(id);
};
function deliveryThis(){
    var recruitId = $("#deliveryDialogId").val();
    var delivery = {
        recruitId: recruitId,
        deliverStatus: '已投递'
    }
    var deliverinfo = JSON.stringify(delivery);
    //处理数据
    $.ajax({
        type: "POST",
        contentType: 'application/json',
        dataType: "json",
        url: "http://localhost:8088/deliverinfo/insertDeliverinfo",
        data: deliverinfo,
        success: function (data){
            debugger
            if(data.code != "000001" ){
                toastr.error(data.message);
                return false;
            }
            toastr.success("投递成功！");
        }
    });
}
