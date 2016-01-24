<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<base href="<%=basePath%>">

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>订餐系统</title>
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>resource/ui/easyui1.4.4/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>resource/ui/easyui1.4.4/themes/icon.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>resource/css/global.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>resource/css/index.css">
		<script type="text/javascript"
			src="<%=basePath%>resource/ui/easyui1.4.4/jquery.min.js">
</script>
		<script type="text/javascript"
			src="<%=basePath%>resource/ui/easyui1.4.4/jquery.easyui.min.js">
</script>

		<body class="easyui-layout">
			<div id="northRegion" data-options="region:'north',border:false">
				<div id="title">OE大区湘菜点餐系统</div>

				<!-- end northRegion-->
			</div>
			<div id="westRegion"
				data-options="region:'west',split:false,title:'导航栏'">

				<ul id="nav-west" class="easyui-tree" data-options="animate:true">
					<li>
						点餐
					</li>
					<li>
						当前菜单
					</li>
					<li>
						饭局管理
					</li>
					<li>
						菜单管理
					</li>
					<li>
						用户管理
					</li>
					<li>
						我的信息
					</li>
				</ul>

				<!-- end westRegion-->
			</div>
			<div id="southRegion" data-options="region:'south',border:true">
				south region

				<!-- end southRegion-->
			</div>
			<div id="centerRegion" data-options="region:'center'">

				<table id="maindata-datagrid">
				</table>
				
				<div id="edit-dlg" buttons="#edit-dlg-button"> 
					 <div class="edit-form-title"> 
				           信息编辑 
				       </div> 
					<form id="edit-form" action="post">
						<input  type="hidden" name="id" />
						<div class="edititem">
					        <label for="description" >名称:</label>
					        <input class="easyui-validatebox" type="text" name="description" required="true"></input>
					    </div>
					    <div class="edititem">
					        <label for="price">价格:</label>
					        <input class="easyui-validatebox" type="text" name="price" required="true" validType="email"></input>
					    </div>
					    <!--
					    <div class="edititem">
					        <label for="subject">类别:</label>
					        <input class="easyui-validatebox" type="text" name="subject" required="true"></input>
					    </div>
					    -->
					    <div class="edititem">
					        <label for="remark">备注:</label>
					        <input class="easyui-validatebox" type="text" name="remark" ></input>
					    </div>
					</form>
				
				</div>
				
				<div id="edit-dlg-button">
					 <a id="edit-dlg-ok" href="javascript:void(0)" class="easyui-linkbutton"  iconcls="icon-save">保存</a> 
        				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#edit-dlg').dialog('close')"
            			iconcls="icon-cancel">取消</a> 
				
				</div>
				<!-- end centerRegion-->
			</div>
			
			<div id="eastRegion" data-options="region:'east',title:'当前菜单'">
				
				<table id="orderinfo-datagrid">
				</table>
			
			<!-- end eastRegion-->
			</div>
		</body>

		<script type="text/javascript">
$(document).ready(function(){
	var editIndex = undefined;
	
	
	$('#orderinfo-datagrid').datagrid({
		url:"<%=basePath%>ordermeal/list",
		method: 'get',
		loadMsg: '正在加载。。。',
		singleSelect:false,
		fit:true,
		checkOnSelect:true,
		selectOnCheck:true,
		pagePosition:'bottom',
		rownumbers: true,
		remoteSort:false,
		showFooter: true,
		striped: true,
		idField:"id",
	    columns:[[
	        {field: '', checkbox:true},
            {title:'id', field:'id', hidden:true},
	        {title:'名称',field:'menu.description', sortable:'true', 
	        	formatter: function(value,row,index){
					return row.menu.description;
				}
			},
	        {title:'价格(元)',field:'menu.price', align: 'right', sortable:'true',
	        	formatter: function(value,row,index){
					return row.menu.price;
				}
	        },
	        {title:'备注',field:'menu.remark', sortable:'false',
	        	formatter: function(value,row,index){
					return row.menu.remark;
				}
	        }
	    ]],
	    toolbar : [
	    	{
				text:'刷新',
				iconCls:'icon-ok',
				handler:function(){$('#orderinfo-datagrid').datagrid('reload');}
			},
			{
				text:'删除',
				iconCls:'icon-remove',
				handler:function(){deleterow('#orderinfo-datagrid', '<%=basePath%>ordermeal/delete');}
			}
		  ]
	});
	
	$('#edit-dlg').dialog({
	    width: 400,
	    height: 230,
	    closed: true,
	    cache: false,
	    href: '',
	    modal: true	    
	});
	
		
	$('#maindata-datagrid').datagrid({
         url:"<%=basePath%>menu/list",
         method: 'get',
         loadMsg: '正在加载。。。',
         singleSelect:false,
         fit:true,
         checkOnSelect:true,
         selectOnCheck:true,
         pagePosition:'bottom',
         rownumbers: true,
         pagination: true,
         pageSize: 50,
    	 pageList: [50, 100, 150, 200],
    	 remoteSort:false,
    	 showFooter: true,
    	 striped: true,
    	 idField:"id",
         columns : [[
              {field: '', checkbox:true},
              {title:'id', field:'id', hidden:true},
              {title:'名称',field:'description', sortable:'true',
              	editor:{type:'validatebox',options:{required:true, validType:'text',  
                    }}
              },
              {title:'价格(元)',field:'price', align: 'right', sortable:'true',
              	editor:{type:'validatebox',options:{required:true, valueField:'price',  
                    textField:'name2'  }}
              },
              {title:'备注',field:'remark', sortable:'false'}
          ]],
          
          toolbar : [{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){submitrow();}
			},{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){insertrow();}
			},
			{
			text:'修改',
			iconCls:'icon-edit',
			handler:function(){editrow();}
			},
			{
			text:'删除',
			iconCls:'icon-remove',
			handler:function(){deleterow('#maindata-datagrid', '<%=basePath%>menu/delete');}
			}
		  ],
         onEndEdit:function(index,row){
            var ed = $(this).datagrid('getEditor', {
                index: id,
                field: 'id'
            });
            alert(ed);
            alert(JSON.stringify(ed));
            alert(ed.target);
            alert(JSON.stringify(ed.target));
            row.productname = $(ed.target).text('id');
        },
        onBeforeEdit:function(index,row){
            row.editing = true;
            $(this).datagrid('refreshRow', index);
        },
        onAfterEdit:function(index,row,changes){
            row.editing = false;
            $(this).datagrid('refreshRow', index);
            var changesstr = JSON.stringify(changes);
            alert(changesstr);
            $.ajax({  
	    type: "get",
	    url:'<%=basePath%>menu/update',
	    contentType: "application/json", 
	    dataType: "json",  
	    data: changesstr  
	} ); 
        },
        onCancelEdit:function(index,row){
            row.editing = false;
            $(this).datagrid('refreshRow', index);
        }
         }); 
	});
	
	function getRowIndex(target){
    var tr = $(target).closest('tr.datagrid-row');
    return parseInt(tr.attr('datagrid-row-index'));
}


function editrow(target){
	var rows = $("#maindata-datagrid").datagrid("getSelections");
	var row = null;
	//alert(row.length);
	//多选的时候，选择最后一个
	if (rows.length > 0)
	{
		row = rows[rows.length - 1]
		$('#edit-dlg').dialog('open').dialog('setTitle', '修改');
        $("#edit-form").form("load", row);
	}
	
	$('#edit-dlg-ok').click(function(){
		var isSuccess = false;
		var isValid = true;
		isValid = $('#edit-form').form('validate');
		isValid = true;
		if (!isValid)
		{
			return;
		}
		
		var valueObj = serializeObject($('#edit-form'));
		var valueStr = JSON.stringify(valueObj);
		//alert(valueStr);
		$.ajax({
			url: '<%=basePath%>menu/update',
			type: "post",
		 	contentType: "application/json", 
		    dataType: "json",  
		    data: valueStr, 
		    success: function(data){
		    	if(data.result == "success"){
		    		alert(row['id']);
		    		$('#maindata-datagrid').datagrid('updaterow', 
		    		{
		    			index:getRowIndex(row),
		    			row: {id:'1', 
		    				description:'1', 
		    				price: '22', 
		    				remark: '1'}});
		    		$('#edit-dlg').dialog('close'); 
		    	}else {
		    		$.messager.alert('提示','提交失败，请重新提交！','info');
		    	}
		    }
		});
	});
	
    
}

function insertrow(){
	$('#edit-dlg').dialog('open').dialog('setTitle', '添加'); 
    $("#edit-form").form("clear");
	
            url = "UserManage.aspx";
            document.getElementById("hidtype").value="submit";
	
	
	
	var row = $('#maindata-datagrid').datagrid('getSelected');
	if (row){
		var index = $('#maindata-datagrid').datagrid('getRowIndex', row);
	} else {
		index = 0;
	}
	
	//$('#maindata-datagrid').datagrid('selectRow',index);
	//$('#maindata-datagrid').datagrid('beginEdit',index);
}

function saverow(target){
	var rowIndex = getRowIndex(target);
	$('#maindata-datagrid').datagrid('endEdit', getRowIndex(target));
	
	var row = $("#maindata-datagrid").datagrid('getRows')[rowIndex];
	var rowstr = JSON.stringify(row);
    row = $("#maindata-datagrid").datagrid('getRows')[rowIndex];
    //alert(rowstr);
    /**$.ajax({  
	    type: "get",
	    url:'<%=basePath%>menu/update',
	    contentType: "application/json", 
	    dataType: "json",  
	    data: rowstr  
	} );*/ 
}

function cancelrow(target){
    $('#maindata-datagrid').datagrid('cancelEdit', getRowIndex(target));
}

function submitrow(){
	var rows = $('#maindata-datagrid').datagrid('getChecked');
	
	if (rows == 0) {
		$.messager.alert('提示','请至少选择一行数据!','info');
		return;
	}
	
	$.messager.confirm('提示','确定要提交？',function(r){
		if(r){
			//转换成json
			var rowstr = JSON.stringify(rows);
			//alert(rowstr);
			//服务端删除数据
			$.ajax({
				url: '<%=basePath%>ordermeal/order',
				type: 'post',
				contentType: "application/json", 
			    dataType: "json",  
			    data: rowstr,
			    success: 
			    	function(data){
                    	if(!data.result){
                    		//alert(data.message);
                    		$.messager.alert('提示', data.message + '被点过了，请重新选择!','info');
                    	}else{
	                    	//撤销选择的行
	                    	$('#maindata-datagrid').datagrid('uncheckAll');
                    	}
                    	//刷新实时菜单界面
					    $('#orderinfo-datagrid').datagrid('reload');
                	}  
			});
		}
	});
}


function deleterow(grid, urlstr){
	var rows = $(grid).datagrid('getSelections');
	
	if (rows == 0) {
		$.messager.alert('提示','请至少选择一行数据!','info');
		return;
	}
	
	$.messager.confirm('提示','确定要删除？',function(r){
		if(r){
			
			//转换成json
			var rowstr = JSON.stringify(rows);
			//alert(rowstr);
			//服务端删除数据
			$.ajax({
				url: urlstr,
				type: 'post',
				contentType: "application/json", 
			    dataType: "json",  
			    data: rowstr  
			});
			
			//删除界面节点
			for (var i = rows.length - 1; i >= 0; i--){
				var index = $(grid).datagrid('getRowIndex',rows[i]);//获取某行的行号
		    	$(grid).datagrid('deleteRow', index);	
			} 	
		}
	});
}

function serializeObject(form){ 
	var o ={}; 
	$.each(form.serializeArray(),function(index){ 
	if(o[this['name']]){ 
	o[this['name']] = o[this['name']] +","+this['value']; 
	}else{ 
	o[this['name']] = this['value']; 
	} 
	}); 
	return o; 	
} 
		</script>
</html>
