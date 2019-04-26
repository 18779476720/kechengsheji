//我的投递信息详细弹框
function scoreInfoClick(id){
    //弹框显示
    $("#scoreDetailDialogList")[0].style="display:true";
    $("#scoreDetailDialogList").show();
    $("#scoreReadonlyDetailModal").modal({
        show: true
    });
    loadScoreInfo(id);
};
function loadScoreInfo(id){
    //处理数据
    $.ajax({
        type: "GET",
        contentType: 'application/json',
        dataType: "json",
        url: "http://localhost:8088/scoreinfo/getByIdScoreinfo?id=" + id,
        success: function (data){
            debugger
            $("#example-f").val(data.scoreNum);
            $("#scoreDescription").val(data.scoreDescription);
            $("#createDate").val(formatTime(data.createDate));
            $(".br-widget").html("");
            for(var i = 1; i <= 5; i ++){
                var html = $(".br-widget").html();
                if(data.scoreNum == i){
                    html = '<a href="#" data-rating-value="@i" data-rating-text="@i" class="br-selected br-current" readlony><span></span></a>'
                }else if(data.scoreNum > i){
                    html = '<a href="#" data-rating-value="@i" data-rating-text="@i" class="br-selected" readlony><span></span></a>'
                }else{
                    html = '<a href="#" data-rating-value="@i" data-rating-text="@i" readlony><span></span></a>'
                }
                html = html.replace(/@i/g, i);
                $(".br-widget").append(html);
            }

        },
    });
}
