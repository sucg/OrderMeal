/**
 * EasyUI datagrid控件通过行对象得到行数
 * @param {Object} target 行对象
 * @return {TypeName} 行数 
 */
function getRowIndex(target){
	var tr = $(target).closest('tr.datagrid-row');
	return parseInt(tr.attr('datagrid-row-index'));
}

/**
  * 序列化Form参数，返回一个对象
  * @param {Object} form
  * @memberOf {TypeName} 
  * @return {TypeName} 
  */
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
