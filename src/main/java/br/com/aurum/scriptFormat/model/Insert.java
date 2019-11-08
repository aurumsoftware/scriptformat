package br.com.aurum.scriptFormat.model;

public class Insert {
	
	private String query;
	
	private String table;
	
	private String column;
	
	private String value;
	
	public Insert() {}
	
	public Insert withTable(String table) {
		setTable(table);
		return this;
	}
	
	public Insert withColumn(String column) {
		setColumn(column);
		return this;
	}
	
	public Insert havingValue(String value) {
		setValue(value);
		return this;
	}
	
	public Insert withQuery(String query) {
		setQuery(query);
		return this;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
