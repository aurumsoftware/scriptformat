package br.com.aurum.scriptFormat.model;

public class Add {

	private String table;
	
	private String column;
	
	private String query;
	
	private String comment;
	
	public Add() {}
	
	public Add withTable(String table) {
		setTable(table);
		return this;
	}
	
	public Add withColumn(String column) {
		setColumn(column);
		return this;
	}
	
	public Add withQuery(String query) {
		setQuery(query);
		return this;
	}
	
	public Add withComment(Integer number) {
		String text = "-- " + number + " Inclusão do campo " + getColumn() + " na tabela " + getTable();
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
	
}
