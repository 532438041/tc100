/**
 * @Title: common.js
 * @Package src/main/webapp/WEB-INF/static/js
 * @Description: 公共js
 * @author LiuTao
 * @date 2016年9月7日
 * @version V1.0
 */

/**
 * 全局参数
 */
// 全局域名
var hostIp = "http://121.42.181.222";
var host = "http://121.42.181.222:8090/tc100";

/**
 * 全局正则
 */
// 邮件格式
var emailPattern = /^([a-zA-Z0-9]+[_|\_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
// 手机格式
var mobilePattern = /^1[3|4|5|8|7][0-9]\d{8}$/;
// 手机或者邮箱
var mobile_or_email = /(^1[3|4|5|8|7][0-9]\d{8}$)|(^([a-zA-Z0-9]+[_|\_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$)/;

/**
 * 表单数据转json 格式{"param":{"userName":"liuTao"}}
 */
$.fn.serializeJson = function(baseParam) {
	var o = baseParam || {};
	var p = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	p.param = o;
	return JSON.stringify(p);
}

/**
 * 表单数据转pageJson 格式{pageNum : 1, pageSize : 20, "reqParam" :
 * {"userName":"liuTao"} }
 */
$.fn.serializePageJson = function(pageNum, pageSize, baseParam) {
	var o = baseParam || {};
	var p = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	p.pageNum = pageNum;
	p.pageSize = pageSize;
	p.reqParam = o;
	return JSON.stringify(p);
}

/**
 * 
 * @Title: serializePageJson
 * @Description: 查询分页参数 数据转pageJson 格式{pageNum : 1, pageSize : 20, "reqParam" :
 *               {"userName":"liuTao"} }
 * @param pageNum
 * @param pageSize
 * @param baseParam
 * @return any
 * @throws
 */
function serializePageJson(pageNum, pageSize, baseParam) {
	var p = {};
	p.pageNum = pageNum;
	p.pageSize = pageSize;
	p.reqParam = baseParam || {};
	return JSON.stringify(p);
}

/**
 * 页面跳转 
 * @param {Object} urlStr
 */
function openUrl(urlStr,urlName){
    // 将参数截取 放入到locStorage
    if (urlStr.indexOf("?") != -1) {   
      var str = urlStr.substr(urlStr.indexOf("?")+1);
      var strs = str.split("&");
      for(var i = 0; i < strs.length; i ++) {   
          var temp = strs[i].split("=");
          setVal(temp[0],temp[1]);
      } 
      urlStr = urlStr+"&t=" + new Date().getTime();  
    }else{
      urlStr = urlStr+"?t=" + new Date().getTime();  
    }
    urlName = urlName+new Date().getTime();
    appcan.window.open({
        name:urlName,
        dataType:0,
        data:urlStr
    });
}

// 页面跳转传参
function setVal(key,value){
    appcan.locStorage.setVal(key,value);
}

// 页面跳转取参
function getVal(key){
    var value = appcan.locStorage.getVal(key);
    return value;
}

/**
 * 获取ip所在地 
 * country:国家
 * province:省
 * city：市
 */
function getIpPlace(){
    $.getScript('http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js',function(){
        return remote_ip_info.city;
    });
}
$(function(){
    /**
     * 放回上一级 
     */
    $(".leftleft").click(function(){
        appcan.button(".leftleft", "btn-act", function() {  
           appcan.window.close(-1);  
        })
    })
    
    /**
     * 页面底部菜单点击事件 不包含首页
     */
    $("#myInfo").click(function(){
        if(window.location.href.indexOf("index") != -1){
            openUrl('user/info.html','myInfo');
        }else{
            openUrl('../user/info.html','myInfo');
        }
    })
    $("#myfabu").click(function(){
        if(window.location.href.indexOf("index") != -1){
            openUrl('user/moban_shengcheng.html?type=A1','moban_shengcheng');
        }else{
            openUrl('../user/moban_shengcheng.html?type=A1','moban_shengcheng');
        }
    })
    $("#tcIndex").click(function(){
        if(window.location.href.indexOf("index") != -1){
            openUrl('index.html','index');
        }else{
            openUrl('../index.html','index');
        }
    })
    
    // 下拉刷新页面
    window.uexOnload = function(type) {
        initBounce(mes);
    }
    function mes(){
        uexWindow.reload();
    }
    
})

function initBounce(funcTop){
    uexWindow.setBounce("1");
    if (!funcTop) {
        uexWindow.showBounceView("0", "rgba(255,255,255,0)", "0");
        /*uexWindow.showBounceView("1", "rgba(255,255,255,0)", "0");*/
        return;
    }
    var top = 0;
    uexWindow.onBounceStateChange = function(type, state){
    
        if (type == top && state == 2) { //顶部弹动
            funcTop();
            uexWindow.resetBounceView("0");
        }
        /*
        if (type == btm && state == 2) { //搴曢儴寮瑰姩
                    //funcBottom();
                    uexWindow.resetBounceView("1");
                }*/
        
        
    }
    if (funcTop) {
        uexWindow.setBounceParams('0', "{'pullToReloadText':'下拉刷新','releaseToReloadText':'释放刷新','loadingText':'正在刷新，请稍候'}");
        uexWindow.showBounceView(top, "rgba(255,255,255,0)", 1);
        uexWindow.notifyBounceEvent(top, 1);
    }
    /*
    if (funcBottom) {
            uexWindow.setBounceParams('1', "{'pullToReloadText':'鍔犺浇鏇村','releaseToReloadText':'鍔犺浇鏇村','loadingText':'鍔犺浇涓紝璇风◢鍊�}");
            uexWindow.showBounceView(btm, "rgba(255,255,255,0)", 1); //璁剧疆寮瑰姩浣嶇疆鍙婃晥鏋�[1:鏄剧ず鍐呭;0:涓嶆樉绀篯)
            uexWindow.notifyBounceEvent(btm, 1); //娉ㄥ唽鎺ユ敹寮瑰姩浜嬩欢([0:涓嶆帴鏀秓nBounceStateChange鏂规硶鍥炶皟;1:鎺ユ敹])
        }*/
    
    
}
