//投递弹框
function judge(recruitId,accountId){
    //弹框显示
    $("#deliverDialogList")[0].style="display:true";
    $("#deliverDialogList").show();
    $("#scoreListModal").modal({
        show: true
    });
    $("#accountId").val(accountId);
    $("#recruitId").val(recruitId);
};
function judgeScore(){
    var accountId = $("#accountId").val();
    var recruitId = $("#recruitId").val();
    var scoreNum = $("#example-f").val();
    var scoreDescription = $("#scoreDescription").val();
    var score = {
        accountId: accountId,
        recruitId:recruitId,
        scoreNum:scoreNum,
        scoreDescription:scoreDescription
    }
    var scoreInfo = JSON.stringify(score);
    $.ajax({
        type: "POST",
        contentType: 'application/json',
        dataType: "json",
        url: "http://localhost:8088/scoreinfo/saveScore",
        data: scoreInfo,
        success: function (data){
            window.location.href="/public/util/jump?html_url=index/deliverinfo";
        }
    });
}
