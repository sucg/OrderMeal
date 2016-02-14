var baseURL = "";
function setBaseURL(url){
	baseURL = url;
}

function hideDialog(){
	$('#edit-dlg').hide();
	$('#edit-dlg-button').hide();
}

function showDialog(){
	$('#edit-dlg').show();
	$('#edit-dlg-button').show();
}

/**
 * DataGrid删除行操作
 * @param {Object} grid
 * @param {Object} urlstr
 * @return {TypeName} 
 */
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
				url: baseURL + urlstr,
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

/**
  * DataGrid 控件提交多行Checked的数据 
  * @return {TypeName} 
  */
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
				url: baseURL + 'ordermeal/order',
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



/**
 * 通过一个dialog表单，添加一条数据，向DataGrid里面插入
 */
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


/**
 * 通过一个dialog来进行DataGrid数据的编辑
 * @param {Object} target
 * @return {TypeName} 
 */
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
			url: baseURL + 'menu/update',
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

/**
 * 初始化dialog控件界面
 */
function initDialog(){
	$('#edit-dlg').dialog({
	    width: 400,
	    height: 230,
	    closed: true,
	    cache: false,
	    href: '',
	    modal: true	    
	});
}


/**
 * 初始化DataGrid
 * @param {Object} value
 * @param {Object} row
 * @param {Object} index
 * @return {TypeName} 
 */
function initOrderinfoDataGrid(){
	
	$('#orderinfo-datagrid').datagrid({
		    url : baseURL + "ordermeal/list", 
		    method : 'get', 
		    loadMsg : '正在加载。。。', 
		    singleSelect : false, 
		    fit : true, 
		    checkOnSelect : true, 
		    selectOnCheck : true, 
		    pagination: false,
		    rownumbers : true, 
		   	remoteSort:false,
		    showFooter : true, 
		    striped : true, 
		    idField : "id",
		    singleSelect:false,
		    columns : [[ {
		    field : '', 
		    checkbox : true
		},{
	        title : 'id', field : 'id', hidden : true
	    },{
	        title : '名称', field : 'menu.description', sortable : 'true', 
	        	formatter : function (value, row, index) {
	            	return row.menu.description;
	        }
	    }, {
	        title : '价格(元)', field : 'menu.price', align : 'right', sortable : 'true', 
	        formatter : function (value, row, index) {
	            return row.menu.price;
	        }
	    },{
	    	title:'点餐人', field : 'userinfo.name',align : 'left', sortable : 'true', 
	    	formatter : function (value, row, index) {
				if (row.userinfo != null) {
					return row.userinfo.name;
				}else {
					return "";
				}	
	        }
	    },{
	        title : '备注', field : 'menu.remark', sortable : 'false',
	        formatter : function (value, row, index){
	            return row.menu.remark;
	        }
	    } ]], toolbar : [ 
	    {
	        text : '刷新', iconCls : 'icon-reload',
	        handler : function ()
	        {
	            $('#orderinfo-datagrid').datagrid('reload');
	        }
	    },
	    {
	        text : '删除', iconCls : 'icon-remove',
	        handler : function ()
	        {
	            deleterow('#orderinfo-datagrid', 'ordermeal/delete');
	        }
	    }] 
	});
}


/**
 * 初始化一个initMainDataGrid
 */
function initMainDataGrid(){
	$('#maindata-datagrid').datagrid({
     url:baseURL + "menu/list",
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
          {title:'名称',field:'description', sortable:'true'
          },
          {title:'价格(元)',field:'price', align: 'right', sortable:'true'
          },
          {title:'备注',field:'remark', sortable:'false'}
      ]]
	}); 
	
}

function login(formObj, messageObj){
	isValid = formObj.form('validate');
	if (!isValid){
		messageObj.text('请填写用户名和密码！');
	}
	
	formObj.form('submit', {
    	onSubmit: function(){
        	messageObj.text('');
    	},
    	success:function(data){
    		var dataObj = eval("("+data+")");
    		if (dataObj.result)
    		{
    			window.location.reload();
    			$('#login-dlg').dialog('close');
    		}
        	messageObj.text(dataObj.message);
    }
});

}

function logout(id){
	$.ajax({
		url: baseURL + 'index/logout',
		type: "post",
	 	contentType: "application/json", 
	    dataType: "json",  
	    data: id, 
	    success: function(data){
	   		 window.location.reload();
		}
	});
}

function datagridToolbarSearch(event, gridObj, ipt){
	if (ipt.val().trim() == "") return;

	if (event && event.keyCode != 13) return;

	gridObj.datagrid('load',{
        'description':ipt.val().trim() 
    });
}

function cancelDatagridToolbarSearch(gridObj, ipt){
	ipt.val("");
	gridObj.datagrid('load',{});
}



