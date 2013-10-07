<%@page language="java" contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>CodeGen</title>
<%@include file="/WEB-INF/views/common/commonCss.jsp" %>
<style type="text/css">
#toCg_main {width: 1000px; margin: 0 auto;}
#toCg_search {margin-top: 10px;}
#toCg_table_list_layer {height: 600px; overflow-y: auto; border: 1px solid #dddddd;}
#toCg_search_txt {width: 200px;}
</style>
</head>
<body>

<div id="toCg_main">
	<form>
		<div id="toCg_search">
			<input id="toCg_search_txt" type="text" />
			<input id="toCg_search_btn" type="button" value="搜索"/>
		</div>
		<div id="toCg_table_list_layer">
			<table id="toCg_table_list" class="common_grid" cellpadding="0" cellspacing="0">
				<thead>
					<th>序号</th>
					<th>
						<input id="toCg_table_list_check_all" type="checkbox" />
					</th>
					<th>表名</th>
					<th>注释</th>
				</thead>
				<tbody></tbody>
			</table>
		</div>
	</form>
	
</div>

<%@include file="/WEB-INF/views/common/commonJs.jsp" %>
<script type="text/javascript" src="${BasePath}/js/codegen/toCodeGen.js"></script>

</body>
</html>