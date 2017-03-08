(function($) {
    //用户id
    var userId = appcan.locStorage.getVal("userId");
    var userCardId = appcan.locStorage.getVal("userCardId");
    //获取ip所在的
    
    //地位地址存到缓存 若缓存数据为空 则现取 否则取缓存数据
    var ipcity = appcan.locStorage.getVal("ipcity");
    if(!!ipcity){
        setTimeout(function(){
             $("#ipcity").html(ipcity);
        }, 500);
    }else{
        $.getScript('http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js',function(){
            $("#ipcity").html(remote_ip_info.city);
            appcan.locStorage.setVal("ipcity", remote_ip_info.city);
        });
    }
    
    //消息个数 显示成... 不显示个数
    
    /*
    if(userId !=null && userId !=""){
            appcan.ajax({
                type:"get",  
                url:host+"/getMsgCount.json?userId="+userId+"&state=1",
                dataType:"json",
                success:function(dataResult) {
                    $(".xiaoxi").html(dataResult.data);
                }
            })
        }*/
    
    
    
    //首页轮播
    var topPageSize = 5;
    appcan.ajax({
        type:"post",
        async:false,       
        url:host+"/getSysPByKey.json?pKey=index_top_num",
        data:"",
        dataType:"json",
        contentType: "application/json",
        success : function(dataResult) {
            topPageSize = dataResult.data.pValue;
        }
    }) 
    var baseParam1 = {'actType':'A1','addName':appcan.locStorage.getVal("ipcity")}
    var param1 = serializePageJson(1,topPageSize,baseParam1);
    appcan.ajax({
        type:"post",
        url:host+"/getActiveList.json",
        data:param1,
        dataType:"json",
        contentType: "application/json",
        success : function(dataResult) {
            if(dataResult!=null && dataResult.data.dataList.length>0){
                var dataList = dataResult.data.dataList;
                var imgStr = "";
                var imgBtnStr = "";
                imgStr += '<div class="mui-slider-item mui-slider-item-duplicate"><a href="javascript:;" onclick="openUrl(\'page/info.html?actId='+dataList[dataList.length-1].id+'\',\'actinfo\');"><img src="'+hostIp+dataList[dataList.length-1].mainPic+'" /></a></div>';
                for(var i=0;i<dataList.length;i++){
                    imgStr += '<div class="mui-slider-item"><a href="javascript:;" onclick="openUrl(\'page/info.html?actId='+dataList[i].id+'\',\'actinfo\');"><img src="'+hostIp+dataList[i].mainPic+'" /></a></div>';
                    if(i==0){
                        imgBtnStr +='<div class="mui-indicator mui-active"></div>';
                    }else{
                        imgBtnStr +='<div class="mui-indicator"></div>';
                    }
                }
                imgStr += '<div class="mui-slider-item mui-slider-item-duplicate"><a href="javascript:;" onclick="openUrl(\'page/info.html?actId='+dataList[0].id+'\',\'actinfo\');"><img src="'+hostIp+dataList[0].mainPic+'" /></a></div>';
                $("#slideBoxIndex").html(imgStr);
                $("#yuandian").html(imgBtnStr);
                var lunbo = mui('.mui-slider');
                lunbo.slider({
                    interval:2000//自动轮播周期，若为0则不自动播放，默认为0；
                });
                $("#yuandian div").click(function(){
                    lunbo.slider().gotoItem($(this).index());//跳转到第index张图片，index从0开始；
                })
            }
        }
    })
    //同城购
    var tcgPageSize = 5;
    appcan.ajax({
        type:"post",
        async:false,       
        url:host+"/getSysPByKey.json?pKey=index_tcg_num",
        data:"",
        dataType:"json",
        contentType: "application/json",
        success : function(dataResult) {
            tcgPageSize = dataResult.data.pValue;
        }
    })
    var baseParam2 = {'actType':'B2','addName':appcan.locStorage.getVal("ipcity")}
    var param2 = serializePageJson(1,tcgPageSize,baseParam2);
    appcan.ajax({
        type:"post",
        url:host+"/getActiveList.json",
        data:param2,
        dataType:"json",
        contentType: "application/json",
        success : function(dataResult) {
            var dataList = dataResult.data.dataList;
            var actStr = "";
            for(var i=0;i<dataList.length;i++){
                actStr += '<li class="mui-table-view-cell mui-media">';
                actStr += '<a href="javascript:;" onclick="openUrl(\'page/info.html?actId='+dataList[i].id+'\',\'actinfo\');">';
                actStr += '<img class="mui-media-object mui-pull-left" src="'+hostIp+dataList[i].mainPic+'">';
                actStr += '<div class="mui-media-body">'+dataList[i].actName;
                actStr += '<p class="mui-ellipsis">'+dataList[i].summary+'...</p>';
                actStr += '<i>'+dataList[i].createTime+'</i>';
                actStr += '</div></a></li>';
            }
            $("#activeB2").html(actStr);
        }
    })
    //同城搜
    var tcsPageSize = 5;
    appcan.ajax({
        type:"post",
        async:false,       
        url:host+"/getSysPByKey.json?pKey=index_tcs_num",
        data:"",
        dataType:"json",
        contentType: "application/json",
        success : function(dataResult) {
            tcsPageSize = dataResult.data.pValue;
        }
    })
    var baseParam3 = {'addName':appcan.locStorage.getVal("ipcity")}
    var param3 = serializePageJson(1,tcsPageSize,baseParam3);
    appcan.ajax({
        type:"post",
        url:host+"/getMsgList.json",
        data:param3,
        dataType:"json",
        contentType: "application/json",
        success : function(dataResult) {
            var dataList = dataResult.data.dataList;
            var magStr = "";
            for(var i=0;i<dataList.length;i++){
                magStr+='<li class="mui-table-view-cell mui-media">';
                magStr+='<a href="javascript:;" onclick="openUrl(\'page/info_msg.html?msgId='+dataList[i].id+'\',\'actinfomsg\');">';
                magStr+='<img class="mui-media-object mui-pull-left" src="'+hostIp+dataList[i].picUrl+'">';
                magStr+='<div class="mui-media-body">'+dataList[i].title;
                magStr+='<p class="mui-ellipsis">'+dataList[i].remark+'......</p>';
                magStr+='<i>'+dataList[i].createTime+'</i>';
                magStr+='</div></a></li>';
            }
            $("#messageList").html(magStr);
        }
    })
})($);
