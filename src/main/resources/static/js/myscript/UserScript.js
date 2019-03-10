$(document).ready(function () {
	$('.cancle').click(function () {
		window.location.href='/';	
	});
});

(function($){
    $.fn.serializeJson=function(){
        var serializeObj={};
        var array=this.serializeArray();
        var str=this.serialize();
        $(array).each(function(){
            if(serializeObj[this.name]){
                if($.isArray(serializeObj[this.name])){
                    serializeObj[this.name].push(this.value);
                }else{
                    serializeObj[this.name]=[serializeObj[this.name],this.value];
                }
            }else{
                serializeObj[this.name]=this.value;
            }
        });
        return serializeObj;
    };
})(jQuery);

function initTble() {
    $('#myTable').bootstrapTable({
        method: 'get',
        url: '../user',
        striped: true,
        cache: false,
        pagination: true,
        pageSize: 10,
        pageList: [10, 25, 50, 100],
        sidePagination: "client",
        search: true,
        uniqueId: "id",
        clickToSelect: true,
        columns: [{
            field: 'check',
            checkbox: true,
            formatter: function (value, row, index) {
                return false;
            }
        },
        {
            field: 'id',
            title: 'id',
            align: 'center'
        },
        {
            field: 'name',
            title: 'name',
            align: 'center'
        },
        {
            field: 'password',
            title: 'password',
            align: 'center'
        },
        {
            field: 'type',
            title: 'type',
            align: 'center'
        },
        {
            field: 'phone',
            title: 'phone',
            align: 'center'
        },
        {
            field: 'email',
            title: 'email',
            align: 'center'
        },
        {
            field: ' attribute1',
            title: ' attribute1',
            align: 'center'
        },
        {
            field: ' attribute2',
            title: ' attribute2',
            align: 'center'
        },
        {
            field: ' attribute3',
            title: ' attribute3',
            align: 'center'
        },
        {
            field: ' attribute4',
            title: ' attribute4',
            align: 'center'
        },
        {
            field: ' attribute5',
            title: ' attribute5',
            align: 'center'
        },
        {
            field: 'createdDate',
            title: 'createdDate',
            align: 'center'
        },
        {
            field: 'lastUpdateDate',
            title: 'lastUpdateDate',
            align: 'center'
        },
        {
            field: 'lastUpdateBy',
            title: 'lastUpdateBy',
            align: 'center'
        },
        {
            field: 'createdBy',
            title: 'createdBy',
            align: 'center'
        },
        {
            field: 'edit',
            title: '修改',
            align: 'center',
            formatter: function (value, row, index) {
                var a = '<button class="btn btn-default" onclick="edit(' + row.id + ')">修改</button>';
                return a;
            }
        }],
        onDblClickCell:function(field, value, row, $element){
            edit(row.id);
        }
    });
}

function edit(id) {
    var row=$('#myTable').bootstrapTable('getRowByUniqueId', id);
    $('#myAjaxType').val("put");
    $('#myModalLabel').val("修改");
        $('#id').val(row.id);
        $('#name').val(row.name);
        $('#password').val(row.password);
        $('#type').val(row.type);
        $('#phone').val(row.phone);
        $('#email').val(row.email);
        $('# attribute1').val(row. attribute1);
        $('# attribute2').val(row. attribute2);
        $('# attribute3').val(row. attribute3);
        $('# attribute4').val(row. attribute4);
        $('# attribute5').val(row. attribute5);
        $('#createdDate').val(row.createdDate);
        $('#lastUpdateDate').val(row.lastUpdateDate);
        $('#lastUpdateBy').val(row.lastUpdateBy);
        $('#createdBy').val(row.createdBy);
    $('#editModal').modal('show');
}

function create() {
    $('#myAjaxType').val("post");
    $('#myModalLabel').val("添加");
        $('#id').val('');
        $('#name').val('');
        $('#password').val('');
        $('#type').val('');
        $('#phone').val('');
        $('#email').val('');
        $('# attribute1').val('');
        $('# attribute2').val('');
        $('# attribute3').val('');
        $('# attribute4').val('');
        $('# attribute5').val('');
        $('#createdDate').val('');
        $('#lastUpdateDate').val('');
        $('#lastUpdateBy').val('');
        $('#createdBy').val('');
    $('#editModal').modal('show');
}

function save() {
    var json=$('#myForm').serializeJson();
    console.log(toJSONString(json));
    $.ajax({
        type:$('#myAjaxType').val(),
        url:"../user",
        contentType:'application/json',
        data:JSON.stringify(json),
        success:function(result){
            console.log(result);
            $('#editModal').modal('hide');
            $('#myTable').bootstrapTable('refresh');
        }
    });
}


function del() {
    var rows=$('#myTable').bootstrapTable('getSelections');
    var params="[";
    for(var i=0;i<rows.length;i++){
        params+=rows[i].id+",";
    }
    params=params.substring(0,params.length-1)+"]";
    console.log(params);
    $.ajax({
        type:'delete',
        url:"../user",
        contentType:'application/json',
        data:params,
        success:function(result){
            console.log(result);
            $('#myTable').bootstrapTable('refresh');
        }
    });
}

function toJSONString(jsonObj) {
    var jStr = "{";
    for(var item in jsonObj){
        jStr += "'"+item+"':'"+jsonObj[item]+"',";
    }
    return jStr.substring(0,jStr.length-1)+'}';
}