(function($) {
    //用户id
    appcan.locStorage.setVal("userId", "1");
    
    //获取ip所在的
    $.getScript('http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js',function(){
        $("#ipcity").html(remote_ip_info.city);
    });
    //消息个数
    $.ajax({
        type:"get",  
        url:host+"/getMsgCount.json?userId="+appcan.locStorage.getVal("userId"),
        dataType:"json",
        success:function(dataResult) {
            $(".xiaoxi").html(dataResult.data);
        }
    })
    
    //首页轮播
    var baseParam1 = {'actType':'A1'}
    var param1 = serializePageJson(1,5,baseParam1);
    $.ajax({
        type:"post",
        url:host+"/getActiveList.json",
        data:param1,
        dataType:"json",
        contentType: "application/json",
        success : function(dataResult) {
            var dataList = dataResult.data.dataList;
            var imgStr = "";
            var imgBtnStr = "";
            for(var i=0;i<dataList.length;i++){
                imgStr += '<div class="mui-slider-item mui-slider-item-duplicate"><a href="javascript:;" onclick="openUrl(\'page/info.html?actId='+dataList[i].id+'\',\'actinfo\');"><img src="img/lunbo.png" /></a></div>';
                if(i==0){
                imgBtnStr +='<div class="mui-indicator mui-active"></div>';
                }else{
                imgBtnStr +='<div class="mui-indicator"></div>';
                }
            }
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
    })
    //同城购
    var baseParam2 = {'actType':'B2'}
    var param2 = serializePageJson(1,5,baseParam2);
    $.ajax({
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
                actStr += '<img class="mui-media-object mui-pull-left" src="'+dataList[i].main_pic+'">';
                actStr += '<div class="mui-media-body">'+dataList[i].actName;
                actStr += '<p class="mui-ellipsis">'+dataList[i].summary+'...</p>';
                actStr += '<i>'+dataList[i].createTime+'</i>';
                actStr += '</div></a></li>';
            }
            $("#activeB2").html(actStr);
        }
    })
    //同城搜
    $.ajax({
        type:"post",
        url:host+"/getMsgList.json",
        data:serializePageJson(1,5),
        dataType:"json",
        contentType: "application/json",
        success : function(dataResult) {
            var dataList = dataResult.data.dataList;
            var magStr = "";
            for(var i=0;i<dataList.length;i++){
                magStr+='<li class="mui-table-view-cell mui-media">';
                magStr+='<a href="javascript:;" onclick="openUrl(\'page/info_msg.html?msgId='+dataList[i].id+'\',\'actinfomsg\');">';
                magStr+='<img class="mui-media-object mui-pull-left" src="img/img_2.png">';
                magStr+='<div class="mui-media-body">'+dataList[i].title;
                magStr+='<p class="mui-ellipsis">'+dataList[i].remark+'......</p>';
                magStr+='<i>'+dataList[i].createTime+'</i>';
                magStr+='</div></a></li>';
            }
            $("#messageList").html(magStr);
        }
    })
})($);
