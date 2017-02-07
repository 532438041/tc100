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
var host = "http://localhost:8001/tc100";

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
    appcan.window.open({
        name:urlName,
        dataType:0,
        data:urlStr
    });
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
    $(".mui-icon-back").click(function(){
        appcan.button(".mui-icon-back", "btn-act", function() {  
           appcan.window.close(-1);  
        })
    })
    
    /**
     * 页面底部菜单点击事件 不包含首页
     */
    $("#myInfo").click(function(){
        openUrl('../user/info.html','myInfo');
    })
    $("#myInfo").click(function(){
        openUrl('../user/info.html','myInfo');
    })
    $("#tcIndex").click(function(){
        openUrl('../index.html','index');
    })
})