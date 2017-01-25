(function($) {
    //用户id
    $.cookie('userId', '1', { expires: 7, path: '/' });
    //消息个数
    /*
    $.ajax({
            type:"post",
            async:false,       
            url:host+"/getMsgCount.json",
            data:"",
            dataType:"json",
            contentType: "application/json",
            success : function(dataResult) {
                console.log(dataResult);
            }
        })*/
    
    //首页轮播
    var baseParam1 = {'actType':'A1'}
    var param1 = $.fn.serializePageJson(1,5,baseParam1);
    $.ajax({
        type:"post",
        async:false,       
        url:host+"/getActiveList.json",
        data:param1,
        dataType:"json",
        contentType: "application/json",
        success : function(dataResult) {
            var dataList = dataResult.data.dataList;
            var imgStr = "";
            for(var i=0;i<dataList.length;i++){
                imgStr += "<li><img src='img/lunbo.png' target='"+dataList[i].actName+"'></li>"
            }
            $("#slideBoxIndex #lunbobd").html(imgStr);
            console.log(imgStr);
            jQuery(".slideBoxIndex").slide({mainCell:".bd ul",autoPlay:true});
        }
    })
    //同城购
    var baseParam2 = {'actType':'B2'}
    var param2 = $.fn.serializePageJson(1,5,baseParam2);
    $.ajax({
        type:"post",
        async:false,       
        url:host+"/getActiveList.json",
        data:param2,
        dataType:"json",
        contentType: "application/json",
        success : function(dataResult) {
            var dataList = dataResult.data.dataList;
            var actStr = "";
            for(var i=0;i<dataList.length;i++){
                actStr += '<li class="mui-table-view-cell mui-media">';
                actStr += '<a href="javascript:;">';
                actStr += '<img class="mui-media-object mui-pull-left" src="'+dataList[i].main_pic+'">';
                actStr += '<div class="mui-media-body">'+dataList[i].actName;
                actStr += '<p class="mui-ellipsis">'+dataList[i].summary+'...</p>';
                actStr += '<i>'+dataList[i].createTime+'</i>';
                actStr += '</div></a></li>';
            }
            console.log(actStr);
            $("#activeB2").html(actStr);
        }
    })
    //同城搜
    $.ajax({
        type:"post",
        async:false,       
        url:host+"/getMsgList.json",
        data:$.fn.serializePageJson(1,5),
        dataType:"json",
        contentType: "application/json",
        success : function(dataResult) {
            var dataList = dataResult.data.dataList;
            var magStr = "";
            for(var i=0;i<dataList.length;i++){
                magStr+='<li class="mui-table-view-cell mui-media">';
                magStr+='<a href="javascript:;">';
                magStr+='<img class="mui-media-object mui-pull-left" src="img/img_2.png">';
                magStr+='<div class="mui-media-body">'+dataList[i].title;
                magStr+='<p class="mui-ellipsis">'+dataList[i].remark+'......</p>';
                magStr+='<i>'+dataList[i].createTime+'</i>';
                magStr+='</div></a></li>';
            }
            $(".same_city_search #messageList").html(magStr);
            console.log(magStr);
        }
    })
})($);