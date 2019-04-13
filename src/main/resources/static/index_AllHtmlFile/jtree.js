/*
***__J_tree 1.2 by Jincehn
纠正构建传参错误
增加变量支持树添加在任意容器内
增加父级对子集全选
纠正部分iframe显示问题
合并了一些函数封装到这个js里
1.2判断无子集的图标为单叶图标
*/
//所有图片的文件夹路径
var rteeImgPath="index_AllHtmlFile/";
var ctree_n=0;
var cuJTree;
//JTree类
function JTree(objectName){
	this.obj=objectName;
	this.icons={plus:rteeImgPath+"JTree_nolines_plus.gif",minus:rteeImgPath+"JTree_nolines_minus.gif",empty:rteeImgPath+"JTree_empty.gif",
				joinLine:rteeImgPath+"JTree_join.gif",joinBottom:rteeImgPath+"JTree_joinbottom.gif",line:rteeImgPath+"JTree_line.gif",
				plusLine:rteeImgPath+"JTree_plus.gif",minusLine:rteeImgPath+"JTree_minus.gif",plusBottom:rteeImgPath+"JTree_plusbottom.gif",
				minusBottom:rteeImgPath+"JTree_minusbottom.gif"};
	this.folder={fopen:rteeImgPath+"JTree_folderopen.gif",fclose:rteeImgPath+"JTree_folderclose.gif"};
	this.list=[];
	this.treeMap=[];
	this.treeMap2=[];
	this.hasBgImg=false;
	this.bgSrc=null;
	this.vjinfoshow=false;//显示注释
	this.treeStr="";
	//根是否可以双击改变状态
	this.nodedbc=true;
	//根是否要绑定事件
	this.nodehref=true;
	//是否使用延迟加载，延迟加载的话，节点默认都是关闭
	this.lazy=false;
	//是否使用点击节点改变节点背景
	this.alterbg=false;
	this.icon_w=25;
	this.icon_y=25;
	this.div_h=500;
	this.tree_n='Tree'+ctree_n+'-';	
	this.jiedian=0;
	this.haveCheck=true;
	this.callback=function(){}
};

//设置根的几个属性
JTree.prototype.setTree_n=function(Tree_n){
	this.tree_n=	'Tree'+Tree_n+'_';	
}
JTree.prototype.setdiv_h=function(div_h){
	this.div_h=div_h+'px';
	if(div_h==0){this.div_h='';}	
}
JTree.prototype.setIconR=function(icon_w,icon_y){
	this.icon_w=icon_w+'px';
	this.icon_y=icon_y+'px';
}
JTree.prototype.setNodedbc=function(bool){
	this.nodedbc=bool;
}
JTree.prototype.setNodehref=function(bool){
	this.nodehref=bool;
}
JTree.prototype.setLazy=function(bool){
	this.lazy=bool;
}
JTree.prototype.setTarget=function(Target){	//新增打开位置设置
	for(var i=0;i<this.jiedian;i++){
		this.list[i].target = Target;			
	}
}
JTree.prototype.canAlterbg=function(bool){
	this.alterbg=bool;
}
JTree.prototype.setpreviewmode=function(id){	//新增打开方式
	$('.maskbox').removeClass('showmask');	
	this.callback(id);
 
}

//节点
//参数 id，父id，显示字符，关闭时图片路径，打开时图片路径，href的路劲/调的js方法，目标，是否关闭（lazy=true时无效）
function sonnode(id,pid,value,src1,src2,url,target,zhushi,zhushiurl,isClose,previewmode,jiedian){
	this.id=id;
	this.pid=pid;
	this.value=value;
	this.previewmode=previewmode;
	this.jiedian=jiedian;
	//自定义图标的设置
	//没有一号图标，就使用默认的文件夹图标
	this.srcdoc=rteeImgPath+"JTree_document.png";
	if(!src1){
		this.src1=rteeImgPath+"JTree_folderclose.gif";
		this.src2=rteeImgPath+"JTree_folderopen.gif";
	}
	//有一号图标，看2号有没有，没有的话2号图标等于自定义图标1
	else if(src1){
		this.src1=src1;
		this.src2=src2?src2:src1;
	}
	this.zhushi=zhushi?zhushi:null;
	this.zhushiurl=zhushiurl?zhushiurl:null;;
	this.url=url?url:null;
	this.target=target?target:null;
	this.isClose=isClose?isClose:false;
};
//添加节点

JTree.prototype.add=function(id,pid,value,src1,src2,url,target,isClose){
	//alert(this.jiedian);
	zhushi=null;
	zhushiurl=null;
	this.list[this.jiedian] = new sonnode(id,pid,value,src1,src2,url,target,zhushi,zhushiurl,isClose);
	this.jiedian++;	
};
JTree.prototype.add_zhushi=function(id,pid,value,src1,src2,url,target,zhushi,zhushiurl,isClose){
	//alert(this.jiedian);
	this.list[this.jiedian] = new sonnode(id,pid,value,src1,src2,url,target,zhushi,zhushiurl,isClose);
	this.jiedian++;	
};
//转换成需要的数据类型
JTree.prototype.load=function(treedata){
	//alert(this.jiedian);
	var length=treedata.length;
	for(var i=0;i<length;i++){
		this.list[this.jiedian] = new sonnode(treedata[i].id,treedata[i].pid,treedata[i].value,treedata[i].src1,treedata[i].src2,treedata[i].url,treedata[i].target,treedata[i].zhushi,treedata[i].zhushiurl,treedata[i].isClose,treedata[i].previewmode,this.jiedian);
		this.jiedian++;	
	}
};
JTree.prototype.toTreeMap=function(){	
//alert(jiedian);
	//for(i in this.list){	
	for(var i=0;i<this.jiedian;i++){	
		var id=this.list[i].id;		
		var pid=this.list[i].pid;
		if(this.treeMap2[id]==null){this.treeMap2[id]=[];}
		//if(this.treeMap2[id][i]==null){	this.treeMap2[id][i]=[];}		
		this.treeMap2[id]=pid;		
		if(this.treeMap[pid]==null){
			this.treeMap[pid]=[];
		}
		if(this.treeMap[pid][i]==null){
			this.treeMap[pid][i]=[];
		}
		//this.treeMap[pid][id]=this.list[i];
		this.treeMap[pid][i][0]=this.list[i];
		this.treeMap[pid][i][1]=id;
		//document.getElementById("treemain").innerHTML='!['+pid+']['+i+'][0].id='+this.treeMap[pid][i][0].id+'; .pid='+this.treeMap[pid][i][0].pid+':'+this.treeMap[pid][i][0].value+'<br>~2['+id+']='+this.treeMap2[id]+'<br>'+document.getElementById("treemain").innerHTML;
	}
};
JTree.prototype.acturl=function(querydom){
	this.cururl=querydom.attr('data-href');
	var thistarget=querydom.attr('data-target');
	var exr='off';
	if(page.vjinfoshow){exr='on'}
	if(thistarget!='_blank'){
		$('#'+thistarget).attr('src',this.cururl+'?vjinfo='+ exr);
	}else{
		window.open(this.cururl);
	}
	
	// console.log($('#'+thistarget));
	// console.log(thistarget+':'+querydom.attr('data-href'));
	//querydom.attr('href',)
}
//造树
JTree.prototype.makeTreeHasLine=function(pid,leftHtml){
	var count=1;
	//console.log(this.treeMap);
	//console.log(this.treeMap2);
	var size=this.sonSize(this.treeMap[pid]);
//	for(id in this.treeMap[pid]){
	//var mainDivt=document.getElementById("treemain");	
	for(i in this.treeMap[pid]){	
		//当使用延迟加载后，treeMap中的单个节点会多一个marginLeft键
		//遇到时跳过
		//alert(this.treeMap[pid][i][1]+"::"+pid);
		if(this.lazy==true&&this.treeMap[pid][i][1]=="marginLeft"){
			continue;
		}
		//父节点Div，1.2.0版本要使用的对象，现在已经过时
		//father=document.getElementById("treeDiv"+pid);
		//有子元素
		hasSon=false;
		//是否时底部，当使用了延迟加载后，在不是最根节点的情况下，size要-1
		isBottom=(this.lazy&&pid!=0)?(count==size-1):(count==size);
		//判断是否有子节点
		
		if(this.treeMap[this.treeMap[pid][i][1]]!=null){
			hasSon=true;
		}
		
		//节点对象
		node=this.treeMap[pid][i][0];
		dkey=""+this.tree_n+"treeDiv"+this.treeMap[pid][i][1];
		ikey=""+this.tree_n+"tImg"+this.treeMap[pid][i][1];
		//图标的id
		ikeyT=""+this.tree_n+"tImgT"+this.treeMap[pid][i][1];
		marginLeft=leftHtml;
		useMinus=isBottom?this.icons.minusBottom:this.icons.minusLine;
		useLine=isBottom?this.icons.joinBottom:this.icons.joinLine;
		//控制按钮
		//mainDivt.innerHTML='!['+pid+']['+i+'][0].id='+this.treeMap[pid][i][0].id+'id'++'; .pid='+this.treeMap[pid][i][0].pid+':'+this.treeMap[pid][i][0].value+'<br>'+mainDivt.innerHTML;
		control=hasSon?"<img src='"+useMinus+"' id='"+ikey+"' onclick='"+this.obj+".alteJTree(&quot;"+i+"&quot;)' class='croImg'/>":"<img src='"+useLine+"'/>";
		src=node.src1;
		if(hasSon&&!(this.lazy||node.isClose)){
			src=node.src2;
		}
		if(!hasSon){src=node.srcdoc;}
		//图标
		icon="<img id='"+ikeyT+"' src='"+src+"' style='height:"+this.icon_y+";width:"+this.icon_w+"'/>";
		//内容与跳转目标
		target=node.target?"data-target='"+node.target+"'":"";
		dbclick="";
		if(this.nodedbc){
			dbclick="ondblclick='"+this.obj+".alteJTree(&quot;"+i+"&quot;)'";
		}
		rootHref="";
		//alert(id+':'+rootHref);
		if(this.nodehref&&hasSon){
			rootHref="href='"+node.url+"'";
		}
		var previewmode=' onclick="'+this.obj+'.acturl($(this));'+this.obj+'.setpreviewmode('+node.jiedian+')"';
		if(node.url){
			//node.url=node.url+'?vjinfo=on';
			title=(!hasSon)?"<span class='treeTitle'><a href='#' target='_self' data-href='"+node.url+"' "+target+previewmode+">"+node.value+"</a></span>"
				:"<span class='treeTitle' "+dbclick+"><a href='#' target='_self' data-href='"+node.url+"' "+target+previewmode+">"+node.value+"</a></span>";
				//"<span class='treeTitle' "+dbclick+"><a "+rootHref+" "+target+previewmode+">"+node.value+"</a></span>";
		}else{
			title=(!hasSon)?"<span class='treeTitle'>"+node.value+"</span>":"<span class='treeTitle' "+dbclick+">"+node.value+"</span>";
		}
		if(node.zhushi){
			title=title+"<span class='treeZhushi'><a href='"+node.zhushiurl+"' target='"+this.zsTarget+"'"+">"+node.zhushi+"</a></span>"
		}
		//增加注释
		
		//拼接
		str=marginLeft+control+icon+title+"<br>"+(hasSon?"<div id='"+dkey+"' style='display:block'>":"");
		//由于要使用文件夹格式，临时改成这样，默认全是关闭的文件夹图标
		//有子节点，默认是打开，所以换成打开的坐标图片
		if(hasSon&&(this.lazy||node.isClose)){
			//层隐藏，图标加号
			str=str.replace("block","none");
			str=str.replace("minus","plus");
		}	
		this.treeStr+=str;
		if(hasSon){
			useEmpty=isBottom?this.icons.empty:this.icons.line;
			marginLeft+="<img src='"+useEmpty+"'/>";
			if(this.lazy){
				this.treeMap[id]["marginLeft"]=marginLeft;
			}else{
				//alert("2:"+pid);
				this.makeTreeHasLine(this.treeMap[pid][i][1],marginLeft);
			}
			this.treeStr+="</div>";
		}
		count++;
	}
};
//子元素的数量
JTree.prototype.sonSize=function(map){
	var size=0;
	for(obj in map){
		size++;
	}
	return size;
};
//改变节点的显示与隐藏
JTree.prototype.alteJTree=function(i){
	divTarget=document.getElementById(""+this.tree_n+"treeDiv"+this.list[i].id);
	if(divTarget.style.display=="block"){
		this.closeNode(i);
	}else{
		this.openNode(i);
	}
};
//打开节点
JTree.prototype.openNode=function(i){
	var id=this.list[i].id;
	var divTarget=document.getElementById(""+this.tree_n+"treeDiv"+id);
	var imgTarget=document.getElementById(""+this.tree_n+"tImg"+id);
	var iconTarget=document.getElementById(""+this.tree_n+"tImgT"+id);
	//alert(""+this.tree_n+"tImg"+id);	
	divTarget.style.display="block";
	//不管是哪种类型的加减号，转换字符串就行了
	imgTarget.src=imgTarget.src.replace("plus","minus");
	//文件夹图标的打开
	
	iconTarget.src=this.list[i].src2;
		//alert(i+'--'+this.list[i].id+"--"+this.list[i].pid+"--"+this.list[i].value);
	if(this.lazy==true&&divTarget.innerHTML==''){
		this.treeStr="";
		this.makeTreeHasLine(id,this.treeMap[id]["marginLeft"]);
		divTarget.innerHTML+=this.treeStr;
		if(this.alterbg){
			alterBg();
		}
	}
};
function alterBg(){	  
	$('.treeTitle').unbind('click').click(function(){												
		$('.treebgGray').removeClass('treebgGray');
		$(this).addClass('treebgGray');
	}); 
}
//关闭节点
JTree.prototype.closeNode=function(i){
	var id=this.list[i].id;
	var divTarget=document.getElementById(""+this.tree_n+"treeDiv"+id);
	var imgTarget=document.getElementById(""+this.tree_n+"tImg"+id);
	var iconTarget=document.getElementById(""+this.tree_n+"tImgT"+id);
	divTarget.style.display="none";
	imgTarget.src=imgTarget.src.replace("minus","plus");
	//文件夹图标的关闭
	iconTarget.src=this.list[i].src1;
	
};
//打开所有节点
JTree.prototype.openTree=function(){
	for(id in this.treeMap){
		if(id==0){
			continue;
		}
		this.openNode(id);
	}
};
//关闭所有节点
JTree.prototype.closeTree=function(){
	for(id in this.treeMap){
		if(id==0){
			continue;
		}
		//在延迟加载的情况下，节点可能还未生成，自然不能被关闭
		if(this.lazy==true){
			var divTarget=document.getElementById("treeDiv"+id);
			if(divTarget==null)
				continue;
		}
		this.closeNode(id);
	}
};
//使用背景图片
JTree.prototype.useBgImg=function(src){
	this.bgSrc=src;
	this.hasBgImg=true;
};
//开始树的生成
JTree.prototype.doCheck1=function(id){
	var checkid='#'+this.tree_n+'cb';
	if($(checkid+id).attr('checked')==true){  
   		$('#'+this.tree_n+'treeDiv'+id+' input').attr('checked',true); 
		var sss=0;
       while(1){ 
	   sss++;
	   if (sss>15){break;}
            var pid=this.treeMap2[id];//r.list[id].pid;  
			//alert('treemap2'+id+":"+id+":"+pid);
            if(pid==0){  
                break;  
            }else{  
                $(checkid+pid).attr('checked',true);  
                id=pid;  
            }  			
       }		
    }else{  
       $('#'+this.tree_n+'treeDiv'+id+' input').attr('checked',false); 
	   //alert('#'+r.tree_n+'treeDiv'+id+' input');
    }  	
}

function doCheck(id){
	var checkid='#'+cuJTree.tree_n+'cb';
   if($(checkid+id).attr('checked')==true){  
   		$('#'+cuJTree.tree_n+'treeDiv'+id+' input').attr('checked',true); 
		var sss=0;
       while(1){ 
	   sss++;
	   if (sss>15){break;}
            var pid=cuJTree.treeMap2[id];//r.list[id].pid;  
			//alert('treemap2'+id+":"+id+":"+pid);
            if(pid==0){  
                break;  
            }else{  
                $(checkid+pid).attr('checked',true);  
                id=pid;  
            }  			
       }		
    }else{  
       $('#'+cuJTree.tree_n+'treeDiv'+id+' input').attr('checked',false); 
	   //alert('#'+r.tree_n+'treeDiv'+id+' input');
    }  
} 
JTree.prototype.startTree=function(mainDivname){
	var mainDiv=document.getElementById(mainDivname);
	mainDiv.innerHTML="";
	this.treeStr="<div id='"+this.tree_n+"treeDiv0' style='height:"+this.div_h+"'>";
	if(this.hasBgImg){
		var bgStr='<img src="'+this.bgSrc+'" width="100%" height="100%" style="position:absolute;z-index:-1;"/>';
		mainDiv.innerHTML=bgStr+mainDiv.innerHTML;
	}
	
	this.toTreeMap();
	this.makeTreeHasLine(0,"");
	this.treeStr+="</div>";
	
	mainDiv.innerHTML+=this.treeStr;

	if(this.alterbg){
		alterBg();
	}
	cuJTree=this;
	if(this.haveCheck)
	{		 	
		$('img[id^='+cuJTree.tree_n+'tImgT]').each(function(){													 
			var replacestr=cuJTree.tree_n+'tImgT';
			//alert(cuJTree.tree_n);						  
			var id=$(this).attr('id').replace(replacestr,'');  
			//alert("after:"+id);
			var value=id.replace('parent','');  
			if(value!='0'){  
				var cb="<input type='checkbox' name='ids' id='"+cuJTree.tree_n+"cb"+id+"' "+  
					"  onclick='"+cuJTree.obj+".doCheck1(&quot;"+id+"&quot;)' value='"+value+"' "+  
					"style='width:12px;height:12px;vertical-align:middle;' />";  
				$(this).before(cb);  
			}  
		}); 
	}
	ctree_n++;
	//增加选中事件
	$('#'+mainDivname+' .treeTitle a').click(function(){
		$('#'+mainDivname+' .treeTitle ').removeClass('act');
		$(this).parent().addClass('act');
	});
};
var rTree=JTree;