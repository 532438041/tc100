/**
 * @Title: common.js
 * @Package src/main/webapp/WEB-INF/static/js
 * @Description: 公共js
 * @author LiuTao
 * @date 2016年9月7日
 * @version V1.0
 */

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

// 分页插件
$.fn.initPagination = function(options) {
	var defaults = {
		totalCount : '',
		showPage : '5',
		limit : '20',
		callback : function() {
			return false;
		}
	};
	$.extend(defaults, options || {});
	if (defaults.totalCount == '') {
		$(this).empty();
		return false;
	} else if (Number(defaults.totalCount) <= 0) {
		$(this).empty();
		return false;
	}
	if (defaults.showPage == '') {
		defaults.showPage = '5';
	} else if (Number(defaults.showPage) <= 0)
		defaults.showPage = '5';
	if (defaults.limit == '') {
		defaults.limit = '20';
	} else if (Number(defaults.limit) <= 0)
		defaults.limit = '20';
	var totalCount = Number(defaults.totalCount), showPage = Number(defaults.showPage), limit = Number(defaults.limit), totalPage = Math.ceil(totalCount / limit);
	if (totalPage > 0 && totalCount > limit) {
		var html = [];
		html.push(' <ul class="pagination">');
		html.push(' <li class="previous"><a href="#">上一页</a></li>');
		html.push('<li class="disabled hidden"><a>...</a></li>');
		if (totalPage <= showPage) {
			for (var i = 1; i <= totalPage; i++) {
				if (i == 1)
					html.push(' <li class="active"><a href="#">' + i + '</a></li>');
				else
					html.push(' <li><a href="#">' + i + '</a></li>');
			}
		} else {
			for (var j = 1; j <= showPage; j++) {
				if (j == 1)
					html.push(' <li class="active"><a href="#">' + j + '</a></li>');
				else
					html.push(' <li><a href="#">' + j + '</a></li>');
			}
		}
		html.push('<li class="disabled hidden"><a>...</a></li>');
		html.push('<li class="next"><a href="#">下一页</a></li>');
		html.push('<li class="disabled"><a>共' + totalCount + '条 共' + totalPage + '页</a></li></ul>');
		$(this).html(html.join(''));
		if (totalPage > showPage)
			$(this).find('ul.pagination li.next').prev().removeClass('hidden');

		var pageObj = $(this).find('ul.pagination'), preObj = pageObj.find('li.previous'), currentObj = pageObj.find('li').not('.previous,.disabled,.next'), nextObj = pageObj.find('li.next');

		function loopPageElement(minPage, maxPage) {
			var tempObj = preObj.next();
			for (var i = minPage; i <= maxPage; i++) {
				if (minPage == 1 && (preObj.next().attr('class').indexOf('hidden')) < 0)
					preObj.next().addClass('hidden');
				else if (minPage > 1 && (preObj.next().attr('class').indexOf('hidden')) > 0)
					preObj.next().removeClass('hidden');
				if (maxPage == totalPage && (nextObj.prev().attr('class').indexOf('hidden')) < 0)
					nextObj.prev().addClass('hidden');
				else if (maxPage < totalPage && (nextObj.prev().attr('class').indexOf('hidden')) > 0)
					nextObj.prev().removeClass('hidden');
				var obj = tempObj.next().find('a');
				if (!isNaN(obj.html()))
					obj.html(i);
				tempObj = tempObj.next();
			}
		}

		function callBack(curr) {
			defaults.callback(curr, defaults.limit, totalCount);
		}

		currentObj.click(function(event) {
			event.preventDefault();
			var currPage = Number($(this).find('a').html()), activeObj = pageObj.find('li[class="active"]'), activePage = Number(activeObj.find('a').html());
			if (currPage == activePage)
				return false;
			if (totalPage > showPage) {
				var maxPage = currPage, minPage = 1;
				if (($(this).prev().attr('class')) && ($(this).prev().attr('class').indexOf('disabled')) >= 0) {
					minPage = currPage > 1 ? currPage - 1 : 1;
					maxPage = minPage + showPage - 1;
					loopPageElement(minPage, maxPage);
				} else if (($(this).next().attr('class')) && ($(this).next().attr('class').indexOf('disabled')) >= 0) {
					if (totalPage - currPage >= 1)
						maxPage = currPage + 1;
					else
						maxPage = totalPage;
					if (maxPage - showPage > 0)
						minPage = (maxPage - showPage) + 1;
					loopPageElement(minPage, maxPage)
				}
			}
			activeObj.removeClass('active');
			$.each(currentObj, function(index, thiz) {
				if ($(thiz).find('a').html() == currPage) {
					$(thiz).addClass('active');
					callBack(currPage);
				}
			});
		});
		preObj.click(function(event) {
			event.preventDefault();
			var activeObj = pageObj.find('li[class="active"]'), activePage = Number(activeObj.find('a').html());
			if (activePage <= 1)
				return false;
			if (totalPage > showPage) {
				var maxPage = activePage, minPage = 1;
				if ((activeObj.prev().prev().attr('class')) && (activeObj.prev().prev().attr('class').indexOf('disabled')) >= 0) {
					minPage = activePage - 1;
					if (minPage > 1)
						minPage = minPage - 1;
					maxPage = minPage + showPage - 1;
					loopPageElement(minPage, maxPage);
				}
			}
			$.each(currentObj, function(index, thiz) {
				if ($(thiz).find('a').html() == (activePage - 1)) {
					activeObj.removeClass('active');
					$(thiz).addClass('active');
					callBack(activePage - 1);
				}
			});
		});
		nextObj.click(function(event) {
			event.preventDefault();
			var activeObj = pageObj.find('li[class="active"]'), activePage = Number(activeObj.find('a').html());
			if (activePage >= totalPage)
				return false;
			if (totalPage > showPage) {
				var maxPage = activePage, minPage = 1;
				if ((activeObj.next().next().attr('class')) && (activeObj.next().next().attr('class').indexOf('disabled')) >= 0) {
					maxPage = activePage + 2;
					if (maxPage > totalPage)
						maxPage = totalPage;
					minPage = maxPage - showPage + 1;
					loopPageElement(minPage, maxPage);
				}
			}
			$.each(currentObj, function(index, thiz) {
				if ($(thiz).find('a').html() == (activePage + 1)) {
					activeObj.removeClass('active');
					$(thiz).addClass('active');
					callBack(activePage + 1);
				}
			});
		});
	} else {
		$(this).html('');
	}
};