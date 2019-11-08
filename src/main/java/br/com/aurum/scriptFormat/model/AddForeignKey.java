package br.com.aurum.scriptFormat.model;

public class AddForeignKey extends Query {

	private String table;
	
	private String column;
	
	private String query;
	
	private String name;
	
	private String columnReferenced;
	
	private String tableReferenced;
	
	private String cascade;
	
	private String comment;
	
	public AddForeignKey() {}
	
	public AddForeignKey withTable(String table) {
		setTable(table);
		return this;
	}
	
	public AddForeignKey withColumn(String column) {
		setColumn(column);
		return this;
	}
	
	public AddForeignKey withQuery(String query) {
		setQuery(query);
		return this;
	}
	
	public AddForeignKey withName(String name) {
		setName(name);
		return this;
	}
	
	public AddForeignKey withColumnReferenced(String columnReferenced) {
		setColumnReferenced(columnReferenced);
		return this;
	}
	
	public AddForeignKey withTableReferenced(String tableReferenced) {
		setTableReferenced(tableReferenced);
		return this;
	}
	
	public AddForeignKey withComment(Integer number) {
		String text = "-- " + number + " Criação da Foreign Key " + getName();
		setComment(text);
		return this;
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColumnReferenced() {
		return columnReferenced;
	}

	public void setColumnReferenced(String columnReferenced) {
		this.columnReferenced = columnReferenced;
	}

	public String getTableReferenced() {
		return tableReferenced;
	}

	public void setTableReferenced(String tableReferenced) {
		this.tableReferenced = tableReferenced;
	}

	public String getCascade() {
		return cascade;
	}

	public void setCascade(String cascade) {
		this.cascade = cascade;
	}
	
}
