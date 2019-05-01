//我的投递信息详细弹框
function lookScoreMeDialog(id){
    //弹框显示
    $("#scoreMeDetailDialogList")[0].style="display:true";
    $("#scoreMeDetailDialogList").show();
    $("#scoreMeDetailModal").modal({
        show: true
    });
    loadScoreMeInfo(id);
};
function loadScoreMeInfo(id){
    //处理数据
    $.ajax({
        type: "GET",
        contentType: 'application/json',
        dataType: "json",
        url: "http://localhost:8088/scoreinfo/getScoreByRecruit?recruitId=" + id + "&pageNum="+ 0 +"&pageSize=" + 10,
        success: function (data){
            debugger
            $("#example-f").val(data.datas.list[0].scoreNum);
            $("#scoreDescription").val(data.datas.list[0].scoreDescription);
            $("#accountname").val(data.datas.list[0].accountname);
            $("#createDate1").val(formatTime(data.datas.list[0].createDate));
            $(".br-widget").html("");
            for(var i = 1; i <= 5; i ++){
                var html = $(".br-widget").html();
                if(data.datas.list[0].scoreNum == i){
                    html = '<a href="#" data-rating-value="@i" data-rating-text="@i" class="br-selected br-current" readlony><span></span></a>'
                }else if(data.datas.list[0].scoreNum > i){
                    html = '<a href="#" data-rating-value="@i" data-rating-text="@i" class="br-selected" readlony><span></span></a>'
                }else{
                    html = '<a href="#" data-rating-value="@i" data-rating-text="@i" readlony><span></span></a>'
                }
                html = html.replace(/@i/g, i);
                $(".br-widget").append(html);
            }
        },
    });
};
//格式化日期
function formatTime(date){
    var millis = new Date().getTime();
    var date1 = new Date(date);
    return date1.getFullYear() + '.' +
        ( ( date1.getMonth() + 1 ) < 10 ? '0' + ( date1.getMonth() + 1 ) : ( date1.getMonth() + 1 ) ) + '.' +
        ( date1.getDate() < 10 ? '0' + date1.getDate() : date1.getDate() );
};
