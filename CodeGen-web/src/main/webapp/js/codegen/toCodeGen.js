
var toCg = {};

//------------------------------
toCg.url = {};

/**获取所有table url*/
toCg.url.getTables = BasePath + "/codeGen/getTables";
/**提交生成文件url*/
toCg.url.submitGenerator = BasePath + "/codeGen/generate";

//------------------------------
toCg.search = {};

/**
 * 搜索框按键事件
 * @param {Object} event 事件对象
 */
toCg.search.searchTxt_OnKeyPress = function(event) {
	event = event || window.event;
	if(event.keyCode==13){ 
		toCg.search.searchBtn_OnClick();
		return false;
	} 
};

/**
 * 搜索按钮点击事件
 */
toCg.search.searchBtn_OnClick = function() {
	var keyword = $("#toCg_search_txt").val();
	toCg.table.getTables(keyword);
};

$(function() {
	//搜索按钮点击事件
	$("#toCg_search_btn").click(toCg.search.searchBtn_OnClick);
	//搜索框按键事件
	$("#toCg_search_txt").keypress(toCg.search.searchTxt_OnKeyPress);
});

//------------------------------
toCg.table = {};

/**
 * 获取所有table
 * @param {String} keyword 关键字
 */
toCg.table.getTables = function(keyword) {
	util.blockui.blockWithLoadingImg("#toCg_table_list_layer");
	$.ajax({
		url: toCg.url.getTables,
		type: "POST",
		cache: false,
		dataType: "json",
		data: {keyword: keyword},
		success: function(data) {
			util.blockui.unblock("#toCg_table_list_layer");
			if(!$.isArray(data)) {
				return;
			}
			toCg.table.renderTables(data);
		},
		error: function() {
			util.blockui.unblock("#toCg_table_list_layer");
			alert("服务器异常，请联系管理员");
		}
	});
};

/**展现table列表 模板*/
toCg.table.renderTableTemplate = 
		'<% var table = null; %>' +
		'<% var num = null; %>' +
		'<% for (var i = 0, len = list.length; i < len; i++) { %>' +
			'<% table = list[i]; %>' +
			'<% num = i + 1; %>' +
			'<tr tableName="<%=table.name %>">' +
				'<td><%=num %></td>' +
	 			'<td><input id="toCg_table_list_chk_<%=table.name %>" type="checkbox" name="tableCheckboxes" class="toCg_table_list_check_single" value="<%=table.name %>" /></td>' +
	 			'<td><%=table.name %></td>' +
	 			'<td><%=table.desc %></td>' +
	 		'</tr>' +
		'<% } %>';
/**展现table列表 模板 展现器*/
toCg.table.renderTableRender = template.compile(toCg.table.renderTableTemplate);

/**
 * 展现table列表
 * @param {Array} tableList table列表
 */
toCg.table.renderTables = function(tableList) {
	var html = toCg.table.renderTableRender({list: tableList});
	$("#toCg_table_list tbody").html(html);
	//绑定通用全选事件
	util.checkbox.bindCheckAllEvent("toCg_table_list_check_single", "toCg_table_list_check_all");
	//绑定行点击事件
	toCg.table.bindTableLineClick();
};

/**
 * 绑定行点击事件
 */
toCg.table.bindTableLineClick = function() {
	$("#toCg_table_list tr").click(function(event) {
		var target = event.target;
		if($(target).is("input[type='checkbox']")) {
			return;
		}
		var tableName = $(this).attr("tableName");
		$("#toCg_table_list_chk_" + tableName).click();
	});
};

//------------------------------
toCg.generate = {};

/**
 * 提交生成文件
 */
toCg.generate.submitGenerator = function() {
	util.blockui.blockWithLoadingImg("body");
	var $generateForm = $("#toCg_generate_form");
	$generateForm.attr("action", toCg.url.submitGenerator);
	$generateForm.ajaxSubmit({
		cache: false,
		dataType: "html",
		success: function(data) {
			util.blockui.unblock("body");
			alert(data);
		},
		error: function() {
			alert("服务器异常，请联系管理员");
		}
	});
};

$(function() {
	//提交生成文件
	$("#toCg_submit_btn").click(toCg.generate.submitGenerator);
});

//------------------------------

$(function() {
	//获取所有table
	toCg.table.getTables();
});
