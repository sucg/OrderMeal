package com.glodon.model;

public class QueryEntity  implements java.io.Serializable {
	
	private String[] fieldNames;
	private String[] caclNames;
	private Object[] values;
	
	public QueryEntity() {
		// TODO Auto-generated constructor stub
	}

	public QueryEntity(String[] fieldNames, String[] caclNames, Object[] values) {
		super();
		this.fieldNames = fieldNames;
		this.caclNames = caclNames;
		this.values = values;
	}

	public String[] getFieldNames() {
		return fieldNames;
	}

	public void setFieldNames(String[] fieldNames) {
		this.fieldNames = fieldNames;
	}

	public String[] getCaclNames() {
		return caclNames;
	}

	public void setCaclNames(String[] caclNames) {
		this.caclNames = caclNames;
	}

	public Object[] getValues() {
		return values;
	}

	public void setValues(Object[] values) {
		this.values = values;
	}
	
	
}
