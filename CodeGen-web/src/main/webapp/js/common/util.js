
var util = {};

//------------------------------
util.string = {};

/**
 * 对目标字符串进行格式化
 * @author huang.wq
 * @param {string} source 目标字符串
 * @param {Object|string...} opts 提供相应数据的对象或多个字符串
 * @remark
 * opts参数为“Object”时，替换目标字符串中的{#property name}部分。<br>
 * opts为“string...”时，替换目标字符串中的{#0}、{#1}...部分。	
 * @shortcut format
 * @returns {string} 格式化后的字符串
 * 例：
    (function(arg0, arg1){ 
		alert(formatString(arg0, arg1)); 
	})('{#0}-{#1}-{#2}',["2011年","5月","1日"]);
	(function(arg0, arg1){ 
		alert(formatString(arg0, arg1)); 
	})('{#year}-{#month}-{#day}', {year: 2011, month: 5, day: 1});   
 */
util.string.format = function(source, opts) {
    source = String(source);
    var data = Array.prototype.slice.call(arguments,1), toString = Object.prototype.toString;
    if(data.length){
	    data = data.length == 1 ? 
	    	/* ie 下 Object.prototype.toString.call(null) == '[object Object]' */
	    	(opts !== null && (/\[object Array\]|\[object Object\]/.test(toString.call(opts))) ? opts : data) 
	    	: data;
    	return source.replace(/\{#(.+?)\}/g, function (match, key){
	    	var replacer = data[key];
	    	// chrome 下 typeof /a/ == 'function'
	    	if('[object Function]' == toString.call(replacer)){
	    		replacer = replacer(key);
	    	}
	    	return ('undefined' == typeof replacer ? '' : replacer);
    	});
    }
    return source;
};

//------------------------------
util.blockui = {};

$.blockUI.defaults.overlayCSS.backgroundColor = '#AAA';
$.blockUI.defaults.overlayCSS.opacity = 0.1;

/**loading图片*/
util.blockui.loadingImg = '<img src="' + BasePath + '/css/images/loading.gif" width="32" height="32" border="0" /> Loading...';

/**
 * 用loading图片遮罩
 * @param {String} selector 选择器
 */
util.blockui.blockWithLoadingImg = function(selector) {
	$(selector).block({
		message: util.blockui.loadingImg
	});
};

/**
 * 去掉遮罩层
 * @param {String} selector 选择器
 */
util.blockui.unblock = function(selector) {
	$(selector).unblock();
}

//------------------------------
util.checkbox = {};

/**
 * 绑定通用全选事件
 * @param {String} checkBoxClass checkbox的class值
 * @param {String} checkAllBoxId 全选的checkbox的id
 */
util.checkbox.bindCheckAllEvent = function(checkBoxClass, checkAllBoxId) {
	$("#" + checkAllBoxId).off("click");
	$("." + checkBoxClass).off("click");
	//全选
	$("#" + checkAllBoxId).click(function() {
		//console.log("all click");
		if(this.checked) {
			util.checkbox.checkOpt("." + checkBoxClass, true);
		} else {
			util.checkbox.checkOpt("." + checkBoxClass, false);
		}
	});
	//单个checkbox
	$("." + checkBoxClass).click(function() {
		//console.log("single click");
		var checkBoxCount = $("." + checkBoxClass).length;
		var checkedCount = $("." + checkBoxClass + ":checked").length;
		if(this.checked) {
			if(checkBoxCount == checkedCount) {
				util.checkbox.checkOpt("#" + checkAllBoxId, true);
			}
		} else {
			if (checkBoxCount != checkedCount) {
				util.checkbox.checkOpt("#" + checkAllBoxId, false);
			}
		}
	});
};

/**
 * 选中/取消 checkbox
 * @param {String} selector 选择器
 * @param {Boolean} isCheck true为选中
 */
util.checkbox.checkOpt = function(selector, isCheck) {
	var $checkboxes = $(selector);
	var chb = null;
	for (var i = 0, len = $checkboxes.length; i < len; i++) {
		chb = $checkboxes[i];
		chb.checked = isCheck;
	}
};


//------------------------------