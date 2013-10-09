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
.toCg_input_txt {width: 800px; height: 25px; font-size: 14px;}
</style>
</head>
<body>

<div id="toCg_main">
	<form id="toCg_generate_form" method="post">
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
		<div>
			<label>实体包名:</label>
			<input id="toCg_modelPackage_txt" class="toCg_input_txt" type="text" name="modelPackage" />
		</div>
		<div>
			<label>实体模板基路径:</label>
			<input id="toCg_ftlRoot_txt" class="toCg_input_txt" type="text" name="ftlRoot" />
		</div>
		<div>
			<label>实体模板路径:</label>
			<input id="toCg_ftlFile_txt" class="toCg_input_txt" type="text" name="ftlFile" />
		</div>
		<div>
			<label>输出基路径:</label>
			<input id="toCg_targetRoot_txt" class="toCg_input_txt" type="text" name="targetRoot" />
		</div>
		<div>
			<input id="toCg_submit_btn"  type="button" value="生 成"/>
		</div>
	</form>
	
</div>

<%@include file="/WEB-INF/views/common/commonJs.jsp" %>
<script type="text/javascript" src="${BasePath}/js/common/jquery.form.min.v20130916.js"></script>
<script type="text/javascript" src="${BasePath}/js/codegen/toCodeGen.js"></script>

</body>
</html>